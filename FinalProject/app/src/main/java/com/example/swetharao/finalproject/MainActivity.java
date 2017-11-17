package com.example.swetharao.finalproject;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/*
 * @Author: Swetha Krishnamurthy Rao
 * @UBID: 1004265
 */
/* This activity loads the Add cart page */
public class MainActivity extends AppCompatActivity {
    SQLiteDatabase dbNew,dbWrite;
    SQL db;
    ListView list;
    HashMap<Integer,String> listMap = new HashMap<Integer,String>();
    CustomRow row ;
    Button order,confirm;
    String trackNumber ;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static int number = 1821;
    EditText mobNumber;


    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        listMap.clear();
        db = new SQL(this,"projectdb10.db",null,1);
        mobNumber = (EditText) findViewById(R.id.phoneNumber);
        confirm = (Button) findViewById(R.id.Confirm);
        dbWrite = db.getWritableDatabase();
        dbNew = db.getReadableDatabase();
        list = (ListView) findViewById(R.id.cartList);
        order = (Button)findViewById(R.id.button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage((mobNumber.getText()).toString(), null,"Your order has been placed. Tracking number: " + trackNumber, null, null);

                Intent i = new Intent(MainActivity.this,MyFirstPage.class);
                startActivity(i);

            }
        });
      /*  ContentValues val = new ContentValues();
        val.put("username","123456");
        val.put("nameOfDish","Garden Salad");
        val.put("quantity","1");
        val.put("cost","3.99");
        val.put("image","gardensalad");
        val.put("dateOfOrder","2017-04-23");
        dbWrite.insert("cart",null,val);*/
       // dbWrite.close();
      // Cursor cursor = dbWrite.rawQuery("insert into cart (userName,nameOfDish,quantity,cost,dateOfOrder) values('123456','Garden Salad','1','3.99','2017-04-23');",null);

        order.setOnClickListener(new View.OnClickListener() {
            View listViewTemp;
            CheckBox box;
            TextView nameOfDish, price;
            ImageView image;
            EditText txt;
            int qty;
            Spinner spin;
            @Override
            public void onClick(View view) {
                for(int g =0 ; g < list.getCount(); g++){
                    listViewTemp =  list.getChildAt(g);
                    if(listViewTemp != null) {
                        box = (CheckBox) listViewTemp.findViewById(R.id.checkBox);
                        nameOfDish = (TextView) listViewTemp.findViewById(R.id.nameOfDish);
                        price = (TextView) listViewTemp.findViewById(R.id.price);
                        spin = (Spinner) listViewTemp.findViewById(R.id.spinner);
                        txt = (EditText) listViewTemp.findViewById(R.id.editText);
                        //image = (ImageView)listViewTemp.findViewById(R.id.imageView);
                        if (spin.getVisibility() == View.VISIBLE) {
                            Log.d("selected", spin.getSelectedItem().toString());
                            qty = Integer.parseInt(spin.getSelectedItem().toString());
                        } else if (txt.getVisibility() == View.VISIBLE) {
                            Log.d("selected", txt.getText().toString());
                            qty = Integer.parseInt(txt.getText().toString());
                        }

                        Date date = new Date();
                        trackNumber = pref.getString("userName", "") + "" + (number);
                        if (box.isChecked()) {
                            ContentValues val = new ContentValues();
                            val.put("username", pref.getString("userName", ""));
                            val.put("nameOfDish", (String) nameOfDish.getText());
                            val.put("quantity", qty);
                            val.put("cost", Float.parseFloat(((String) price.getText()).replace("$", "")) * qty);
                            val.put("image", "123456");
                            val.put("dateOfOrder", sdf.format(date));
                            val.put("trackId", trackNumber);
                            dbWrite.insert("orders", null, val);


                        }

                    }

                }
                list.setVisibility(View.INVISIBLE);
                //list.setAdapter(null);
                //list.setEnabled(false);
                order.setVisibility(View.INVISIBLE);
                mobNumber.setVisibility(View.VISIBLE);
                confirm.setEnabled(true);
                confirm.setVisibility(View.VISIBLE);

                number++;

            }
        });


        Cursor cursor1 = dbNew.rawQuery("Select * from cart;",null);
        cursor1.moveToFirst();

        if (cursor1.getCount()>0) {
            for (int i = 0; i < cursor1.getCount(); i++) {
               listMap.put(i,cursor1.getString(cursor1.getColumnIndex("orderId")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("userName")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("nameOfDish")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("quantity")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("image")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("cost")) + "::" +
                       cursor1.getString(cursor1.getColumnIndex("dateOfOrder")));

                cursor1.moveToNext();
            }

            if (cursor1 != null && !cursor1.isClosed()) {
                cursor1.close();
            }
            /*if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }*/
        }

        row = new CustomRow(MainActivity.this,listMap);
        list.setAdapter(row);

    }

}
