package ubknights.com.spaceshooter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;

import static android.nfc.NdefRecord.createUri;

/**
 * @authors: Carlos, Swetha Krishnamurthy Rao
 * @UBID: 1004265
 */

public class TheGameLevel1X extends Activity implements View.OnTouchListener{

    TheView mySurfaceView;      //the surfaceview, where we draw
    TheSprites2 allsprites; //class that has all the location and sizes of the images in the sprite
    Bitmap scaled;
    float xTouch,yTouch;          //the location when the screen is touched
    float enemy1random = 0.2f, enemy2random = 0.6f;
    int s_width,s_height,shipHitCount = 1,explosion =0;       //the size of the surfaceview
    boolean shipHit, enemy1Hit,enemy2Hit;
    MediaPlayer mPlayer; // Reference to play the main song
    SoundPool sound_pool; //SoundPool reference
    HashMap<Integer,Integer> soundMap = new HashMap<Integer, Integer>(); // map for loading and storing the sounds for later reference.
    //used for which sprite to use
    int loc = 0,eLoc=0,e1Loc=3,e2Loc=0,m1Loc=0,m2Loc=1,m3Loc=2;
    Point shipbullet,enemy1,enemy2,enemy1bullet,enemy2bullet,meteor1,meteor2,meteor3;
    long enemyMoveTime = 0; int minute=0,seconds=0; long milliseconds=0;
    //15 frames per seconds
    float skipTime =1000.0f/30.0f; //setting 30fps
    long lastUpdate ;
    long  startTime = 0;
    int enemyNumber, timesOfEnemyHit ;
    Vibrator v = null;
    float dt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        try {
            Uri theUri = Uri.parse("android.resource://"+
                    TheGameLevel1X.this.getPackageName()+
                    "/"+R.raw.mainsong);
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(TheGameLevel1X.this, theUri);
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.prepare();
            sound_pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            soundMap.put(1, sound_pool.load(TheGameLevel1X.this, R.raw.shipbullet, 1));
            soundMap.put(2,sound_pool.load(TheGameLevel1X.this, R.raw.enemyboom, 1));
            soundMap.put(3,sound_pool.load(TheGameLevel1X.this, R.raw.shipboom, 1));


        } catch (IOException e) {
            e.printStackTrace();
        }
        //setContentView(R.layout.spritesheetbetter); //not setting a static xml
        //set all the sprite locations and sizes
        allsprites = new TheSprites2(getResources());
        //make sure there is only ONE copy of the image and that the image
        //is in the drawable-nodpi. if it is not unwanted scaling might occur
        shipbullet = new Point(); //used for canvas drawing location
        enemy1 = new Point();     //used for canvas drawing location
        enemy1bullet = new Point(); //used for canvas drawing location
        enemy2bullet = new Point(); //used for canvas drawing location
        lastUpdate = 0;         //to check against now time
        startTime =  getIntent().getLongExtra("currentTime",0);


