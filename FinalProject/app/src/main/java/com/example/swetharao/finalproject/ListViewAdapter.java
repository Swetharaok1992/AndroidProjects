package com.example.swetharao.finalproject;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by swetha rao on 4/26/2017.
 */

public class ListViewAdapter extends BaseAdapter{
    Context theActivity;
    HashMap<Integer,String> temp;

    ArrayAdapter<String> spinneradapter;
    public ListViewAdapter(Context theActivity, HashMap<Integer,String> listMap) {
        this.theActivity = theActivity;
        this.temp = listMap;
    }

    @Override
    public int getCount() {
        return temp.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView = null;
        LayoutInflater inflater=LayoutInflater.from(theActivity);
        if (view == null) {
            newView = inflater.inflate(R.layout.activity_list_view_value, null, true);
        }
        else {
            newView = view;
        }


        TextView reviewValue = (TextView) newView.findViewById(R.id.reviewText);
        RatingBar reviewRating = (RatingBar) newView.findViewById(R.id.ratingBar2);

       String reviewBuffer[] =  temp.get(i).split("::");

        reviewValue.setText(reviewBuffer[0] + ": " + reviewBuffer[1]);
        reviewRating.setRating(Float.parseFloat(reviewBuffer[2]));
        reviewRating.setEnabled(false);


        return newView;
    }
}

