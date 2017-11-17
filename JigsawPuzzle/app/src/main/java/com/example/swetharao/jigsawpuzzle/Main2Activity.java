package com.example.swetharao.jigsawpuzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
/*
  @Author: Swetha Krishnamurthy Rao
  @ UBID: 1004265
 */
public class Main2Activity extends AppCompatActivity {
    ImageView back, block1, block2, block3, block4, block5, block6, block7, block8, block9, block10, block11, block12, block13, block14, block15, block16;
    int width, height;
    String[] sample = new String[16];
    ViewGroup.MarginLayoutParams lp;
    float dx = 0, dy = 0 , dx2, dy2, dx3,dy3,dx4,dy4,dx5,dy5,dx6,dy6,dx7,dy7,dx8,dy8,dx9,dy9,dx10,dy10,dx11,dy11,dx12,dy12,dx13,dy13,dx14,dy14,dx15,dy15,dx16,dy16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /* Fill with default value and this array is used to identify the right location of the blocks on the grid*/
        Arrays.fill(sample,"O");
        back = (ImageView) findViewById(R.id.backImg);
        back.setEnabled(false);
        block1 = (ImageView) findViewById(R.id.block1);
        block2 = (ImageView) findViewById(R.id.block2);
        block3 = (ImageView) findViewById(R.id.block3);
        block4 = (ImageView) findViewById(R.id.block4);
        block5 = (ImageView) findViewById(R.id.block5);
        block6 = (ImageView) findViewById(R.id.block6);
        block7 = (ImageView) findViewById(R.id.block7);
        block8 = (ImageView) findViewById(R.id.block8);
        block9 = (ImageView) findViewById(R.id.block9);
        block10 = (ImageView) findViewById(R.id.block10);
        block11 = (ImageView) findViewById(R.id.block11);
        block12 = (ImageView) findViewById(R.id.block12);
        block13 = (ImageView) findViewById(R.id.block13);
        block14 = (ImageView) findViewById(R.id.block14);
        block15 = (ImageView) findViewById(R.id.block15);
        block16 = (ImageView) findViewById(R.id.block16);
        /* Listeners for the blocks*/
        block1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(! checkBlocks(view) && sample[0].equals("1")){ //disbale listener if placed in right grid
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        block1.bringToFront();
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay1 = (FrameLayout.LayoutParams) block1.getLayoutParams();
                lay1.setMargins((int) (x - block1.getWidth()), (int) (y - block1.getWidth()), 0, 0);
                block1.setLayoutParams(lay1);
/* dx and dy value to check the location of the image*/
                lp = (ViewGroup.MarginLayoutParams) block1.getLayoutParams();
                dx = lp.leftMargin;
                dy = lp.topMargin;


                return true;
            }
        });
        block2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(! checkBlocks(view) && sample[1].equals("2")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay2 = (FrameLayout.LayoutParams) block2.getLayoutParams();
                lay2.setMargins((int) (x - block2.getWidth()), (int) (y - block2.getWidth()), 0, 0);
                block2.setLayoutParams(lay2);
                block2.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block2.getLayoutParams();
                dx2 = lp.leftMargin;
                dy2 = lp.topMargin;
                return true;
            }
        });
        block3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[2].equals("3")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay3 = (FrameLayout.LayoutParams) block3.getLayoutParams();
                lay3.setMargins((int) (x - block3.getWidth()), (int) (y - block3.getWidth()), 0, 0);
                block3.setLayoutParams(lay3);
                block3.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block3.getLayoutParams();
                dx3 = lp.leftMargin;
                dy3 = lp.topMargin;
                return true;
            }
        });
        block4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[3].equals("4")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay4 = (FrameLayout.LayoutParams) block4.getLayoutParams();
                lay4.setMargins((int) (x - block4.getWidth()), (int) (y - block4.getWidth()), 0, 0);
                block4.setLayoutParams(lay4);
                block4.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block4.getLayoutParams();
                dx4 = lp.leftMargin;
                dy4 = lp.topMargin;
                return true;
            }
        });
        block5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[4].equals("5")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay5 = (FrameLayout.LayoutParams) block5.getLayoutParams();
                lay5.setMargins((int) (x - block5.getWidth()), (int) (y - block5.getWidth()), 0, 0);
                block5.setLayoutParams(lay5);
                block5.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block5.getLayoutParams();
                dx5 = lp.leftMargin;
                dy5 = lp.topMargin;

                return true;
            }
        });
        block6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[5].equals("6")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay6 = (FrameLayout.LayoutParams) block6.getLayoutParams();
                lay6.setMargins((int) (x - block6.getWidth()), (int) (y - block6.getWidth()), 0, 0);
                block6.setLayoutParams(lay6);
                block6.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block6.getLayoutParams();
                dx6 = lp.leftMargin;
                dy6 = lp.topMargin;
                return true;
            }
        });
        block7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(! checkBlocks(view) && sample[6].equals("7")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay7 = (FrameLayout.LayoutParams) block7.getLayoutParams();
                lay7.setMargins((int) (x - block7.getWidth()), (int) (y - block7.getWidth()), 0, 0);
                block7.setLayoutParams(lay7);
                block7.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block7.getLayoutParams();
                dx7 = lp.leftMargin;
                dy7 = lp.topMargin;

                return true;
            }
        });
        block8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[7].equals("8")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay8 = (FrameLayout.LayoutParams) block8.getLayoutParams();
                lay8.setMargins((int) (x - block8.getWidth()), (int) (y - block8.getWidth()), 0, 0);
                block8.setLayoutParams(lay8);
                block8.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block8.getLayoutParams();
                dx8 = lp.leftMargin;
                dy8 = lp.topMargin;

                return true;
            }
        });
        block9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                checkFinish();
                if(! checkBlocks(view) && sample[8].equals("9")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay9 = (FrameLayout.LayoutParams) block9.getLayoutParams();
                lay9.setMargins((int) (x - block9.getWidth()), (int) (y - block9.getWidth()), 0, 0);
                block9.setLayoutParams(lay9);
                block9.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block9.getLayoutParams();
                dx9 = lp.leftMargin;
                dy9 = lp.topMargin;

                return true;
            }
        });
        block10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[9].equals("10")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay10 = (FrameLayout.LayoutParams) block10.getLayoutParams();
                lay10.setMargins((int) (x - block10.getWidth()), (int) (y - block10.getWidth()), 0, 0);
                block10.setLayoutParams(lay10);
                block10.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block10.getLayoutParams();
                dx10 = lp.leftMargin;
                dy10 = lp.topMargin;

                return true;
            }
        });
        block11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[10].equals("11")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay11 = (FrameLayout.LayoutParams) block11.getLayoutParams();
                lay11.setMargins((int) (x - block11.getWidth()), (int) (y - block11.getWidth()), 0, 0);
                block11.setLayoutParams(lay11);
                block11.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block11.getLayoutParams();
                dx11 = lp.leftMargin;
                dy11 = lp.topMargin;

                return true;
            }
        });
        block12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[11].equals("12")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay12 = (FrameLayout.LayoutParams) block12.getLayoutParams();
                lay12.setMargins((int) (x - block12.getWidth()), (int) (y - block12.getWidth()), 0, 0);
                block12.setLayoutParams(lay12);
                block12.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block12.getLayoutParams();
                dx12 = lp.leftMargin;
                dy12 = lp.topMargin;

                return true;
            }
        });
        block13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[12].equals("13")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay13 = (FrameLayout.LayoutParams) block13.getLayoutParams();
                lay13.setMargins((int) (x - block13.getWidth()), (int) (y - block13.getWidth()), 0, 0);
                block13.setLayoutParams(lay13);
                block13.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block13.getLayoutParams();
                dx13 = lp.leftMargin;
                dy13 = lp.topMargin;

                return true;
            }
        });
        block14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[13].equals("14")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay14 = (FrameLayout.LayoutParams) block14.getLayoutParams();
                lay14.setMargins((int) (x - block14.getWidth()), (int) (y - block14.getWidth()), 0, 0);
                block14.setLayoutParams(lay14);
                block14.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block14.getLayoutParams();
                dx14 = lp.leftMargin;
                dy14 = lp.topMargin;

                return true;
            }
        });
        block15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[14].equals("15")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay15 = (FrameLayout.LayoutParams) block15.getLayoutParams();
                lay15.setMargins((int) (x - block15.getWidth()), (int) (y - block15.getWidth()), 0, 0);
                lp = (ViewGroup.MarginLayoutParams) block15.getLayoutParams();
                block15.setLayoutParams(lay15);
                block15.bringToFront();
                dx15 = lp.leftMargin;
                dy15 = lp.topMargin;
                return true;
            }
        });
        block16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //checkFinish();
                if(! checkBlocks(view) && sample[15].equals("16")){
                    return false;
                }
                float x = 0, y = 0;
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = motionEvent.getRawX() - x;
                        y = motionEvent.getRawY() - y;
                        if(x > width){
                            x = width;
                        }
                        if(y > width){
                            y = width;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                       x = motionEvent.getRawX();
                        y = motionEvent.getRawY();
                        view.performClick();
                        break;
                }
                FrameLayout.LayoutParams lay16 = (FrameLayout.LayoutParams) block16.getLayoutParams();
                lay16.setMargins((int) (x - block16.getWidth() ), (int) (y - block16.getWidth() ), 0, 0);
                block16.setLayoutParams(lay16);
                block16.bringToFront();
                lp = (ViewGroup.MarginLayoutParams) block16.getLayoutParams();
                dx16 = lp.leftMargin;
                dy16 = lp.topMargin;
                return true;
            }
        });