        //hide the actoinbar and make it fullscreen
        hideAndFull();
        //our custom view
        mySurfaceView = new TheView(this);
        mySurfaceView.setOnTouchListener(this); //now we can touch the screen
        setContentView(mySurfaceView);

       Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //not passing an xml, using the surfaceview as the layout
                //custom way of setting the size of the surfaceview
        mySurfaceView.startGame();
            }
       },1000);


    }

    public void hideAndFull()
    {
        ActionBar bar = getActionBar();
        bar.hide();
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                xTouch = motionEvent.getX();
                yTouch = motionEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                xTouch = motionEvent.getX();
                yTouch = motionEvent.getY();
                view.performClick();//to get rid of the message, mimicking a click
                break;
            case MotionEvent.ACTION_MOVE:
                xTouch = motionEvent.getX();
                yTouch = motionEvent.getY();
                break;
        }
        return true;
    }

    //surface view used so we can draw is dedicated made for drawing
    //View is updated in main thread while SurfaceView is updated in another thread.
    public class TheView extends SurfaceView implements SurfaceHolder.Callback {
        //resize and edit pixels in a surface. Holds the display
        SurfaceHolder holder;
        Boolean change = true;
        Thread gameThread;


        public TheView(Context context) {
            super(context);

            //get this holder
            holder = getHolder();//gets the surfaceview surface
            holder.addCallback(this);
            gameThread = new Thread(runn);
        }

        Runnable runn = new Runnable() {
            @Override
            public void run() {

                while (change == true) {
                    //perform drawing, does it have a surface?
                    if (!holder.getSurface().isValid()) {
                        continue;
                    }

                    dt = System.currentTimeMillis() - lastUpdate;
                    // Log.d("d", dt+" "+"latupdate: "+ lastUpdate);
                    if (dt >= skipTime) {
                        //look it to paint on it
                        Canvas c = holder.lockCanvas();
                        Bitmap background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
                        float scale = (float)background.getHeight()/(float)getHeight();
                        int n_width = Math.round(background.getWidth()/scale);
                        int n_height = Math.round(background.getHeight()/scale);
                        scaled = Bitmap.createScaledBitmap(background,n_width,n_height,true);
                        //draw the background color
                        //c.drawARGB(255, 0, 0, 0);
                        c.drawBitmap(scaled,0,0,null);
                        //draw ship 4x the original size, you should use some percentage of the screen to make it the same size on every device
                        Rect place = new Rect(0,(int) yTouch,(int)(s_width - s_width * 0.8),(int)yTouch + allsprites.shipSize.height()*6);
                        c.drawBitmap(allsprites.space, allsprites.shipSprites[eLoc], place, null);

                        //draw the enemy 1
                        place = new Rect((int) (s_width * .9f), (int) (s_height * enemy1random), s_width ,
                                (int) (s_height * enemy1random) + allsprites.enemySize.height() * 4);
                        c.drawBitmap(allsprites.space, allsprites.enemy1sprites[e1Loc], place, null);
                        //draw the enemy 2
                        place = new Rect((int) (s_width * .7f), (int) (s_height * enemy2random),(int)(s_width * .8f),
                                (int) (s_height * enemy2random) + allsprites.enemySize.height() * 4);
                        c.drawBitmap(allsprites.space, allsprites.enemy2sprites[e2Loc], place, null);
                        // Explosion when the ship is hit
                        if(shipHit) {
                            shipHit = false;
                            if(enemyNumber ==1){
                                enemyNumber = 0;
                                enemy1bullet.x = s_width - (allsprites.enemySize.width() * 4);
                            }
                            if(enemyNumber == 2){
                                enemyNumber = 0;
                                enemy2bullet.x = s_width - (allsprites.enemySize.width() * 4);
                            }
                            sound_pool.play(soundMap.get(3),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect((int) (s_width * .1f), (int) yTouch, (int)(s_width - s_width * 0.8),
                                    (int)yTouch + allsprites.shipSize.height()*6);
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);

                            if(explosion == 1) {gameDone() ;}

                        }
                        // Explosion when enemy1 is hit
                        if(enemy1Hit){
                           enemy1Hit = false;
                           ++timesOfEnemyHit;
                            sound_pool.play(soundMap.get(2),1,1,1,1,0);
                            v.vibrate(400);
                           place = new Rect((int) (s_width * .9f), (int) (s_height * enemy1random), s_width ,
                                    (int) (s_height * enemy1random) + allsprites.enemySize.height() * 4);
                            if(enemy1random >= 0.5f) { enemy1random = 0.2f; }
                            else {enemy1random += 0.1f; }
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                            if(explosion == 2) {gameDone() ;}
                        }
                        // Explosion when enemy2 is hit
                        if(enemy2Hit){
                            enemy2Hit = false;
                            ++timesOfEnemyHit;
                            sound_pool.play(soundMap.get(2),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect((int) (s_width * .7f), (int) (s_height * enemy2random),(int)(s_width * .8f) ,
                                    (int) (s_height * enemy2random) + allsprites.enemySize.height() * 4);
                            if(enemy2random >= 0.9f) { enemy2random = 0.6f; }
                            else {enemy2random += 0.1f; }
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                            if(explosion == 2) {gameDone() ;}
                        }
                        //ship shooting

                        place = new Rect((int) shipbullet.x - allsprites.shipSize.width() * 3 , (int) yTouch +  allsprites.shipBulletSprite.height() * 4, (int) shipbullet.x ,
                                (int) yTouch + allsprites.shipSize.height() * 2);
                        c.drawBitmap(allsprites.space, allsprites.shipBulletSprite, place, null);

                        //enemy1 shooting
                        place = new Rect(enemy1bullet.x ,(int) (s_height * enemy1random), enemy1bullet.x + allsprites.enemySize.width() ,(int) (s_height * enemy1random) + allsprites.enemySize.height() * 4);
                        c.drawBitmap(allsprites.space,allsprites.enemybulletSprite,place,null);
                        //enemy2 shooting
                        place = new Rect(enemy2bullet.x ,(int) (s_height * enemy2random), enemy2bullet.x + allsprites.enemySize.width() ,(int) (s_height * enemy2random) + allsprites.enemySize.height() * 4);
                        c.drawBitmap(allsprites.space,allsprites.enemybulletSprite,place,null);
                       /* Draw the timer on the screen*/
                        Paint paint = new Paint();
                        paint.setColor(Color.WHITE);
                        paint.setTextSize(30);
                        milliseconds = System.currentTimeMillis() - startTime;
                        seconds = (int) (milliseconds / 1000);
                        minute = seconds / 60;
                        seconds = seconds % 60;
                        c.drawText(minute + ":" + seconds,s_width * 0.9f ,s_height * 0.1f,paint);

                        holder.unlockCanvasAndPost(c);

                        //move bullets and update sprites
                        shipbullet.x += s_width / 20;
                        enemy1bullet.x -= s_width / 20;
                        enemy2bullet.x -= s_width / 20;

                        loc = ((loc + 1) % 6);
                        eLoc = (eLoc + 1) % 4;
                        e1Loc = (e1Loc + 1) % 6;
                        e2Loc = (e2Loc + 1) % 6;
                        m1Loc = (m1Loc + 1) % 4;
                        m2Loc = (m2Loc + 1) % 4;
                        m3Loc = (m3Loc + 1) % 4;

                        //check if bullet hit enemy or if ship is hit
                        checkHitEnemies();



                        //check if ship bullet is out of screen
                        if (shipbullet.x > s_width) {

                            resetShipBullet();
                        }
                        // check if enemy1bullet out of screen
                        if(enemy1bullet.x < (allsprites.enemybulletSprite.width() * -1)){
                            enemy1bullet.x = s_width - (allsprites.enemySize.width() * 5);
                        }
                        // check if enemy2bullet out of screen
                        if(enemy2bullet.x < (allsprites.enemybulletSprite.width() * -1)){
                            enemy2bullet.x = s_width - (allsprites.enemySize.width() * 5);
                        }
                        lastUpdate = System.currentTimeMillis();



                    }
                }
            }
        };
       /* Reset the ship bullet when it goes out of scope*/
        public void resetShipBullet()
        {
            sound_pool.play((int)soundMap.get(1),1,1,1,1,0);
            shipbullet.x = s_width - (int) (s_width * 0.8f);
            shipbullet.y = (int)yTouch ;

        }
        public void checkHitEnemies()
        {
/* to check if enemy1 bullet hit the ship */
            if( enemy1bullet.x <= (int)(s_width - s_width * 0.8) && enemy1bullet.x > 0 &&
                    (int) (s_height * enemy1random) >= (int) yTouch  && (int) (s_height * enemy1random) <= (int)yTouch + allsprites.shipSize.height()*6  )
            {
                shipHit = true;
                enemyNumber =  1;
                if(shipHitCount == 5){
                    explosion = 1;

                }
                ++shipHitCount;
            }
            /* to check if enemy2 bullet hit the ship */
            if( enemy2bullet.x <=(int)(s_width - s_width * 0.8) && enemy2bullet.x > 0 &&
                    (int) (s_height * enemy2random)  >= (int) yTouch  && (int) (s_height * enemy2random)   <= (int)yTouch + allsprites.shipSize.height()*6  )
            {
                shipHit = true;
                enemyNumber = 2;
                if(shipHitCount == 5){
                    explosion = 1;
                }
                ++shipHitCount;

            }

         /* TO check if the ship bullet hit enemy1*/
            if ( shipbullet.x   >=  (int) (s_width * .9f) && (int) yTouch +  allsprites.shipBulletSprite.height() * 4 >= (int) (s_height * enemy1random)
                    && shipbullet.x <=  s_width && (int) yTouch +  allsprites.shipBulletSprite.height() * 4 <= (int) (s_height * enemy1random) + allsprites.enemySize.height() * 4) {

                enemy1Hit = true;
                if( timesOfEnemyHit == 10 ){
                    explosion = 2;
                }
            }
/* To check if ship bullet hit enemy2*/
            if ( shipbullet.x   >=  (int) (s_width * .7f) && (int) yTouch +  allsprites.shipBulletSprite.height() * 4 >= (int) (s_height * enemy2random)
                    && shipbullet.x <=  (int)(s_width * .8f)&& (int) yTouch +  allsprites.shipBulletSprite.height() * 4 <= (int) (s_height * enemy2random) + allsprites.enemySize.height() * 4) {

                enemy2Hit = true;
                if( timesOfEnemyHit == 10 ){
                    explosion = 2;

                }
            }

        }

        public void startGame()
        {
            gameThread.start();
        }
        /* Go back to first activity when game is done*/
        public void gameDone(){
            change = false;
            String val = null;
            Intent i = null;
            String time = minute+":"+seconds;
            /* If explosion is 1 then the ship was hit 5 times and if it is 2 then 10 enemies were killed and is redirected to 1st activity */
            switch (explosion){
                case 1:
                    explosion = 0;
                    val = time + "!shiphit";
                    i = new Intent(TheGameLevel1X.this,MainActivity.class);
                    i.putExtra("time",val);
                    startActivity(i);
                    break;
                case 2:
                    explosion = 0;
                    val = time + "!success";
                    i = new Intent(TheGameLevel1X.this,MainActivity.class);
                    i.putExtra("time",val);
                    startActivity(i);
                    break;
            }

        }
        // three methods for the surfaceview
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {

            mPlayer.start(); //play main game song
            mPlayer.setLooping(true);  // for repeat song


        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int pixelFormat, int width, int height) {
            s_width = width;
            s_height = height;
            enemy1.x =(int)(s_width*.3f);
            enemy1.y = (int)(s_height*.3f);
            shipbullet.y = s_height - (allsprites.shipSize.height()*4 +allsprites.shipBulletSprite.height()*4);
            enemy1bullet.x = s_width - (allsprites.enemySize.width() * 4);
            sound_pool.play((int)soundMap.get(1),1,1,1,1,0); // Main song played
            enemy2bullet.x = s_width - (allsprites.enemySize.width() * 4);
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            mPlayer.release(); // release mediaplayer and sound pool
            sound_pool.release();
        }
    }




}
