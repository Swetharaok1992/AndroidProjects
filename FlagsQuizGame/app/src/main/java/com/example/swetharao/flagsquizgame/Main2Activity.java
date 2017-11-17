package com.example.swetharao.flagsquizgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

/*
 @Author: Swetha Krishnamurthy Rao
 @UBID: 1004265
 */
public class Main2Activity extends AppCompatActivity {
 ImageView iv1,iv2,iv3,iv4;
    TextView counter,result,text;
    Button b1,b2,b3,b4,correctButton;
    int width, height, question = 1,correct = 0,incorrect = 0;
    AssetManager mgr;
    Intent tent;
    String[] listIntent;
    String[] flagListFolder1, flagListFolder2, flagListFolder3, flagListFolder4;
    int f1, f2, f3, f4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tent = getIntent();
        /* IDs of all the views*/
        counter = (TextView) findViewById(R.id.counter);
        result = (TextView) findViewById(R.id.result);
        text = (TextView) findViewById(R.id.text);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        listIntent = ((tent.getStringExtra("Regions")).toString()).split(",");//get selected values.
        mgr = getAssets();
        try {
            flagListFolder1 = mgr.list(listIntent[0]);
            f1 = (flagListFolder1.length)-1;
            flagListFolder2 = mgr.list(listIntent[1]);
            f2 = (flagListFolder2.length)-1;
            flagListFolder3 = mgr.list(listIntent[2]);
            f3 = (flagListFolder3.length)-1;
            flagListFolder4 = mgr.list(listIntent[3]);
            f4 = (flagListFolder4.length)-1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayImage();
        setHorizontals();
        final Animation.AnimationListener rotateListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {

                question++;
                if(question <= 10) {
                    setHorizontals();//set layout
                    displayImage();//set images
                }
                else{
                    /* alert to show the number of questions answered incorrectly */
                    AlertDialog.Builder build = new AlertDialog.Builder(Main2Activity.this);
                    build.setTitle("RESULTS");
                    build.setMessage("Number of Questions answered incorrectly: "+incorrect);
                    build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog done = build.create();
                    done.show();
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        final Animation.AnimationListener shakeListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                question++;
                if(question <= 10) {
                    setHorizontals();//set layout
                    displayImage();// set images
                }
                else{
                    /* alert to show the number of questions answered incorrectly */
                    AlertDialog.Builder build = new AlertDialog.Builder(Main2Activity.this);
                    build.setTitle("RESULTS");
                    build.setMessage("Number of Questions answered incorrectly: "+incorrect);
                    build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                            startActivity(intent);                        }
                    });
                    AlertDialog done = build.create();
                    done.show();
                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        final Animation rotate = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.rotate);
        rotate.setAnimationListener(rotateListener);