/*  Get the height and width of the device*/
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        back.getLayoutParams().height = width;// Set the grid as a square
        back.requestLayout();
        setBlocks();
    }
    /* Menu to go back to the start of the application*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gotostart,menu);
        return true;
    }
/* On click of the menu, go back to the first page*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuL:
                Intent tent = new Intent(Main2Activity.this,Main2Activity.class);
                startActivity(tent);
                break;
        }
        return true;
    }
/* Check whether the blocks are placed in the right grid */
    public boolean checkBlocks(View view){

        switch(view.getId()){
            case R.id.block1:
                if( dx < (width * 0.25)  && dy < (width * 0.25) && dy > (width * 0.01)){
                    sample[0] = "1";
                    checkFinish();
                   FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block1.getLayoutParams();
                    layFrame.setMargins((int)(width * 0.01),0,0,0);
                    block1.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block2:
                if( dx2 > (width * 0.25) && dx2 < (width * 0.50) && dy2 <= (width * 0.25)){
                    sample[1] = "2";
                    checkFinish();
                    FrameLayout.LayoutParams   layFrame = (FrameLayout.LayoutParams) block2.getLayoutParams();
                    layFrame.setMargins((int)(width * 0.25),0,0,0);
                    block2.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block3:
                if( dx3 > (width * 0.50) && dx3 < (width * 0.75) && dy3 <= (width * 0.25)){
                    sample[2] = "3";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block3.getLayoutParams();
                    layFrame.setMargins((int)(width * 0.50),0,0,0);
                    block3.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block4:
                if( dx4 >= (width * 0.75) && dx4 < width && dy4 <= (width * 0.25) ){
                    sample[3] = "4";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block4.getLayoutParams();
                    layFrame.setMargins((int)(width * 0.75),0,0,0);
                    block4.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block5:
                if(dy5 > (width * 0.25) && dy5 < (width * 0.50) && dx5 < (width * 0.25)){

                    sample[4] = "5";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block5.getLayoutParams();
                    layFrame.setMargins(0,(int)(width * 0.25),0,0);
                    block5.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block6:
                if(dx6 > (width * 0.25) && dx6 < (width * 0.50) && dy6 > (width * 0.25) && dy6 < (width * 0.50)){
                    sample[5] = "6";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block6.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.25),(int)(width * 0.25),0,0);
                    block6.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block7:
                if(dx7 > (width * 0.50) && dx7 < (width * 0.75) && dy7 > (width * 0.25) && dy7 < (width * 0.50)){
                    sample[6] = "7";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block7.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.50),(int)(width * 0.25),0,0);
                    block7.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block8:
                if(dx8 > (width * 0.75) && dx8 < width && dy8 > (width * 0.25) && dy8 < (width * 0.50)){
                    sample[7] = "8";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block8.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.75),(int)(width * 0.25),0,0);
                    block8.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block9:
                if( dx9 < (width * 0.25) && dy9 > (width * 0.50) && dy9 < (width * 0.75)){
                    sample[8] = "9";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block9.getLayoutParams();
                    layFrame.setMargins(0,(int)(width * 0.50),0,0);
                    block9.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block10:
                if(dx10 > (width * 0.25) && dx10 < (width * 0.50) && dy10 > (width * 0.50) && dy10 < (width * 0.75))
                {
                    sample[9] = "10";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block10.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.25),(int)(width * 0.50),0,0);
                    block10.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block11:
                if(dx11 > (width * 0.50) && dx11 < (width * 0.75) && dy11 > (width * 0.50) && dy11 < (width * 0.75))
                {
                    sample[10] = "11";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block11.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.50),(int)(width * 0.50),0,0);
                    block11.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block12:
                if(dx12 > (width * 0.75)  && dy12 > (width * 0.50) && dy12 < (width * 0.75))
                {
                    sample[11] = "12";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block12.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.75),(int)(width * 0.50),0,0);
                    block12.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block13:
                if(dx13 < (width * 0.25) && dy13 > (width * 0.75) && dy13 < (width * 0.90))
                {
                    sample[12] = "13";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block13.getLayoutParams();
                    layFrame.setMargins(0,(int)(width * 0.75),0,0);
                    block13.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block14:
                if(dx14 > (width * 0.25) && dx14 < (width * 0.50) && dy14 > (width * 0.75) && dy14 < (width * 0.90))
                {
                    sample[13] = "14";
                    checkFinish();
                    FrameLayout.LayoutParams  layFrame = (FrameLayout.LayoutParams) block14.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.25),(int)(width * 0.75),0,0);
                    block14.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block15:
                if(dx15 > (width * 0.50) && dx15 < (width * 0.75) && dy15 > (width * 0.75) && dy15 < (width * 0.90))
                {
                    sample[14] = "15";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block15.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.50),(int)(width * 0.75),0,0);
                    block15.setLayoutParams(layFrame);
                    return false;
                }
                break;
            case R.id.block16:
                if(dx16 > (width * 0.75) && dx16 < width && dy16 > (width * 0.75) && dy16 < (width * 0.90))
                {
                    sample[15] = "16";
                    checkFinish();
                    FrameLayout.LayoutParams layFrame = (FrameLayout.LayoutParams) block16.getLayoutParams();
                    layFrame.setMargins((int) (width * 0.75),(int)(width * 0.75),0,0);
                    block16.setLayoutParams(layFrame);
                    return false;
                }
                break;
        }

        return true;
    }
