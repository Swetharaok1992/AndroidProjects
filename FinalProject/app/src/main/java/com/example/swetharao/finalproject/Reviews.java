package com.example.swetharao.finalproject;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.HashMap;

public class Reviews extends AppCompatActivity {
    SQLiteDatabase dbNew,dbWrite;
    SQL db;
    HashMap<Integer,String> listMap = new HashMap<Integer, String>();
    ListViewAdapter adp;
    ListView list;
    EditText reviewValue;
    RatingBar rate;
    boolean rated = false, value = false;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        list = (ListView)findViewById(R.id.reviewList);
        reviewValue = (EditText)findViewById(R.id.reviewBox);
        rate = (RatingBar)findViewById(R.id.ratingBar);
        db = new SQL(this,"projectdb10.db",null,1);
        dbWrite = db.getWritableDatabase();
        dbNew = db.getReadableDatabase();
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(b){
                    rated = true;
                    if(value){
                       value = false;
                        ContentValues val2 = new ContentValues();
                        val2.put("username",pref.getString("userName",""));
                        val2.put("reviewText",reviewValue.getText().toString());
                        val2.put("reviewBar",rate.getRating());
                        dbWrite.insert("reviews",null,val2);
                        sendList();
                        reviewValue.setText("Write a review");
                        rate.setRating(0.0f);
                    }
                    else{
                        Toast.makeText(Reviews.this,"Please write a review for our restaurant.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        reviewValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.d("focus",b + "");
                if(!b) {
                    value = true;
                    if (rated) {
                        rated = false;
                        ContentValues val1 = new ContentValues();
                        val1.put("username", pref.getString("userName",""));
                        val1.put("reviewText", reviewValue.getText().toString());
                        val1.put("reviewBar", rate.getRating());
                        dbWrite.insert("reviews", null, val1);
                      sendList();
                        reviewValue.setText("Write a review");
                        rate.setRating(0.0f);
                    }
                }
                    else{
                        Toast.makeText(Reviews.this,"Please rate our restaurant.",Toast.LENGTH_SHORT).show();
                    }

            }
        });
         ContentValues val = new ContentValues();
        val.put("username","123456");
        val.put("reviewText","The service is really good. I love this place.");
        val.put("reviewBar","4");
        dbWrite.insert("reviews",null,val);
          sendList();

    }

    public void sendList(){
        Cursor cursor1 = dbNew.rawQuery("Select * from reviews;",null);
        cursor1.moveToFirst();

        if (cursor1.getCount()>0) {
            for (int i = 0; i < cursor1.getCount(); i++) {
                listMap.put(i,cursor1.getString(cursor1.getColumnIndex("userName")) + "::" +
                        cursor1.getString(cursor1.getColumnIndex("reviewText")) + "::" +
                        cursor1.getString(cursor1.getColumnIndex("reviewBar")));

                cursor1.moveToNext();
            }

            if (cursor1 != null && !cursor1.isClosed()) {
                cursor1.close();
            }
            /*if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }*/
        }

        adp = new ListViewAdapter(Reviews.this,listMap);
        list.setAdapter(adp);
    }
}
