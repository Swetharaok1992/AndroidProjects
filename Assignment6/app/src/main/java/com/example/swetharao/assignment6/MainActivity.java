package com.example.swetharao.assignment6;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Swetha Krishnamurthy Rao
 * @UBID: 1004265
 */
public class MainActivity extends AppCompatActivity {
    /* Variables needed for this activity*/

    CustomRow customRow;
    ListView listView;
    HashMap<Integer,String> listMap = new HashMap<Integer,String>();
    String[] str;
    String line1, line2, line3, line4, line5, line6, line7, line8;
    BufferedReader temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8;
    String name = "list";
    QuestionsData qd = new QuestionsData();
    MyDatabaseCreator mydataCreator;
    SQLiteDatabase db,dbNew;
    AssetManager mgr;
    boolean found = false;
    SharedPreferences spref ;
    TextView entries;
    int delete = 0,both = 0, both1Data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listMap.clear();
        // shared preference creation with private mode.
        spref = MainActivity.this.getSharedPreferences(name, Context.MODE_PRIVATE);
        mgr = getAssets();
        listView = (ListView)findViewById(R.id.listView);
        entries = (TextView)findViewById(R.id.entries);
        entries.setText("Please choose from Menu");
        // name of the files stored as a string array
        str = new String[]{"names", "age", "colors", "diet", "food", "food2", "gender", "salary"};
        mydataCreator = new MyDatabaseCreator(MainActivity.this);
        db = mydataCreator.getWritableDatabase();
        dbNew = mydataCreator.getReadableDatabase();
        try {
            createPreference();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuforoptions,menu);
        return true;
    }
    /* On selection of menuitem from menus */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        /* Based on the id, select the SQL queries using query function of cursor */
       switch(item.getItemId()){
           case R.id.allemployees:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }

               Cursor employeesList = dbNew.query("Employees", null, null, null, null, null, "name");
               displayList(employeesList);

               break;
           case R.id.delete:
               db.close();
               dbNew.close();
               MainActivity.this.deleteDatabase("mydatabase.db");
               spref.edit().clear().commit();
               listView.setAdapter(null);
               entries.setText("");
               delete = 1;
               Toast.makeText(MainActivity.this,"Database Successfully deleted!",Toast.LENGTH_LONG).show();
               break;
           case R.id.m1:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }

               Cursor chickenLovers = dbNew.query("Employees", null, "food = 'chicken' OR food2 ='chicken'", null, null, null, "name");
               displayList(chickenLovers);
               break;
           case R.id.m2:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor goatLovers = dbNew.query("Employees", null, "food = 'goat' OR food2 ='goat'", null, null, null, "name");
               displayList(goatLovers);
               break;
           case R.id.m3:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor sixtykSalary = dbNew.query("Employees", null, "salary < '60000' ", null, null, null, "name");
               displayList(sixtykSalary);
               break;
           case R.id.m4:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor ageLessThan38 = dbNew.query("Employees", null, "age < '38' ", null, null, null, "name");
               displayList(ageLessThan38);
               break;
           case R.id.m5:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor blueFemale = dbNew.query("Employees", null, "colors = 'blue' AND gender = 'female' ", null, null, null, "name");
               displayList(blueFemale);
               break;
           case R.id.g1:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor seventykSalary = dbNew.query("Employees", null, "salary > '70000' ", null, null, null, "name");
               displayList(seventykSalary);
               break;
           case R.id.g2:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor fortyAndPoultry = dbNew.query("Employees", null, "age > '40' AND diet ='poultry' ", null, null, null, "name");
               displayList(fortyAndPoultry);
               break;
           case R.id.g3:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor fortyAndTurkey = dbNew.query("Employees", null, "age < '40' AND food ='turkey' ", null, null, null, "name");
               displayList(fortyAndTurkey);
               break;
           case R.id.g4:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor maleRedMeat = dbNew.query("Employees", null, "colors = 'red' AND gender ='male' AND diet = 'redMeat'", null, null, null, "name");
               displayList(maleRedMeat);
               break;
           case R.id.g5:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }
               Cursor femaleVegTofu = dbNew.query("Employees", null, "food = 'tofu' AND food2 = 'tofu' AND gender ='female' AND diet = 'vegetarian'", null, null, null, "name");
               displayList(femaleVegTofu);
               break;
           case R.id.b1:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }

               both = 1;
               Cursor bothResult1 = dbNew.query("Employees", null, "colors = 'blue'", null, null, null, "name");
               displayList(bothResult1);
               break;
           case R.id.b2:
               if(delete == 1){
                   Toast.makeText(MainActivity.this,"Database deleted. Can't show the list.",Toast.LENGTH_LONG).show();
                   return false;
               }

               both = 1;
               Cursor bothResult2 = dbNew.query("Employees", null, "colors = 'yellow' AND gender = 'female' AND diet = 'redMeat'", null, null, null, "name");
               Cursor bothResult3 = dbNew.query("Employees", null, "colors = 'blue' AND gender = 'male' AND diet = 'poultry'", null, null, null, "name");
               int listFemale = bothResult2.getCount();
               int listMale = bothResult3.getCount();
               if(listFemale > 30){
                   displayList(bothResult2);
               }
               else if(listMale > 30){
                   displayList(bothResult3);
               }
               else{
                   entries.setText("");
                   listView.setAdapter(null);
                   Toast.makeText(MainActivity.this,"There are no list over 30.",Toast.LENGTH_LONG).show();
               }
               break;
       }
        return true;
    }
    /* Creates a shared preference file with all the details from the other files */
    public void createPreference() throws IOException {
        //spref.edit().clear().commit();
        if (spref.getAll() == null || spref.getAll().size() == 0) {
            found = true;
            SharedPreferences.Editor editor = spref.edit();
            for (int i = 0; i < str.length; i++) {
                temp1 = new BufferedReader(new InputStreamReader(mgr.open(str[0] + ".txt")));
                temp2 = new BufferedReader(new InputStreamReader(mgr.open(str[1] + ".txt")));
                temp3 = new BufferedReader(new InputStreamReader(mgr.open(str[2] + ".txt")));
                temp4 = new BufferedReader(new InputStreamReader(mgr.open(str[3] + ".txt")));
                temp5 = new BufferedReader(new InputStreamReader(mgr.open(str[4] + ".txt")));
                temp6 = new BufferedReader(new InputStreamReader(mgr.open(str[5] + ".txt")));
                temp7 = new BufferedReader(new InputStreamReader(mgr.open(str[6] + ".txt")));
                temp8 = new BufferedReader(new InputStreamReader(mgr.open(str[7] + ".txt")));
                while ((line1 = temp1.readLine()) != null && (line2 = temp2.readLine()) != null && (line3 = temp3.readLine()) != null &&
                        (line4 = temp4.readLine()) != null && (line5 = temp5.readLine()) != null && (line6 = temp6.readLine()) != null
                        && (line7 = temp7.readLine()) != null && (line8 = temp8.readLine()) != null) {

                    qd.setName(line1);
                    qd.setAge(line2);
                    qd.setColors(line3);
                    qd.setDiet(line4);
                    qd.setFood(line5);
                    qd.setFood2(line6);
                    qd.setGender(line7);
                    qd.setSalary(line8);
                    String temp = qd.getAge() + "::" + qd.getColors() + "::" + qd.getDiet() + "::" + qd.getFood() + "::" + qd.getFood2() + "::" + qd.getGender() + "::" + qd.getSalary();
                    editor.putString(qd.getName(), temp);
                    editor.commit();

                }

            }

            insertRecordToDB();

        }
    }