/* On load of the activity, load the blocks at the bottom of the activity */
    public void setBlocks() {
        block1.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b1 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b1.setMargins(0, (int) (height * 0.675), 0, 0);
        block1.setLayoutParams(b1);
        block2.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b2 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b2.setMargins(0, (int) (height * 0.675), 0, 0);
        block2.setLayoutParams(b2);
        block3.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b3 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b3.setMargins(0, (int) (height * 0.675), 0, 0);
        block3.setLayoutParams(b3);
        block4.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b4 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b4.setMargins(0, (int) (height * 0.675), 0, 0);
        block4.setLayoutParams(b4);
        block5.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b5 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b5.setMargins((int) (width * 0.26), (int) (height * 0.675), 0, 0);
        block5.setLayoutParams(b5);
        block6.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b6 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b6.setMargins((int) (width * 0.26), (int) (height * 0.675), 0, 0);
        block6.setLayoutParams(b6);
        block7.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b7 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b7.setMargins((int) (width * 0.26), (int) (height * 0.675), 0, 0);
        block7.setLayoutParams(b7);
        block8.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b8 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b8.setMargins((int) (width * 0.26), (int) (height * 0.675), 0, 0);
        block8.setLayoutParams(b8);
        block9.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b9 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b9.setMargins((int) (width * 0.47), (int) (height * 0.675), 0, 0);
        block9.setLayoutParams(b9);
        block10.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b10 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b10.setMargins((int) (width * 0.47), (int) (height * 0.675), 0, 0);
        block10.setLayoutParams(b10);
        block11.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b11 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b11.setMargins((int) (width * 0.47), (int) (height * 0.675), 0, 0);
        block11.setLayoutParams(b11);
        block12.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b12 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b12.setMargins((int) (width * 0.47), (int) (height * 0.675), 0, 0);
        block12.setLayoutParams(b12);
        block13.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b13 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b13.setMargins((int) (width * 0.68), (int) (height * 0.675), 0, 0);
        block13.setLayoutParams(b13);
        block14.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b14 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b14.setMargins((int) (width * 0.68), (int) (height * 0.675), 0, 0);
        block14.setLayoutParams(b14);
        block15.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b15 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b15.setMargins((int) (width * 0.68), (int) (height * 0.675), 0, 0);
        block15.setLayoutParams(b15);
        block16.setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams b16 = new FrameLayout.LayoutParams((int) (width * 0.23), (int) (width * 0.23));
        b16.setMargins((int) (width * 0.68), (int) (height * 0.675), 0, 0);
        block16.setLayoutParams(b16);


    }
