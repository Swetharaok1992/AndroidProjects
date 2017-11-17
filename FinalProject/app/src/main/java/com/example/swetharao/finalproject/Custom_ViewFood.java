package com.example.swetharao.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

public class Custom_ViewFood extends AppCompatActivity {
    ListView lv;
    custom_list customAdapter;
    SQL db;
    SQLiteDatabase dbRead, dbWrite;
    TextView num, name, price;
    EditText getqty;
    String c;
    Boolean CheckEditTextEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__view_food);
        ListView lv = (ListView) findViewById(R.id.mylistview);
        Button btn = (Button) findViewById(R.id.button);
        Button btn1 = (Button) findViewById(R.id.cartbtn);
        getqty = (EditText) findViewById(R.id.ed); //get the data from the edit text of qty


        db = new SQL(Custom_ViewFood.this, "projectdb10.db", null, 1);
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();

        Intent intent = getIntent();                  //getting data from each onclick of button and checking and enters the if loop
        String val = intent.getStringExtra("id");
        int a = Integer.parseInt(val);

        if (a == 1) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from sides", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (a == 2) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from soups", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (a == 3) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from chef_special", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (a == 4) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from starters", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (a == 5) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from Desserts", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }
        if (a == 6) {
            HashMap<Integer, String> listMap = new HashMap<Integer, String>();
            Cursor cursor = dbRead.rawQuery("select * from Main_course", null);
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
                    Intent intent = new Intent(Custom_ViewFood.this, MainActivity.class);
                    intent.putExtra("1", 10);
                    startActivityForResult(intent, 100);
                }
            });
        }

        //Database to enter the data value to MENU Table (complete table )

   /*     btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                c = getqty.getText().toString();
                CheckEditTextIsEmptyOrNot(c);

                if(CheckEditTextEmpty == true)
                {

                    db.execSQL("INSERT INTO MENU (uname,name,cost,qty,date) VALUES ('abc', 'null', 'null',"+c+"','null')");

                    Toast.makeText(custom_view.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

                    ClearEditTextAfterDoneTask();

                }
                else {

                    Toast.makeText(custom_view.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
                }

            }
        });
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

        }*/
    }


}
