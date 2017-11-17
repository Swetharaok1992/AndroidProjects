package com.example.swetharao.finalproject;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by swetha rao on 4/23/2017.
 */

    public class CustomRow extends BaseAdapter {

        Context theActivity;
        HashMap<Integer,String> temp;

    ArrayAdapter<String> spinneradapter;
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
            TextView nameOfDish = (TextView)newView.findViewById(R.id.nameOfDish);
           // Button delete = (Button)newView.findViewById(R.id.delete);
            final Spinner quantity = (Spinner) newView.findViewById(R.id.spinner);
            TextView price = (TextView) newView.findViewById(R.id.price);
            final CheckBox selectOrder = (CheckBox) newView.findViewById(R.id.checkBox);
           // ImageView dishImage = (ImageView)newView.findViewById(R.id.imageView);
           final EditText qty = (EditText) newView.findViewById(R.id.editText);
           /* dishImage.getLayoutParams().width = 150;
            dishImage.getLayoutParams().height = 150;
            dishImage.requestLayout();*/
            quantity.getLayoutParams().width = 150;
            quantity.getLayoutParams().height = 80;
            quantity.requestLayout();
            String listBuffer[] = (temp.get(i)).split("::");
            nameOfDish.setText(listBuffer[2]);
            price.setText(listBuffer[5] + "$");
            Resources res = theActivity.getResources();
           // int resourceID = res.getIdentifier(listBuffer[4],"drawable",theActivity.getPackageName());
           /* dishImage.setImageResource(resourceID);
            dishImage.setEnabled(false);*/
            List<String> temp1 = new ArrayList<String>();
            temp1.add("1");
            temp1.add("2");
            temp1.add("3");
            temp1.add("4");
            temp1.add("5");
            temp1.add("6+");
            if(Integer.parseInt(listBuffer[3]) < 5) {
                spinneradapter = new ArrayAdapter<String>(theActivity,
                        android.R.layout.simple_spinner_item, temp1);

               // ArrayAdapter myAdap = (ArrayAdapter) quantity.getAdapter(); //cast to an ArrayAdapter
                spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                quantity.setAdapter(spinneradapter);

            }
            selectOrder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectOrder.setChecked(b);
                }
            });

            quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View spinnerView, int position, long l) {

                    switch(position){
                        case 0:
                            quantity.setSelection(position);
                            spinneradapter.notifyDataSetChanged();
                            break;
                        case 1:
                            quantity.setSelection(position);
                            spinneradapter.notifyDataSetChanged();
                            break;
                        case 2:
                            quantity.setSelection(position);
                            spinneradapter.notifyDataSetChanged();
                            break;
                        case 3:
                            quantity.setSelection(position);
                            spinneradapter.notifyDataSetChanged();
                            break;
                        case 4:
                            quantity.setSelection(position);
                            spinneradapter.notifyDataSetChanged();
                            break;
                        case 5:
                           quantity.setVisibility(View.INVISIBLE);
                           qty.setVisibility(View.VISIBLE);
                            break;
                    }


                }



                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            qty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if(!b){

                       if( Integer.parseInt(qty.getText().toString()) < 6){
                           qty.setVisibility(View.INVISIBLE);
                           quantity.setVisibility(View.VISIBLE);
                           quantity.setSelection(Integer.parseInt(qty.getText().toString()) - 1);
                           qty.setText("");
                       }
                    }
                }
            });
           /* delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View deleteView) {

                }
            });*/


            return newView;
        }
    }


