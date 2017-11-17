package com.example.swetharao.finalproject;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;

public class list_view extends AppCompatActivity {
    ListView lv;
    custom_list customAdapter;
    SQL db;
    SQLiteDatabase dbRead, dbWrite;
    TextView num, name, price;
    EditText getqty;
    String c;
    View listViewTemp;
    Boolean CheckEditTextEmpty;
    SharedPreferences pref;
    ImageView image;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        lv = (ListView) findViewById(R.id.mylistview);
        btn = (Button) findViewById(R.id.button); //button to go back the main intent
      //  btn1 = (Button) findViewById(R.id.cartbtn);
        getqty = (EditText) findViewById(R.id.ed); //get the data from the edit text of qty


        db = new SQL(list_view.this, "projectdb10.db", null, 1);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();

        String val;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                val = null;
            } else {
                val = extras.getString("id");
            }
        } else {
            val = (String) savedInstanceState.getSerializable("id");
        }

        int cmp = Integer.parseInt(val);
/*
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int g =0 ; g < lv.getCount(); g++) {
                    listViewTemp = lv.getChildAt(g);
                    name = (TextView) listViewTemp.findViewById(R.id.name);
                    price = (TextView) listViewTemp.findViewById(R.id.price);
                    image = (ImageView) listViewTemp.findViewById(R.id.img);

                    ContentValues val = new ContentValues();
                    val.put("username", pref.getString("userName", ""));
                    val.put("nameOfDish", name.getText().toString());
                    val.put("quantity", getqty.getText().toString());
                    val.put("cost", price.getText().toString());
                    val.put("image", image.getId());
                    val.put("dateOfOrder", "2017-05-01");
                    dbWrite.insert("carts", null, val);


                }
            }
        });*/
        if (cmp == 1) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from COCKTAILS ", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }

            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (cmp == 2) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from CHAMPANGE", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }

            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (cmp == 3) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from SODAS", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }

            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (cmp == 4) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from REDWINES", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }
            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (cmp == 5) {

            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from WHITEWINES", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }
            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (cmp == 6) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from GRAPEWINES", null);
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                for (int i = 0; i < cursor.getCount(); i++) {

                    listMap.put(i, cursor.getString(cursor.getColumnIndex("name")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("cost")) + "\n" +
                            cursor.getString(cursor.getColumnIndex("img")));

                    cursor.moveToNext();
                }
            }
            customAdapter = new custom_list(this, listMap);
            lv.setAdapter(customAdapter);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(list_view.this, MyFirstPage.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }

       // HashMap<Integer, String> listMap = new HashMap<Integer, String>();

    }

}




