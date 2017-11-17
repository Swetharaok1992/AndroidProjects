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
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
import java.util.HashMap;

import static android.nfc.NdefRecord.createUri;

/**
 * @authors: Carlos, Swetha Krishnamurthy Rao
 * @UBID: 1004265
 */

public class TheGameLevel2 extends Activity implements View.OnTouchListener{

    TheView mySurfaceView;      //the surfaceview, where we draw
    TheSprites2 allsprites; //class that has all the location and sizes of the images in the sprite
    Bitmap scaled;
    float xTouch,yTouch;          //the location when the screen is touched
    float meteor1random = 0.1f, meteor2random = 0.4f,meteor3random = 0.7f;
    int s_width,s_height,shipHitCount = 0,meteorShot = 0;       //the size of the surfaceview
    boolean shipHit, meteor1Hit, meteor2Hit,meteor3Hit ;
    MediaPlayer mPlayer; // Reference to play the main song
    SoundPool sound_pool; //SoundPool reference
    HashMap<Integer,Integer> soundMap = new HashMap<Integer, Integer>(); // map for loading and storing the sounds for later reference.
    //used for which sprite to use
    int loc = 0,eLoc=0,e1Loc=3,e2Loc=0,m1Loc=0,m2Loc=1,m3Loc=2,explosion = 0;
    Point shipbullet, meteor1, meteor2, meteor1bullet, meteor2bullet,meteormove1,meteormove2,meteormove3;
     int minute=0,seconds=0; long milliseconds=0;
    //15 frames per seconds
    float skipTime =1000.0f/30.0f; //setting 30fps
    long lastUpdate ;
    long  startTime = 0;
    int meteorNumber, timesOfmeteorHit;
    Vibrator v = null;
    float dt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        try {
            // for playing the audio
            Uri theUri = Uri.parse("android.resource://"+
                    TheGameLevel2.this.getPackageName()+
                    "/"+R.raw.mainsong);
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(TheGameLevel2.this, theUri);
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.prepare();
            sound_pool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
            soundMap.put(1, sound_pool.load(TheGameLevel2.this, R.raw.shipbullet, 1));
            soundMap.put(2,sound_pool.load(TheGameLevel2.this, R.raw.enemyboom, 1));
            soundMap.put(3,sound_pool.load(TheGameLevel2.this, R.raw.shipboom, 1));


        } catch (IOException e) {
            e.printStackTrace();
        }
        //setContentView(R.layout.spritesheetbetter); //not setting a static xml
        //set all the sprite locations and sizes
        allsprites = new TheSprites2(getResources());
        //make sure there is only ONE copy of the image and that the image
        //is in the drawable-nodpi. if it is not unwanted scaling might occur
        shipbullet = new Point(); //used for canvas drawing location
        meteor1 = new Point();     //used for canvas drawing location
        meteor1bullet = new Point(); //used for canvas drawing location
        meteor2bullet = new Point(); //used for canvas drawing location
        meteormove1 = new Point();
        meteormove2 = new Point();
        meteormove3 = new Point();
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
                        Log.d("meteorSize", allsprites.meteorSize.height() + "");
                        //draw the meteor 1
                        place = new Rect(meteormove1.x, (int) (s_height * meteor1random), meteormove1.x + allsprites.meteorSize.width() * 2 ,
                                (int) (s_height * meteor1random) + allsprites.meteorSize.height()  );
                        c.drawBitmap(allsprites.space, allsprites.meteorsprites[m1Loc], place, null);
                        //draw the meteor 2
                        place = new Rect(meteormove2.x, (int) (s_height * meteor2random), meteormove2.x + allsprites.meteorSize.width() * 2,
                                (int) (s_height * meteor2random) + allsprites.meteorSize.height()  );
                        c.drawBitmap(allsprites.space, allsprites.meteorsprites[m2Loc], place, null);
                        //draw the meteor3
                        place = new Rect(meteormove3.x, (int) (s_height * meteor3random), meteormove3.x + allsprites.meteorSize.width() * 2,
                                (int) (s_height * meteor3random) + allsprites.meteorSize.height()  );
                        c.drawBitmap(allsprites.space, allsprites.meteorsprites[m3Loc], place, null);
                        // Explosion for ship when hit by the meteors
                        if(shipHit) {
                            shipHit = false;
                            ++shipHitCount;
                            if(meteorNumber ==1){
                                meteorNumber = 0;
                                meteormove1.x = (int) (s_width * 0.9f);

                            }
                            if(meteorNumber == 2){
                                meteorNumber = 0;
                                meteormove2.x = (int) (s_width * 0.7f);
                            }
                            if(meteorNumber == 3){
                                meteorNumber = 0;
                                meteormove3.x = (int) (s_width * 0.8f);
                            }
                            sound_pool.play(soundMap.get(3),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect((int) (s_width * .1f), (int) yTouch, (int)(s_width - s_width * 0.8),
                                    (int)yTouch + allsprites.shipSize.height()*6);
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                            explosion = 1;
                            gameDone();


                        }
                        /* If meteor1 hit then relocate to random location*/
                        if(meteor1Hit){
                            meteor1Hit = false;
                            meteormove1.x = (int) (s_width * 0.9f);
                            ++timesOfmeteorHit;
                            sound_pool.play(soundMap.get(2),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect(meteormove1.x, (int) (s_height * meteor1random),  meteormove1.x + allsprites.meteorSize.width() ,
                                    (int) (s_height * meteor1random) + allsprites.meteorSize.height());
                            if(meteor1random >= 0.3f) { meteor1random = 0.1f; }
                            else {
                                meteor1random += 0.1f; }
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                        }
                        /* If meteor2 hit then relocate to random location*/
                        if(meteor2Hit){
                            meteor2Hit = false;
                            meteormove2.x = (int) (s_width * 0.7f);
                            ++timesOfmeteorHit;
                            sound_pool.play(soundMap.get(2),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect(meteormove2.x, (int) (s_height * meteor2random), meteormove2.x + allsprites.meteorSize.width() ,
                                    (int) (s_height * meteor2random) + allsprites.meteorSize.height());
                            if(meteor2random >= 0.6f) { meteor2random = 0.4f; }
                            else {
                                meteor2random += 0.1f; }
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                        }
                         /* If meteor2 hit then relocate to random location*/
                        if(meteor3Hit){
                            meteor3Hit = false;
                            meteormove3.x = (int) (s_width * 0.8f);
                            ++timesOfmeteorHit;
                            sound_pool.play(soundMap.get(2),1,1,1,1,0);
                            v.vibrate(400);
                            place = new Rect(meteormove3.x, (int) (s_height * meteor3random), meteormove3.x + allsprites.meteorSize.width() ,
                                    (int) (s_height * meteor3random) + allsprites.meteorSize.height());
                            if(meteor3random >= 1.0f) { meteor3random = 0.7f; }
                            else {
                                meteor3random += 0.1f; }
                            c.drawBitmap(allsprites.space, allsprites.boomsprites[loc], place, null);
                        }


                        //ship shooting
                        place = new Rect((int) shipbullet.x - allsprites.shipSize.width()  , (int) yTouch +  allsprites.shipBulletSprite.height() * 6, (int) shipbullet.x ,
                                (int) yTouch + allsprites.shipSize.height() * 3);
                        c.drawBitmap(allsprites.space, allsprites.shipBulletSprite, place, null);


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

                        //move bullets, meteors and update sprites
                        shipbullet.x += s_width / 20;
                        meteormove1.x -= s_width / 80;
                        meteormove2.x -= s_width / 80;
                        meteormove3.x -= s_width / 80;

                        loc = ((loc + 1) % 6);
                        eLoc = (eLoc + 1) % 4;
                        e1Loc = (e1Loc + 1) % 6;
                        e2Loc = (e2Loc + 1) % 6;
                        m1Loc = (m1Loc + 1) % 4;
                        m2Loc = (m2Loc + 1) % 4;
                        m3Loc = (m3Loc + 1) % 4;

                        //check if bullet hit  meteors
                        checkHitEnemies();

                        //check if ship bullet is out of screen
                        if (shipbullet.x > s_width) {

                            resetShipBullet();
                        }
                        // check if meteor1 out of screen
                        if(meteormove1.x < (allsprites.enemybulletSprite.width() * -1)){
                            meteormove1.x = (int) (s_width * 0.9f);
                        }
                        // check if meteor2 out of screen
                        if(meteormove2.x < (allsprites.enemybulletSprite.width() * -1)){
                            meteormove2.x = (int) (s_width * 0.7f);
                        }
                        // check if meteor3 out of screen
                        if(meteormove3.x < (allsprites.enemybulletSprite.width() * -1)){
                            meteormove3.x = (int) (s_width * 0.8f);
                        }
                        lastUpdate = System.currentTimeMillis();


                    }
                }
            }
        };