/* If all the  blocks are on the right grid then show the complete image and display a toast */
    public boolean checkFinish() {
        int j = 0;
        for (int i = 0; i < sample.length; i++) {
            if (!(sample[i].contains("O"))) {
                ++j;
            }
        }

        if(j == 16){
            Toast.makeText(Main2Activity.this,"COMPLETE!",Toast.LENGTH_LONG).show();
            block1.setVisibility(View.INVISIBLE);
            block2.setVisibility(View.INVISIBLE);
            block3.setVisibility(View.INVISIBLE);
            block4.setVisibility(View.INVISIBLE);
            block5.setVisibility(View.INVISIBLE);
            block6.setVisibility(View.INVISIBLE);
            block7.setVisibility(View.INVISIBLE);
            block8.setVisibility(View.INVISIBLE);
            block9.setVisibility(View.INVISIBLE);
            block10.setVisibility(View.INVISIBLE);
            block11.setVisibility(View.INVISIBLE);
            block12.setVisibility(View.INVISIBLE);
            block13.setVisibility(View.INVISIBLE);
            block14.setVisibility(View.INVISIBLE);
            block15.setVisibility(View.INVISIBLE);
            block16.setVisibility(View.INVISIBLE);
            back.setImageResource(R.drawable.ubsymbol);
            return true;

        }
return false;
    }

}
