package com.example.swetharao.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
/*
 * @Author: Swetha Krishnamurthy Rao
 * @UBID: 1004265
*/
public class Main2Activity extends AppCompatActivity {
    Spinner spin;
    RelativeLayout rl;
    /* ImageView for the game*/
    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15,image16,image17,image18,image19,image20;
    /* To check if the correct match is selected or not */
    int pair1,pair2,pair3,pair4,pair5,pair6,pair7,pair8,pair9,pair10;
    /* To check the completion of pairs of 3, 6 and 10. */
    int find3=0, find6=0 , find10=0;
    /* To find the option selected in the spinner */
    int selected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spin = (Spinner) findViewById(R.id.spinner);
        rl = (RelativeLayout) findViewById(R.id.activity_main2);
        image1 = (ImageView) findViewById(R.id.iv1);
        image2 = (ImageView) findViewById(R.id.iv2);
        image3 = (ImageView) findViewById(R.id.iv3);
        image4 = (ImageView) findViewById(R.id.iv4);
        image5 = (ImageView) findViewById(R.id.iv5);
        image6 = (ImageView) findViewById(R.id.iv6);
        image7 = (ImageView) findViewById(R.id.iv7);
        image8 = (ImageView) findViewById(R.id.iv8);
        image9 = (ImageView) findViewById(R.id.iv9);
        image10 = (ImageView) findViewById(R.id.iv10);
        image11 = (ImageView) findViewById(R.id.iv11);
        image12 = (ImageView) findViewById(R.id.iv12);
        image13 = (ImageView) findViewById(R.id.iv13);
        image14 = (ImageView) findViewById(R.id.iv14);
        image15 = (ImageView) findViewById(R.id.iv15);
        image16 = (ImageView) findViewById(R.id.iv16);
        image17 = (ImageView) findViewById(R.id.iv17);
        image18 = (ImageView) findViewById(R.id.iv18);
        image19 = (ImageView) findViewById(R.id.iv19);
        image20 = (ImageView) findViewById(R.id.iv20);
/* At the end of the animation, this listener sets the imageview to 0.5f alpha */
        final Animation.AnimationListener rotateListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(pair1 == 2){
                    image1.setAlpha(0.5f);
                    image5.setAlpha(0.5f);
                }
               if(pair2 == 2){
                    image2.setAlpha(0.5f);
                    image6.setAlpha(0.5f);
                }
                 if(pair3 == 2){
                    image3.setAlpha(0.5f);
                    image4.setAlpha(0.5f);
                }
                 if(pair4 == 2){
                    image7.setAlpha(0.5f);
                    image12.setAlpha(0.5f);
                }
                 if(pair5 == 2){
                    image8.setAlpha(0.5f);
                    image10.setAlpha(0.5f);
                }
                 if(pair6 == 2){
                    image9.setAlpha(0.5f);
                    image11.setAlpha(0.5f);
                }
                 if(pair7 == 2){
                    image13.setAlpha(0.5f);
                    image19.setAlpha(0.5f);
                }
                 if(pair8 == 2){
                    image14.setAlpha(0.5f);
                    image17.setAlpha(0.5f);
                }
                 if(pair9 == 2){
                    image15.setAlpha(0.5f);
                    image20.setAlpha(0.5f);
                }
                 if(pair10 == 2){
                    image16.setAlpha(0.5f);
                    image18.setAlpha(0.5f);
                }



            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
      final  Animation rotate = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.rotate);
        rotate.setAnimationListener(rotateListener);
