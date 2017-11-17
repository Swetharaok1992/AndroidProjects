package ubknights.com.spaceshooter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.HashMap;
/*
* @author: Swetha Krishnamurthy Rao
 * @UBID: 1004265
*/
public class MainActivity extends Activity {
String title = null;
String totalTime = null;
SoundPool pool;
int tempVal = 0;
AlertDialog.Builder build = null;
HashMap<Integer,Integer> soundMap = new HashMap<Integer, Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        pool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        soundMap.put(1, pool.load(MainActivity.this, R.raw.gameover, 1));
        soundMap.put(2, pool.load(MainActivity.this, R.raw.success, 1));

        String time = getIntent().getStringExtra("time");
        if (time != null) {
            String temp[] = time.split("!");
            if ((!temp[0].isEmpty()) && temp[1].equalsIgnoreCase("shiphit")) {
                title = "Game Over";
                totalTime = temp[0];
                tempVal = 1;

            }
            if ((!temp[0].isEmpty()) && temp[1].equalsIgnoreCase("success")) {
                title = "Success";
                totalTime = temp[0];
                tempVal = 2;
            }
        }
        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                if (tempVal == 1) {
                    soundPool.play(soundMap.get(1), 1, 1, 1, 0, 0);
                }
                if (tempVal == 2) {
                    soundPool.play(soundMap.get(2), 1, 1, 1, 0, 0);
                }

            }
        });
        if(title != null) {
            build = new AlertDialog.Builder(MainActivity.this);
            build.setTitle(title);
            build.setMessage("Total time: " + totalTime);
            build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pool.release();
                }
            });
            AlertDialog done = build.create();
            done.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //create a menu with two options: play round 1 or play round two
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE,0,Menu.NONE,"Round 1");
        menu.add(Menu.NONE,1,Menu.NONE,"Round 2");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 0:
                //start round1
                Intent t = new Intent(MainActivity.this, TheGameLevel1X.class);
                t.putExtra("currentTime", (long)System.currentTimeMillis());
                startActivity(t);
                return true;

            case 1:
                 //start round2

                Intent intent = new Intent(MainActivity.this, TheGameLevel2.class);
                intent.putExtra("currentTime", (long)System.currentTimeMillis());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }




}
