package com.example.swetharao.finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by swetha rao on 4/25/2017.
 */
/* My order data from database is retrieved here.*/
public class ExplandableOrderList {

    public static HashMap<String, List<MyOrders>> getData(SQL db) throws ParseException {
        MyOrders order = new MyOrders();
        List<MyOrders> listOrder = new ArrayList<MyOrders>();
        Date d ;
        SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, List<MyOrders>> expandableListDetail = new HashMap<String, List<MyOrders>>();
        SQLiteDatabase dbRead = db.getWritableDatabase();
        Cursor cursor = dbRead.rawQuery("SELECT * FROM orders;",null);

        cursor.moveToFirst();
        if(cursor.getCount() > 1){
            for(int i = 0 ; i < cursor.getCount() ; i++){

                order.setNameOfDish(cursor.getString(cursor.getColumnIndex("nameOfDish")));
                d = dateF.parse((cursor.getString(cursor.getColumnIndex("dateOfOrder"))).toString());
                order.setDate(d);
                order.setImage(cursor.getString(cursor.getColumnIndex("image")));
                order.setPrice(cursor.getString(cursor.getColumnIndex("cost")));
                order.setQuantity(cursor.getString(cursor.getColumnIndex("quantity")));
                cursor.moveToNext();
                listOrder.add(order);
            }
        }

        for(MyOrders ord : listOrder){
            String dateOrders = dateF.format(ord.getDate());
            if(expandableListDetail.containsKey(dateOrders)){
                List<MyOrders> temp = expandableListDetail.get(dateOrders);
                temp.add(ord);
            }
            else{
                List<MyOrders> temp = new ArrayList<MyOrders>();
                temp.add(ord);
                expandableListDetail.put(dateOrders,temp);
            }
        }

        return expandableListDetail;
    }
}