/* Spinner Listener on selection of each item */
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                     switch (position) {

                         case 1:
                             selected = 1;
                             spin.setEnabled(false);
                             image1.setVisibility(View.VISIBLE);
                             image2.setVisibility(View.VISIBLE);
                             image3.setVisibility(View.VISIBLE);
                             image4.setVisibility(View.VISIBLE);
                             image5.setVisibility(View.VISIBLE);
                             image6.setVisibility(View.VISIBLE);
                             image7.setVisibility(View.INVISIBLE);
                             image8.setVisibility(View.INVISIBLE);
                             image9.setVisibility(View.INVISIBLE);
                             image10.setVisibility(View.INVISIBLE);
                             image11.setVisibility(View.INVISIBLE);
                             image12.setVisibility(View.INVISIBLE);
                             image13.setVisibility(View.INVISIBLE);
                             image14.setVisibility(View.INVISIBLE);
                             image15.setVisibility(View.INVISIBLE);
                             image16.setVisibility(View.INVISIBLE);
                             image17.setVisibility(View.INVISIBLE);
                             image18.setVisibility(View.INVISIBLE);
                             image19.setVisibility(View.INVISIBLE);
                             image20.setVisibility(View.INVISIBLE);

                             image1.setAlpha(1.0f);
                             image2.setAlpha(1.0f);
                             image3.setAlpha(1.0f);
                             image4.setAlpha(1.0f);
                             image5.setAlpha(1.0f);
                             image6.setAlpha(1.0f);

                             image1.setImageResource(R.drawable.front);
                             image2.setImageResource(R.drawable.front);
                             image3.setImageResource(R.drawable.front);
                             image4.setImageResource(R.drawable.front);
                             image5.setImageResource(R.drawable.front);
                             image6.setImageResource(R.drawable.front);


                             break;
                         case 2:
                             selected = 2;
                             spin.setEnabled(false);
                             image1.setVisibility(View.VISIBLE);
                             image2.setVisibility(View.VISIBLE);
                             image3.setVisibility(View.VISIBLE);
                             image4.setVisibility(View.VISIBLE);
                             image5.setVisibility(View.VISIBLE);
                             image6.setVisibility(View.VISIBLE);
                             image7.setVisibility(View.VISIBLE);
                             image8.setVisibility(View.VISIBLE);
                             image9.setVisibility(View.VISIBLE);
                             image10.setVisibility(View.VISIBLE);
                             image11.setVisibility(View.VISIBLE);
                             image12.setVisibility(View.VISIBLE);
                             image13.setVisibility(View.INVISIBLE);
                             image14.setVisibility(View.INVISIBLE);
                             image15.setVisibility(View.INVISIBLE);
                             image16.setVisibility(View.INVISIBLE);
                             image17.setVisibility(View.INVISIBLE);
                             image18.setVisibility(View.INVISIBLE);
                             image19.setVisibility(View.INVISIBLE);
                             image20.setVisibility(View.INVISIBLE);

                             image1.setAlpha(1.0f);
                             image2.setAlpha(1.0f);
                             image3.setAlpha(1.0f);
                             image4.setAlpha(1.0f);
                             image5.setAlpha(1.0f);
                             image6.setAlpha(1.0f);
                             image7.setAlpha(1.0f);
                             image8.setAlpha(1.0f);
                             image9.setAlpha(1.0f);
                             image10.setAlpha(1.0f);
                             image11.setAlpha(1.0f);
                             image12.setAlpha(1.0f);

                             image1.setImageResource(R.drawable.front);
                             image2.setImageResource(R.drawable.front);
                             image3.setImageResource(R.drawable.front);
                             image4.setImageResource(R.drawable.front);
                             image5.setImageResource(R.drawable.front);
                             image6.setImageResource(R.drawable.front);
                             image7.setImageResource(R.drawable.front);
                             image8.setImageResource(R.drawable.front);
                             image9.setImageResource(R.drawable.front);
                             image10.setImageResource(R.drawable.front);
                             image11.setImageResource(R.drawable.front);
                             image12.setImageResource(R.drawable.front);

                             break;
                         case 3:
                             selected = 3;
                             spin.setEnabled(false);
                             image1.setVisibility(View.VISIBLE);
                             image2.setVisibility(View.VISIBLE);
                             image3.setVisibility(View.VISIBLE);
                             image4.setVisibility(View.VISIBLE);
                             image5.setVisibility(View.VISIBLE);
                             image6.setVisibility(View.VISIBLE);
                             image7.setVisibility(View.VISIBLE);
                             image8.setVisibility(View.VISIBLE);
                             image9.setVisibility(View.VISIBLE);
                             image10.setVisibility(View.VISIBLE);
                             image11.setVisibility(View.VISIBLE);
                             image12.setVisibility(View.VISIBLE);
                             image13.setVisibility(View.VISIBLE);
                             image14.setVisibility(View.VISIBLE);
                             image15.setVisibility(View.VISIBLE);
                             image16.setVisibility(View.VISIBLE);
                             image17.setVisibility(View.VISIBLE);
                             image18.setVisibility(View.VISIBLE);
                             image19.setVisibility(View.VISIBLE);
                             image20.setVisibility(View.VISIBLE);

                             image1.setAlpha(1.0f);
                             image2.setAlpha(1.0f);
                             image3.setAlpha(1.0f);
                             image4.setAlpha(1.0f);
                             image5.setAlpha(1.0f);
                             image6.setAlpha(1.0f);
                             image7.setAlpha(1.0f);
                             image8.setAlpha(1.0f);
                             image9.setAlpha(1.0f);
                             image10.setAlpha(1.0f);
                             image11.setAlpha(1.0f);
                             image12.setAlpha(1.0f);
                             image13.setAlpha(1.0f);
                             image14.setAlpha(1.0f);
                             image15.setAlpha(1.0f);
                             image16.setAlpha(1.0f);
                             image17.setAlpha(1.0f);
                             image18.setAlpha(1.0f);
                             image19.setAlpha(1.0f);
                             image20.setAlpha(1.0f);

                             image1.setImageResource(R.drawable.front);
                             image2.setImageResource(R.drawable.front);
                             image3.setImageResource(R.drawable.front);
                             image4.setImageResource(R.drawable.front);
                             image5.setImageResource(R.drawable.front);
                             image6.setImageResource(R.drawable.front);
                             image7.setImageResource(R.drawable.front);
                             image8.setImageResource(R.drawable.front);
                             image9.setImageResource(R.drawable.front);
                             image10.setImageResource(R.drawable.front);
                             image11.setImageResource(R.drawable.front);
                             image12.setImageResource(R.drawable.front);
                             image13.setImageResource(R.drawable.front);
                             image14.setImageResource(R.drawable.front);
                             image15.setImageResource(R.drawable.front);
                             image16.setImageResource(R.drawable.front);
                             image17.setImageResource(R.drawable.front);
                             image18.setImageResource(R.drawable.front);
                             image19.setImageResource(R.drawable.front);
                             image20.setImageResource(R.drawable.front);

                             break;

                     }
                 }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /* Listeners for each imageview to perform animation*/
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ++pair1;
                image1.setImageResource(R.drawable.apple);
                pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3; ++find6; ++find10;
                if(pair1 == 2) {
                    image1.startAnimation(rotate);
                    image5.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair2;
                image2.setImageResource(R.drawable.strawberry);
                pair1=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair2 == 2) {
                    image2.startAnimation(rotate);
                    image6.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair3;
                image3.setImageResource(R.drawable.grapes);
                pair1=0;pair2=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair3 == 2) {
                    image3.startAnimation(rotate);
                    image4.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair3;
                image4.setImageResource(R.drawable.grapes);
                pair1=0;pair2=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair3 == 2) {
                    image3.startAnimation(rotate);
                    image4.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair1;
                image5.setImageResource(R.drawable.apple);
                pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair1 == 2){
                    image1.setAnimation(rotate);
                    image5.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair2;
                image6.setImageResource(R.drawable.strawberry);
                pair1=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair2 == 2) {
                    image2.startAnimation(rotate);
                    image6.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair4;
                image7.setImageResource(R.drawable.banana);
                pair1=0;pair2=0;pair3=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair4 == 2) {
                    image7.startAnimation(rotate);
                    image12.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair5;
                image8.setImageResource(R.drawable.cherries);
                pair1=0;pair2=0;pair3=0;pair4=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair5 == 2) {
                    image8.startAnimation(rotate);
                    image10.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair6;
                image9.setImageResource(R.drawable.kiwi);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair6 == 2) {
                    image9.startAnimation(rotate);
                    image11.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair5;
                image10.setImageResource(R.drawable.cherries);
                pair1=0;pair2=0;pair3=0;pair4=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair5 == 2) {
                    image8.startAnimation(rotate);
                    image10.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair6;
                image11.setImageResource(R.drawable.kiwi);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair6 == 2) {
                    image9.startAnimation(rotate);
                    image11.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair4;
                image12.setImageResource(R.drawable.banana);
                pair1=0;pair2=0;pair3=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair4 == 2) {
                    image12.startAnimation(rotate);
                    image7.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair7;
                image13.setImageResource(R.drawable.mango);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair7 == 2) {
                    image13.startAnimation(rotate);
                    image19.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair8;
                image14.setImageResource(R.drawable.orange);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair8 == 2) {
                    image14.startAnimation(rotate);
                    image17.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair9;
                image15.setImageResource(R.drawable.papaya);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair9 == 2) {
                    image15.startAnimation(rotate);
                    image20.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair10;
                image16.setImageResource(R.drawable.pineapple);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;
                ++find3;++find6;++find10;
                if(pair10 == 2) {
                    image16.startAnimation(rotate);
                    image18.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair8;
                image17.setImageResource(R.drawable.orange);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair8 == 2) {
                    image17.startAnimation(rotate);
                    image14.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair10;
                image18.setImageResource(R.drawable.pineapple);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair9=0;
                ++find3;++find6;++find10;
                if(pair10 == 2) {
                    image18.startAnimation(rotate);
                    image16.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair7;
                image19.setImageResource(R.drawable.mango);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair8=0;pair9=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair7 == 2) {
                    image19.startAnimation(rotate);
                    image13.startAnimation(rotate);
                }
                checkGameOver();
            }
        });
        image20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++pair9;
                image20.setImageResource(R.drawable.papaya);
                pair1=0;pair2=0;pair3=0;pair4=0;pair5=0;pair6=0;pair7=0;pair8=0;pair10=0;
                ++find3;++find6;++find10;
                if(pair9 == 2) {
                    image20.startAnimation(rotate);
                    image15.startAnimation(rotate);
                }
                checkGameOver();
            }
        });

    }