/* Reset the ship bullet when it goes out of screen*/
        public void resetShipBullet()
        {
            sound_pool.play((int)soundMap.get(1),1,1,1,1,0);// Play bullet sound
            shipbullet.x = s_width - (int) (s_width * 0.8f);
            shipbullet.y = (int)yTouch ;

        }
        public void checkHitEnemies()
        {
            /*check if meteor1 hit the ship and if yes then show explosion */
            if( meteormove1.x <= (int)(s_width - s_width * 0.8) && meteormove1.x > 0 &&
                    (int) (s_height * meteor1random) >= (int) yTouch  && (int) (s_height * meteor1random) + allsprites.meteorSize.height() <= (int)yTouch + allsprites.shipSize.height()*8 )
            {
                shipHit = true;
                meteorNumber =  1;
                if(shipHitCount == 1){
                  ++shipHitCount;
                }

            }
             /*check if meteor2 hit the ship and if yes then show explosion */
            if( meteormove2.x <=(int)(s_width - s_width * 0.8) && meteormove2.x > 0 &&
                    (int) (s_height * meteor2random)  >= (int) yTouch  && (int) (s_height * meteor2random) + allsprites.meteorSize.height()    <= (int)yTouch + allsprites.shipSize.height()*8  )
            {
                shipHit = true;
                meteorNumber = 2;
                if(shipHitCount == 1){
                    ++shipHitCount;

                }

            }
            /*check if meteor3 hit the ship and if yes then show explosion */
            if( meteormove3.x <=(int)(s_width - s_width * 0.8) && meteormove3.x > 0 &&
                    (int) (s_height * meteor3random)  >= (int) yTouch  && (int) (s_height * meteor3random) + allsprites.meteorSize.height()   <= (int)yTouch + allsprites.shipSize.height()*8  )
            {
                shipHit = true;
                meteorNumber = 3;
                if(shipHitCount == 1){
                    ++shipHitCount;

                }

            }

         /* TO check if the ship bullet hit meteor1*/
            if ( shipbullet.x   >=  meteormove1.x && (int) yTouch +  allsprites.shipBulletSprite.height() * 6 >= (int) (s_height * meteor1random)
                    && shipbullet.x <=   meteormove1.x + allsprites.meteorSize.width() && (int) yTouch +  allsprites.shipBulletSprite.height() * 6 <= (int) (s_height * meteor1random) + allsprites.meteorSize.height() ) {
                ++meteorShot;
                if(meteorShot == 3) {
                    meteor1Hit = true;
                    meteorShot = 0;

                }


                if( timesOfmeteorHit == 10 ){
                    String time = minute+":"+seconds;
                    String val = time + "!success";
                    Intent i = new Intent(TheGameLevel2.this,MainActivity.class);
                    i.putExtra("time",val);
                    startActivity(i);
                }
            }
               /* TO check if the ship bullet hit meteor2*/
            if ( shipbullet.x   >=  meteormove2.x && (int) yTouch +  allsprites.shipBulletSprite.height() * 6 >= (int) (s_height * meteor2random)
                    && shipbullet.x <=   meteormove2.x + allsprites.meteorSize.width()&& (int) yTouch +  allsprites.shipBulletSprite.height() * 6 <= (int) (s_height * meteor2random) + allsprites.meteorSize.height() ) {

                ++meteorShot;
                if(meteorShot == 2) {
                    meteor2Hit = true;
                    meteorShot = 0;
                }

                if( timesOfmeteorHit == 10 ){
                    String time = minute+":"+seconds;
                    String val = time + "!success";
                    Intent i = new Intent(TheGameLevel2.this,MainActivity.class);
                    i.putExtra("time",val);
                    startActivity(i);
                }
            }
            /* TO check if the ship bullet hit meteor3*/
            if ( shipbullet.x   >=  meteormove3.x && (int) yTouch +  allsprites.shipBulletSprite.height() * 6 >= (int) (s_height * meteor3random)
                    && shipbullet.x <=   meteormove3.x + allsprites.meteorSize.width()&& (int) yTouch +  allsprites.shipBulletSprite.height() * 6 <= (int) (s_height * meteor3random) + allsprites.meteorSize.height() ) {

// check if the meteor is hit thrice
                ++meteorShot;
                if(meteorShot == 2) {
                    meteor3Hit = true;
                    meteorShot = 0;
                }
                if( timesOfmeteorHit == 10 ){
                    String time = minute+":"+seconds;
                    String val = time + "!success";
                    Intent i = new Intent(TheGameLevel2.this,MainActivity.class);
                    i.putExtra("time",val);
                    startActivity(i);
                }
            }

        }

        public void startGame()
        {
            gameThread.start();
        }
        /* Go back to the first activity when done*/
        public void gameDone(){
            change = false;
            if(explosion == 1) {
                String time = minute + ":" + seconds;
                String val = time + "!shiphit";
                Intent i = new Intent(TheGameLevel2.this, MainActivity.class);
                i.putExtra("time", val);
                startActivity(i);
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
            meteor1.x =(int)(s_width*.3f);
            meteor1.y = (int)(s_height*.3f);
            shipbullet.y = s_height - (allsprites.shipSize.height()*4 +allsprites.shipBulletSprite.height()*4);
            meteor1bullet.x = s_width - (allsprites.enemySize.width() * 4);
            sound_pool.play((int)soundMap.get(1),1,1,1,1,0);
            meteor2bullet.x = s_width - (allsprites.enemySize.width() * 4);
            meteormove1.x = (int) (s_width * 0.9f);
            meteormove2.x = (int) (s_width * 0.7f);
            meteormove3.x = (int) (s_width * 0.8f);
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
/* Release media player and sound pool*/
            mPlayer.release();
            sound_pool.release();
        }
    }


}
