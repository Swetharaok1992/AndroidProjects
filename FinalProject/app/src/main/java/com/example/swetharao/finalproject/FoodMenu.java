package com.example.swetharao.finalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodMenu extends AppCompatActivity {
    SQL db;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    SQLiteDatabase qdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        btn1 = (Button)findViewById(R.id.sidesbtn);
        btn1.setOnClickListener(clickme);
        btn2 = (Button)findViewById(R.id.soupsbtn);
        btn2.setOnClickListener(clickme);
        btn3 = (Button)findViewById(R.id.chef_spl);
        btn3.setOnClickListener(clickme);
        btn4 = (Button)findViewById(R.id.starters);
        btn4.setOnClickListener(clickme);
        btn5 = (Button)findViewById(R.id.desserts);
        btn5.setOnClickListener(clickme);
        btn6 = (Button)findViewById(R.id.main_course);
        btn6.setOnClickListener(clickme);
        db = new SQL(this,"projectdb10.db",null,1);
        qdb = db.getReadableDatabase();

    }
    View.OnClickListener clickme = new View.OnClickListener() {

        @Override
        public void onClick(View v) { /*redirects to list view*/
            switch(v.getId()) {
                case R.id.sidesbtn:
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this, Custom_ViewFood.class);
                            intent.putExtra("id","1");
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.soupsbtn:
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this,Custom_ViewFood.class);
                            intent.putExtra("id","2");
                            startActivity(intent);
                        }
                    });
                    break;

                case R.id.chef_spl:
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this,Custom_ViewFood.class);
                            intent.putExtra("id","3");
                            startActivity(intent);
                        }
                    });
                    break;

                case R.id.starters:
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this,Custom_ViewFood.class);
                            intent.putExtra("id","4");
                            startActivity(intent);
                        }
                    });


                    break;
                case R.id.desserts:

                    btn5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this,Custom_ViewFood.class);
                            intent.putExtra("id","5");
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.main_course:

                    btn6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(FoodMenu.this,Custom_ViewFood.class);
                            intent.putExtra("id","6");
                            startActivity(intent);
                        }
                    });
                    break;


            }
        }
    };
}