/* To check if the game is over and if so then enable the spinner and show a toast message */
    public void checkGameOver(){
        if(find3 == 6 && selected == 1){


            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
            image4.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image6.setVisibility(View.INVISIBLE);

            Toast.makeText(Main2Activity.this,"Game Over",Toast.LENGTH_LONG).show();
            spin.setEnabled(true);
            spin.setSelection(0);
            find3 = 0; find6 = 0; find10 = 0;

        }
        if(find6 == 12 && selected == 2){

            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
            image4.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image6.setVisibility(View.INVISIBLE);
            image7.setVisibility(View.INVISIBLE);
            image8.setVisibility(View.INVISIBLE);
            image9.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image11.setVisibility(View.INVISIBLE);
            image12.setVisibility(View.INVISIBLE);


            Toast.makeText(Main2Activity.this,"Game Over",Toast.LENGTH_LONG).show();
            spin.setEnabled(true);
            spin.setSelection(0);
            find3 = 0; find6 = 0; find10 = 0;
        }
        if(find10 == 20 && selected == 3){

            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.INVISIBLE);
            image3.setVisibility(View.INVISIBLE);
            image4.setVisibility(View.INVISIBLE);
            image5.setVisibility(View.INVISIBLE);
            image6.setVisibility(View.INVISIBLE);
            image7.setVisibility(View.INVISIBLE);
            image8.setVisibility(View.INVISIBLE);
            image9.setVisibility(View.INVISIBLE);
            image10.setVisibility(View.INVISIBLE);
            image11.setVisibility(View.INVISIBLE);
            image12.setVisibility(View.INVISIBLE);
            image13.setVisibility(View.INVISIBLE);
            image14.setVisibility(View.INVISIBLE);
            image15.setVisibility(View.INVISIBLE);
            image16.setVisibility(View.INVISIBLE);
            image17.setVisibility(View.INVISIBLE);
            image18.setVisibility(View.INVISIBLE);
            image19.setVisibility(View.INVISIBLE);
            image20.setVisibility(View.INVISIBLE);

            Toast.makeText(Main2Activity.this,"Game Over",Toast.LENGTH_LONG).show();
            spin.setEnabled(true);
            spin.setSelection(0);
            find3 = 0; find6 = 0; find10 = 0;
        }
    }
}
