package com.example.swetharao.flagsquizgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
/*
 @Author: Swetha Krishnamurthy Rao
 @UBID: 1004265
 */
public class MainActivity extends AppCompatActivity {
    boolean[] selectedRegions = new boolean[5];
    final String[] flagList = {"Africa", "Europe", "Asia", "North America", "South America"};
    String regionSelected;
    Button start;
    int temp = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Regions", regionSelected);
                regionSelected = null;
                startActivity(intent);
            }
        });
    }

    @Override
    /* Load menu on this activity*/
   public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.categories,menu);
        return true;
    }
    @Override
/* Menu on selection from this activity */
    public boolean onOptionsItemSelected(MenuItem menu){


         switch(menu.getItemId()){

             case R.id.categories:

                 AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                 build.setTitle("Pick a Region");
                 Arrays.fill(selectedRegions,false);
                 build.setMultiChoiceItems(flagList, null, new DialogInterface.OnMultiChoiceClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                         if(isChecked){
                             selectedRegions[which] = true;
                         }
                         else{
                             selectedRegions[which] = false;
                         }
                     }
                 });
/* On click of start buttonnfrom the dialog after selecting the regions.*/
                 build.setPositiveButton("Start", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                      if(selectedRegions[0] == false && selectedRegions[1] == false && selectedRegions[2] == false && selectedRegions[3] == false
                              && selectedRegions[4] == false){
                          Toast.makeText(MainActivity.this,"A region must be picked before continuing",Toast.LENGTH_LONG).show();
                      }
                         else{
                          for(int i = 0 ; i<selectedRegions.length ;i++){
                              if(selectedRegions[i]){
                                  regionSelected = flagList[i] + "," + regionSelected;
                               ++temp;
                              }
                          }
                          if(!(temp >=4)){
                              temp = 0;
                              Toast.makeText(MainActivity.this,"Must pick atleast four regions", Toast.LENGTH_LONG).show();
                          }
                          else{
                              temp = 0;
                              start.setEnabled(true);

                          }
                      }

                     }
                 });
                         AlertDialog done = build.create();
                 done.show();


                 return true;

             default:

                return super.onOptionsItemSelected(menu);

}
 }
}