/* Display the result as a listView on the activity*/
    public void displayList(Cursor recordset1){
        listMap.clear();
        recordset1.moveToFirst();
        if(recordset1.getCount() > 0) {
            for (int i = 0; i < recordset1.getCount(); i++) {
                if(both == 1){
                    String nameTemp = recordset1.getString(recordset1.getColumnIndex("name"));
                    if((nameTemp.split(" ")[1].startsWith("M") ||nameTemp.split(" ")[1].startsWith("O") )){
                        listMap.put(both1Data, recordset1.getString(recordset1.getColumnIndex("name")) + "::" + recordset1.getString(recordset1.getColumnIndex("age")) + "::"
                                + recordset1.getString(recordset1.getColumnIndex("colors")) + "::" + recordset1.getString(recordset1.getColumnIndex("diet")) + "::" +
                                recordset1.getString(recordset1.getColumnIndex("food")) + "::" + recordset1.getString(recordset1.getColumnIndex("food2")) + "::" +
                                recordset1.getString(recordset1.getColumnIndex("gender")) + "::" + recordset1.getString(recordset1.getColumnIndex("salary")));
                        both1Data++;
                    }
                    recordset1.moveToNext();
                }
                else {
                    listMap.put(i, recordset1.getString(recordset1.getColumnIndex("name")) + "::" + recordset1.getString(recordset1.getColumnIndex("age")) + "::"
                            + recordset1.getString(recordset1.getColumnIndex("colors")) + "::" + recordset1.getString(recordset1.getColumnIndex("diet")) + "::" +
                            recordset1.getString(recordset1.getColumnIndex("food")) + "::" + recordset1.getString(recordset1.getColumnIndex("food2")) + "::" +
                            recordset1.getString(recordset1.getColumnIndex("gender")) + "::" + recordset1.getString(recordset1.getColumnIndex("salary")));
                    recordset1.moveToNext();
                }
            }
            if (recordset1 != null && !recordset1.isClosed()) {
                recordset1.close();
            }
            both = 0;
            both1Data = 0;
            entries.setText("Total entries: " + listMap.size());
            customRow = new CustomRow(this, listMap);
            listView.setAdapter(customRow);
        }
    }
    /*  Insert into the database with column values*/
        void insertRecordToDB(){
            ContentValues values = new ContentValues();
            Map<?,?> readPref = new HashMap<>();
            if(found){
                found = false;
                readPref = spref.getAll();
                for(Map.Entry tempRead : readPref.entrySet()){
                    String[] splitValue = ((String) tempRead.getValue()).split("::");
                    values.put("name",(String)tempRead.getKey());
                    values.put("age",splitValue[0]);
                    values.put("colors", splitValue[1]);
                    values.put("diet", splitValue[2]);
                    values.put("food",splitValue[3]);
                    values.put("food2", splitValue[4]);
                    values.put("gender", splitValue[5]);
                    values.put("salary", splitValue[6]);
                    db.insert("Employees", null, values);


                }

            }



        }

    }

