package com.example.swetharao.finalproject;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class mycustomrow extends AppCompatActivity{
    custom_list customAdapter;
    SQL db;
    SQLiteDatabase dbRead, dbWrite;
    TextView num, name, price;
    EditText getqty;
    String c;
    Boolean CheckEditTextEmpty;
    String value;
    Button btn1;
    ImageView image;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycustomrow);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        btn1 = (Button) findViewById(R.id.cartbtn);
        getqty = (EditText) findViewById(R.id.ed); //get the data from the edit text of qty
        value = getqty.getText().toString();

        db = new SQL(mycustomrow.this, "projectdb10.db", null, 1);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();

       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = (TextView) view.findViewById(R.id.name);
                price = (TextView) view.findViewById(R.id.price);
                image = (ImageView) view.findViewById(R.id.img);

                ContentValues val = new ContentValues();
                val.put("username", pref.getString("userName", ""));
                val.put("nameOfDish", name.getText().toString());
                val.put("quantity", getqty.getText().toString());
                val.put("cost", price.getText().toString().replace("$",""));
                val.put("image", image.getId());
                val.put("dateOfOrder", "2017-05-01");
                dbWrite.insert("carts", null, val);
                Toast.makeText(mycustomrow.this,"Added to cart",Toast.LENGTH_SHORT).show();
            }
        });*/


    }

public void CheckEditTextIsEmptyOrNot(String c ){
        if(TextUtils.isEmpty(c)){

        CheckEditTextEmpty = false ;

        }
        else {
        CheckEditTextEmpty = true ;
        }
        }

public void ClearEditTextAfterDoneTask(){

        getqty.getText().clear();

        }
}