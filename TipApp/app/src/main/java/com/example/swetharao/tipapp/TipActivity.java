package com.example.swetharao.tipapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
/* @author: Swetha Krishnamurthy Rao
   @UBID: 1004265
 */
//This app is used to calculate the tip amount based on the total specified.
public class TipActivity extends AppCompatActivity {
    //The reference of the view needed to make this app work
    TextView total,tax,five,ten,custom,value;
    Button calculate;
    SeekBar sbar;
    int sValue = 11;// Default value is 11 if the user has not used the seek bar.
    double totalValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Based on the id, the view of the activity is obtained. */
        setContentView(R.layout.activity_tip);
        total = (TextView) findViewById(R.id.editText);
        tax = (TextView) findViewById(R.id.editText2);
        calculate = (Button)findViewById(R.id.calculate);
        sbar = (SeekBar) findViewById(R.id.seekBar);
        five = (TextView)findViewById(R.id.five);
        ten = (TextView)findViewById(R.id.ten);
        value = (TextView)findViewById(R.id.seekValue);
        custom = (TextView)findViewById(R.id.custom);
        sbar.setMax(39);// The seek bar values range from 11 to 50. By default the seek bar value is 0. Therefore, adding 11 to the value gets the desired result. 39+11 =50 which is the upperlimit for the seek bar.
        sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {//Listener on change of seek bar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             sValue = progress + 11;
             value.setText(sValue+"");// Display the value of the seek bar for user's to view.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        /* On clicking calculate, this listener is triggered.*/
        calculate.setOnClickListener(new View.OnClickListener() {
            Double withFive, withTen, withCustom;
            @Override
            public void onClick(View v) {

                totalValue = Double.parseDouble((total.getText()).toString());// Get the total value from the textbox.
                withFive = (totalValue*0.05)+totalValue;//Calculate 5% tip amount with total.
                withTen = (totalValue*0.10)+totalValue;//Calculate 10% tip amount with total.
                withCustom = (totalValue*(sValue/100.0))+totalValue;//Calculate custom amount with total based on the seek bar value.
                /* Display the values in the corresponding TextView. */
                five.setText(withFive+"");
                ten.setText(withTen+"");
                custom.setText(withCustom+"");
            }
        });
    }
}
