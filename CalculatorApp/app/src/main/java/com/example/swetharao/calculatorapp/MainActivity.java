package com.example.swetharao.calculatorapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* @author: Swetha Krishnamurthy Rao
   @ID: 1004265
 */
/* This app is used to perform Arithmetic operations on numbers with or without decimal points */
public class MainActivity extends AppCompatActivity {
    /* The views and variables needed to develop this app*/
    TextView number;
    Button clear, one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,multi,division,equal,dot;
    String operation = null,temp = "",result,num;
    StringBuilder build = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        // Getting view based on ID.
        number = (TextView)findViewById(R.id.editText);
        clear = (Button) findViewById(R.id.clear);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.add);
        minus = (Button)findViewById(R.id.minus);
        multi = (Button)findViewById(R.id.multi);
        division = (Button)findViewById(R.id.division);
        equal = (Button)findViewById(R.id.equalTo);
        dot = (Button)findViewById(R.id.dot);
        /* Clear button listener clears the textbox when clicked*/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = "";
                build.setLength(0);
                temp = "";
                result = "";
                number.setText("");
            }
        });
        /* Buttons from zero to nine acts as the operand upon which the operators act.*/
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  num =  (build.append(1)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }


                }
        });
         two.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 num =  (build.append(2)).toString();
                 number.setText(num);
                 if(operation != null && !temp.isEmpty()) {

                     operateOnNumbers(operation,temp,Float.parseFloat(num));
                 }


             }
         });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(3)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(4)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(5)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(6)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(7)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(8)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(9)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(0)).toString();
                number.setText(num);
                if(operation != null && !temp.isEmpty()) {

                    operateOnNumbers(operation,temp,Float.parseFloat(num));
                }

            }
        });
        /* Plus, minus, multi and division operators perform arithmetic operations on the operands.*/
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    operation = "+";
                    build.setLength(0);
                if(number.getText()!= null){
                   temp = number.getText() + "";
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "-";
                build.setLength(0);
                if(number.getText()!= null){
                    temp = number.getText() + "";
                }
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "*";
                build.setLength(0);
                if(number.getText()!= null){
                    temp = number.getText() + "";
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "/";
                build.setLength(0);
                if(number.getText()!= null){
                    temp = number.getText() + "";
                }
            }
        });
        /* Displays the total value on the textbox*/
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!result.isEmpty()){
                    number.setText(result);
                }
            }
        });
        /* Adds decimal point to the numbers*/
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num =  (build.append(".")).toString();
                number.setText(num);
            }
        });
    }
    /* This method performs arithmetic operations */
    public void operateOnNumbers(String operator, String temp,float num){
        float res = 0;
        String resultNew;
     switch (operator){

         case "+":
           res = Float.parseFloat(temp) + num;
             resultNew = res + "";
             result = resultNew.endsWith(".0")? resultNew.split("\\.0")[0] : resultNew ;
             break;
         case "-":
             res = Float.parseFloat(temp) - num;
             resultNew = res + "";
             result = resultNew.endsWith(".0")? resultNew.split("\\.0")[0] : resultNew ;
             break;
         case "*":
             res = Float.parseFloat(temp) * num;
             resultNew = res + "";
             result = resultNew.endsWith(".0")? resultNew.split("\\.0")[0] : resultNew ;
             break;
         case "/":
             res = Float.parseFloat(temp) / num;
             resultNew = res + "";
             result = resultNew.endsWith(".0")? resultNew.split("\\.0")[0] : resultNew ;
             break;


     }

    }
}
