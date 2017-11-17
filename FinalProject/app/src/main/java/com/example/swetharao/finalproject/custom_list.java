package com.example.swetharao.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by veera on 4/30/2017.
 */

public class custom_list  extends BaseAdapter  {
    Context theActivity;
    HashMap<Integer, String> Mapper;
    TextView name,price;
    EditText getqty;
    ImageView image;
    SharedPreferences pref;
    SQL db;
    SQLiteDatabase dbRead, dbWrite;
    holder h;


    public  static class holder {
        TextView num, name, price;
        Button cart;
        EditText qty;
        ImageView img;
    }

    public custom_list(Context ctx, HashMap<Integer, String> Map) {

        theActivity = ctx;
        Mapper = Map;
    }


    @Override
    public int getCount() {
        return Mapper.size();
    }

    @Override
    public Object getItem(int i) {
        return null;

    }

    @Override
    public long getItemId(int i) {

        return 0;
    }


    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        String s = Mapper.get(pos);
        String[] a = s.split("\n");
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(theActivity);
            view = inflater.inflate(R.layout.activity_mycustomrow, null, true);
            h=new holder();
            h.num=(TextView)view.findViewById(R.id.no);
            h.img = (ImageView) view.findViewById(R.id.img);
            h. name = (TextView) view.findViewById(R.id.name);
            h.price = (TextView) view.findViewById(R.id.price);
            h.cart= (Button) view.findViewById(R.id.cartbtn);
            h.qty = (EditText) view.findViewById(R.id.ed);
            h.qty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b) {
                        pref = theActivity.getSharedPreferences("sessionVariable", theActivity.MODE_PRIVATE);
                        pref.edit().putString("qty", ((EditText)view.findViewById(R.id.ed)).getText().toString()).commit();
                    }
                }
            });
            h.cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*name = (TextView) view.findViewById(R.id.name);
                    price = (TextView) view.findViewById(R.id.price);
                    getqty = (EditText)view.findViewById(R.id.ed);
                    image = (ImageView) view.findViewById(R.id.img);*/
                    db = new SQL(theActivity, "projectdb10.db", null, 1);
                    dbRead = db.getReadableDatabase();
                    dbWrite = db.getWritableDatabase();
                    pref = theActivity.getSharedPreferences("sessionVariable", theActivity.MODE_PRIVATE);
                    ContentValues val = new ContentValues();
                    val.put("username", pref.getString("userName", ""));
                    val.put("nameOfDish", (h.name).getText().toString());
                    val.put("quantity",  pref.getString("qty", ""));
                    val.put("cost", (h.price).getText().toString().replace("$",""));
                    val.put("image", (h.img).getId());
                    val.put("dateOfOrder", "2017-05-01");
                    dbWrite.insert("cart", null, val);
                    Toast.makeText(theActivity,"Added to cart",Toast.LENGTH_SHORT).show();
                }
            });
            h.qty=(EditText)view.findViewById(R.id.ed);
            view.setTag(h);

        }
        else
        {
            h=(holder) view.getTag();
        }

        h.num.setText(pos+" ");
        h.name.setText(a[0]);
        h. price.setText(a[1]);
        int f = Integer.parseInt(a[2]);
        h.img.setImageResource(f);
        h.qty.getText().toString();
        return view;
    }

}