        final Animation shake = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.shake);
        shake.setAnimationListener(shakeListener);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(answerCheck(question,1)){

                 if(question % 2 == 0){
                     b1.setEnabled(false);
                     b2.setEnabled(false);
                     b3.setEnabled(false);
                     b4.setEnabled(false);
                     iv1.startAnimation(rotate);
                 }
                 else{
                     b1.startAnimation(rotate);
                 }

             }
                else{
                 if(question % 2 == 0){
                     b1.setEnabled(false);
                     b2.setEnabled(false);
                     b3.setEnabled(false);
                     b4.setEnabled(false);
                     iv1.startAnimation(shake);
                 }
                 else {
                     b2.setEnabled(false);
                     b3.setEnabled(false);
                     b4.setEnabled(false);
                     b1.startAnimation(shake);
                 }

             }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerCheck(question,2)){
                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(rotate);
                    }
                    else {
                        b2.startAnimation(rotate);
                    }
                }
                else{
                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(shake);
                    }
                    else {
                        b1.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        b2.startAnimation(shake);
                    }


                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerCheck(question,3)){

                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(rotate);
                    }
                    else {
                         b3.startAnimation(rotate);
                    }

                }
                else{

                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(shake);
                    }
                    else {
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b4.setEnabled(false);
                        b3.startAnimation(shake);
                    }


                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerCheck(question,4)){
                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(rotate);
                    }
                    else {
                        b4.startAnimation(rotate);
                    }

                }

                else{
                    if(question % 2 == 0){
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.setEnabled(false);
                        iv1.startAnimation(shake);
                    }
                    else {
                        b1.setEnabled(false);
                        b2.setEnabled(false);
                        b3.setEnabled(false);
                        b4.startAnimation(shake);
                    }

                }

            }
        });

    }
    void setHorizontals()
    {
        counter.setText("Question " + question + " of 10:");
        result.setText("");
        counter.setTextSize(18);
        counter.setTextColor(Color.BLACK);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);


        FrameLayout.LayoutParams count = new FrameLayout.LayoutParams((int)(width * .4),(int)(height * .1));
        count.setMargins((int)(width * .1), (int)(height* .1), 0, 0);
        counter.setLayoutParams(count);

        FrameLayout.LayoutParams res = new FrameLayout.LayoutParams((int)(width * .3),(int)(height * .1));
        res.setMargins((int)(width * .4), (int)(height*0.2) , 0, 0);
        result.setLayoutParams(res);

        FrameLayout.LayoutParams image1 = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        image1.setMargins((int)(width * .1), (int)(height*0.25) , 0, 0);
        iv1.setLayoutParams(image1);

        iv2.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams image2 = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        image2.setMargins((int)(width * .6), (int)(height*0.25) , 0, 0);
        iv2.setLayoutParams(image2);

        iv3.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams image3 = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        image3.setMargins((int)(width * .1), (int)(height*0.40) , 0, 0);
        iv3.setLayoutParams(image3);

        iv4.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams image4 = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        image4.setMargins((int)(width * .6),(int)(height*0.40) , 0, 0);
        iv4.setLayoutParams(image4);

        FrameLayout.LayoutParams tex = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        tex.setMargins((int)(width * .4),(int)(height*0.55) , 0, 0);
        text.setLayoutParams(tex);

        FrameLayout.LayoutParams but1 = new FrameLayout.LayoutParams((int)(width * .3),(int)(height*0.075));
        but1.setMargins((int)(width * .1), (int)(height*0.6) , 0,0 );
        b1.setLayoutParams(but1);

        FrameLayout.LayoutParams but2 = new FrameLayout.LayoutParams((int)(width * .3),(int)(height*0.075));
        but2.setMargins((int)(width * .6), (int)(height*0.6), 0,0 );
        b2.setLayoutParams(but2);

        FrameLayout.LayoutParams but3 = new FrameLayout.LayoutParams((int)(width * .3),(int)(height*0.075));
        but3.setMargins((int)(width * .1), (int)(height*0.675) , 0,0 );
        b3.setLayoutParams(but3);

        FrameLayout.LayoutParams but4 = new FrameLayout.LayoutParams((int)(width * .3),(int)(height*0.075));
        but4.setMargins((int)(width * .6), (int)(height*0.675), 0,0 );
        b4.setLayoutParams(but4);

    }

    public void displayImage(){

        try {

            if(question % 2 == 1){
                text.setText("Select Region: ");
                text.setTextSize(18);
                text.setTextColor(Color.BLACK);
                switch(question){
                    case 1:
                        if (f1 >= 4) {
                            InputStream image1 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image2 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image3 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image4 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;

                            Drawable drawable1 = Drawable.createFromStream(image1, null);
                            Drawable drawable2 = Drawable.createFromStream(image2, null);
                            Drawable drawable3 = Drawable.createFromStream(image3, null);
                            Drawable drawable4 = Drawable.createFromStream(image4, null);

                            iv1.setImageDrawable(drawable1);
                            iv2.setImageDrawable(drawable2);
                            iv3.setImageDrawable(drawable3);
                            iv4.setImageDrawable(drawable4);

                            b1.setText(listIntent[2]);
                            b2.setText(listIntent[1]);
                            b3.setText(listIntent[0]);
                            b4.setText(listIntent[3]);
                        }
                        break;
                    case 9:
                        if (f1 >= 4) {
                            InputStream image1 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image2 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image3 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;
                            InputStream image4 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
                            --f1;

                            Drawable drawable1 = Drawable.createFromStream(image1, null);
                            Drawable drawable2 = Drawable.createFromStream(image2, null);
                            Drawable drawable3 = Drawable.createFromStream(image3, null);
                            Drawable drawable4 = Drawable.createFromStream(image4, null);

                            iv1.setImageDrawable(drawable1);
                            iv2.setImageDrawable(drawable2);
                            iv3.setImageDrawable(drawable3);
                            iv4.setImageDrawable(drawable4);

                            b1.setText(listIntent[2]);
                            b2.setText(listIntent[1]);
                            b3.setText(listIntent[0]);
                            b4.setText(listIntent[3]);
                        }
                        break;
                    case 3:
                        if (f2 >= 4) {
                            InputStream image1 = mgr.open(listIntent[1] + "/" + flagListFolder2[f2]);
                            --f2;
                            InputStream image2 = mgr.open(listIntent[1] + "/" + flagListFolder2[f2]);
                            --f2;
                            InputStream image3 = mgr.open(listIntent[1] + "/" + flagListFolder2[f2]);
                            --f2;
                            InputStream image4 = mgr.open(listIntent[1] + "/" + flagListFolder2[f2]);
                            --f2;

                            Drawable drawable1 = Drawable.createFromStream(image1, null);
                            Drawable drawable2 = Drawable.createFromStream(image2, null);
                            Drawable drawable3 = Drawable.createFromStream(image3, null);
                            Drawable drawable4 = Drawable.createFromStream(image4, null);

                            iv1.setImageDrawable(drawable1);
                            iv2.setImageDrawable(drawable2);
                            iv3.setImageDrawable(drawable3);
                            iv4.setImageDrawable(drawable4);

                            b1.setText(listIntent[0]);
                            b2.setText(listIntent[3]);
                            b3.setText(listIntent[2]);
                            b4.setText(listIntent[1]);
                        }
                        break;

                    case 5:
                        if(f3 >=4) {
                            InputStream image1 = mgr.open(listIntent[2] + "/" + flagListFolder3[f3]);
                            --f3;
                            InputStream image2 = mgr.open(listIntent[2] + "/" + flagListFolder3[f3]);
                            --f3;
                            InputStream image3 = mgr.open(listIntent[2] + "/" + flagListFolder3[f3]);
                            --f3;
                            InputStream image4 = mgr.open(listIntent[2] + "/" + flagListFolder3[f3]);
                            --f3;

                            Drawable drawable1 = Drawable.createFromStream(image1, null);
                            Drawable drawable2 = Drawable.createFromStream(image2, null);
                            Drawable drawable3 = Drawable.createFromStream(image3, null);
                            Drawable drawable4 = Drawable.createFromStream(image4, null);

                            iv1.setImageDrawable(drawable1);
                            iv2.setImageDrawable(drawable2);
                            iv3.setImageDrawable(drawable3);
                            iv4.setImageDrawable(drawable4);

                            b1.setText(listIntent[2]);
                            b2.setText(listIntent[1]);
                            b3.setText(listIntent[0]);
                            b4.setText(listIntent[3]);

                        }
                        break;
                    case 7:
                        if (f4 >= 4) {
                            InputStream image1 = mgr.open(listIntent[3] + "/" + flagListFolder4[f4]);
                            --f4;
                            InputStream image2 = mgr.open(listIntent[3] + "/" + flagListFolder4[f4]);
                            --f4;
                            InputStream image3 = mgr.open(listIntent[3] + "/" + flagListFolder4[f4]);
                            --f4;
                            InputStream image4 = mgr.open(listIntent[3] + "/" + flagListFolder4[f4]);
                            --f4;

                            Drawable drawable1 = Drawable.createFromStream(image1, null);
                            Drawable drawable2 = Drawable.createFromStream(image2, null);
                            Drawable drawable3 = Drawable.createFromStream(image3, null);
                            Drawable drawable4 = Drawable.createFromStream(image4, null);

                            iv1.setImageDrawable(drawable1);
                            iv2.setImageDrawable(drawable2);
                            iv3.setImageDrawable(drawable3);
                            iv4.setImageDrawable(drawable4);

                            b1.setText(listIntent[0]);
                            b2.setText(listIntent[1]);
                            b3.setText(listIntent[3]);
                            b4.setText(listIntent[2]);
                        }
                        break;
                }
            }

            if(question % 2 == 0){
                text.setText("Select Name: ");
                text.setTextSize(18);
                text.setTextColor(Color.BLACK);
                singleFlag(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
/* Load questions with single flag in the center*/
    public void singleFlagLoad(){
        FrameLayout.LayoutParams layout1 = new FrameLayout.LayoutParams((int)(width * .30),(int)(height*0.15));
        layout1.setMargins((int)(width * .35), (int)(height*0.25) , 0, 0);
        iv1.setLayoutParams(layout1);
    }
    public void singleFlag(int quesNumber) throws IOException {
     switch(quesNumber){
         case 2:
             InputStream image4 = mgr.open(listIntent[3] + "/" + flagListFolder4[f4]);
             Drawable drawable4 = Drawable.createFromStream(image4, null);
             singleFlagLoad();
             iv1.setImageDrawable(drawable4);
             iv2.setVisibility(View.INVISIBLE);
             iv3.setVisibility(View.INVISIBLE);
             iv4.setVisibility(View.INVISIBLE);
             b1.setText((((listIntent[3] + "/" + flagListFolder4[f4]).toString()).substring((listIntent[3] + "/" + flagListFolder4[f4]).indexOf("-") + 1,(listIntent[3] + "/" + flagListFolder4[f4]).indexOf("."))));
             b2.setText(((listIntent[2] + "/" + flagListFolder3[f3]).toString()).substring((listIntent[2] + "/" + flagListFolder3[f3]).indexOf("-") + 1,(listIntent[2] + "/" + flagListFolder3[f3]).indexOf(".") ));
             b3.setText(((listIntent[1] + "/" + flagListFolder2[f2]).toString()).substring((listIntent[1] + "/" + flagListFolder2[f2]).indexOf("-") + 1,(listIntent[1] + "/" + flagListFolder2[f2]).indexOf(".") ));
             b4.setText(((listIntent[0] + "/" + flagListFolder1[f1]).toString()).substring((listIntent[0] + "/" + flagListFolder1[f1]).indexOf("-") + 1,(listIntent[0] + "/" + flagListFolder1[f1]).indexOf(".") ));
             --f4;
             break;
         case 4:
             InputStream image1 = mgr.open(listIntent[0] + "/" + flagListFolder1[f1]);
             Drawable drawable1 = Drawable.createFromStream(image1, null);
             singleFlagLoad();
             iv1.setImageDrawable(drawable1);
             iv2.setVisibility(View.INVISIBLE);
             iv3.setVisibility(View.INVISIBLE);
             iv4.setVisibility(View.INVISIBLE);
             b1.setText(((listIntent[3] + "/" + flagListFolder4[f4]).toString()).substring((listIntent[3] + "/" + flagListFolder4[f4]).indexOf("-") + 1,(listIntent[3] + "/" + flagListFolder4[f4]).indexOf(".") ));
             b2.setText(((listIntent[2] + "/" + flagListFolder3[f3]).toString()).substring((listIntent[2] + "/" + flagListFolder3[f3]).indexOf("-") + 1,(listIntent[2] + "/" + flagListFolder3[f3]).indexOf(".") ));
             b3.setText(((listIntent[1] + "/" + flagListFolder2[f2]).toString()).substring((listIntent[1] + "/" + flagListFolder2[f2]).indexOf("-") + 1,(listIntent[1] + "/" + flagListFolder2[f2]).indexOf(".") ));
             b4.setText(((listIntent[0] + "/" + flagListFolder1[f1]).toString()).substring((listIntent[0] + "/" + flagListFolder1[f1]).indexOf("-") + 1,(listIntent[0] + "/" + flagListFolder1[f1]).indexOf(".") ));
             --f1;
             break;
         case 6 :
         case 10:
             InputStream image2 = mgr.open(listIntent[1] + "/" + flagListFolder2[f2]);
             Drawable drawable2 = Drawable.createFromStream(image2, null);
             singleFlagLoad();
             iv1.setImageDrawable(drawable2);
             iv2.setVisibility(View.INVISIBLE);
             iv3.setVisibility(View.INVISIBLE);
             iv4.setVisibility(View.INVISIBLE);
             b1.setText(((listIntent[3] + "/" + flagListFolder4[f4]).toString()).substring((listIntent[3] + "/" + flagListFolder4[f4]).indexOf("-") + 1,(listIntent[3] + "/" + flagListFolder4[f4]).indexOf(".") ));
             b2.setText(((listIntent[2] + "/" + flagListFolder3[f3]).toString()).substring((listIntent[2] + "/" + flagListFolder3[f3]).indexOf("-") + 1,(listIntent[2] + "/" + flagListFolder3[f3]).indexOf(".") ));
             b3.setText(((listIntent[1] + "/" + flagListFolder2[f2]).toString()).substring((listIntent[1] + "/" + flagListFolder2[f2]).indexOf("-") + 1,(listIntent[1] + "/" + flagListFolder2[f2]).indexOf(".") ));
             b4.setText(((listIntent[0] + "/" + flagListFolder1[f1]).toString()).substring((listIntent[0] + "/" + flagListFolder1[f1]).indexOf("-") + 1,(listIntent[0] + "/" + flagListFolder1[f1]).indexOf(".") ));
             --f2;
             break;
         case 8:
             InputStream image3 = mgr.open(listIntent[2] + "/" + flagListFolder3[f3]);
             Drawable drawable3 = Drawable.createFromStream(image3, null);
             iv1.setImageDrawable(drawable3);
             singleFlagLoad();
             iv2.setVisibility(View.INVISIBLE);
             iv3.setVisibility(View.INVISIBLE);
             iv4.setVisibility(View.INVISIBLE);
             b1.setText(((listIntent[3] + "/" + flagListFolder4[f4]).toString()).substring((listIntent[3] + "/" + flagListFolder4[f4]).indexOf("-") + 1,(listIntent[3] + "/" + flagListFolder4[f4]).indexOf(".") ));
             b2.setText(((listIntent[2] + "/" + flagListFolder3[f3]).toString()).substring((listIntent[2] + "/" + flagListFolder3[f3]).indexOf("-") + 1,(listIntent[2] + "/" + flagListFolder3[f3]).indexOf(".") ));
             b3.setText(((listIntent[1] + "/" + flagListFolder2[f2]).toString()).substring((listIntent[1] + "/" + flagListFolder2[f2]).indexOf("-") + 1,(listIntent[1] + "/" + flagListFolder2[f2]).indexOf(".") ));
             b4.setText(((listIntent[0] + "/" + flagListFolder1[f1]).toString()).substring((listIntent[0] + "/" + flagListFolder1[f1]).indexOf("-") + 1,(listIntent[0] + "/" + flagListFolder1[f1]).indexOf(".") ));
             --f3;
             break;
     }
    }

    /* Performing actions on correct and incorrect answers*/

    public boolean answerCheck(int question, int buttonNumber){
        switch(question){
            case 1:
            case 9:
                if(buttonNumber == 3){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                     result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;

            case 2:


                if(buttonNumber == 1){

                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;
            case 3:
                if(buttonNumber == 4){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);

                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;
            case 4:
                if(buttonNumber == 4){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;
            case 5:
                if(buttonNumber == 1){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);

                }
                break;
            case 6:
            case 10:
                if(buttonNumber == 3){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;
            case 7:
                if(buttonNumber == 3){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);

                }
                break;
            case 8:
                if(buttonNumber == 2){
                    correct++;
                    result.setText("CORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.GREEN);
                    b1.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    return true;

                }
                else{
                    incorrect++;
                    result.setText("INCORRECT!");
                    result.setTextSize(18);
                    result.setTextColor(Color.RED);


                }
                break;

        }

        return false;
    }

}
