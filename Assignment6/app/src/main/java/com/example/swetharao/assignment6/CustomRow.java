package com.example.swetharao.assignment6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by swetha rao on 4/15/2017.
 */

public class CustomRow extends BaseAdapter {

    Context theActivity;
    HashMap<Integer,String> temp;

    public CustomRow(Context theActivity, HashMap<Integer,String> listMap) {
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
/*  Set the images for imageView and text for textview to the listview */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView = null;
        LayoutInflater inflater=LayoutInflater.from(theActivity);
        if (view == null) {
            newView = inflater.inflate(R.layout.activity_main2, null, true);
        }
        else {
           newView = view;
        }
            TextView nameText = (TextView)newView.findViewById(R.id.name);
            TextView ageText = (TextView)newView.findViewById(R.id.age);
            TextView salaryText = (TextView)newView.findViewById(R.id.salary);
            TextView foodText = (TextView)newView.findViewById(R.id.food);
            TextView food2Text = (TextView)newView.findViewById(R.id.food2);
            ImageView colorImg = (ImageView)newView.findViewById(R.id.color);
            ImageView genderImg = (ImageView)newView.findViewById(R.id.gender);
            ImageView dietImg = (ImageView)newView.findViewById(R.id.diet);
            String listBuffer[] = (temp.get(i)).split("::");
            genderImg.getLayoutParams().width = 80;
            genderImg.getLayoutParams().height = 80;
            genderImg.requestLayout();
            dietImg.getLayoutParams().width = 80;
            dietImg.getLayoutParams().height = 80;
            dietImg.requestLayout();
            colorImg.getLayoutParams().width = 60;
            colorImg.getLayoutParams().height = 60;
            colorImg.requestLayout();

            nameText.setText(listBuffer[0]);
            ageText.setText(listBuffer[1]);
            foodText.setText(listBuffer[4]);
            food2Text.setText(listBuffer[5]);
            salaryText.setText(listBuffer[7]);
            switch(listBuffer[2]){
                case "yellow":
                    colorImg.setColorFilter(theActivity.getResources().getColor(R.color.colorYellow));
                    colorImg.setBackgroundColor(theActivity.getResources().getColor(R.color.colorYellow));
                    break;
                case "red":
                    colorImg.setColorFilter(theActivity.getResources().getColor(R.color.colorRed));
                    colorImg.setBackgroundColor(theActivity.getResources().getColor(R.color.colorRed));
                    break;
                case "blue":
                    colorImg.setColorFilter(theActivity.getResources().getColor(R.color.colorBlue));
                    colorImg.setBackgroundColor(theActivity.getResources().getColor(R.color.colorBlue));
                    break;

                case "orange":
                    colorImg.setColorFilter(theActivity.getResources().getColor(R.color.colorOrange));
                    colorImg.setBackgroundColor(theActivity.getResources().getColor(R.color.colorOrange));
                    break;
                case "green":
                    colorImg.setColorFilter(theActivity.getResources().getColor(R.color.colorGreen));
                    colorImg.setBackgroundColor(theActivity.getResources().getColor(R.color.colorGreen));
                    break;

            }

            switch(listBuffer[3]){
                case "vegetarian":
                    dietImg.setImageResource(R.drawable.vegetarian);
                    break;
                case "poultry":
                    dietImg.setImageResource(R.drawable.poultry);
                    break;
                case "redMeat":
                    dietImg.setImageResource(R.drawable.redmeat);
                    break;

        }
            switch(listBuffer[6]){
                case "female":
                    genderImg.setImageResource(R.drawable.female);
                    break;
                case "male":
                    genderImg.setImageResource(R.drawable.male);
                    break;
            }



        return newView;
    }
}
