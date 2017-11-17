package com.example.swetharao.finalproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MenuFood extends AppCompatActivity  {

    SQL db;
    Button btn1, btn2, btn3,btn4,btn5,btn6,btn7;
    SQLiteDatabase qdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_food);
        btn1 = (Button) findViewById(R.id.ck);
        btn1.setOnClickListener(clickme);
        btn2 = (Button) findViewById(R.id.cmp);
        btn2.setOnClickListener(clickme);
        btn3 = (Button) findViewById(R.id.sodas);
        btn3.setOnClickListener(clickme);
        btn5 = (Button) findViewById(R.id.rbtn);
        btn5.setOnClickListener(clickme);
        btn6 = (Button) findViewById(R.id.wbtn);
        btn6.setOnClickListener(clickme);
        btn7 = (Button) findViewById(R.id.gbtn);
        btn7.setOnClickListener(clickme);
        btn4=(Button)findViewById(R.id.wine) ;
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "CHOOSE WINE TYPE", Toast.LENGTH_SHORT).show();
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn7.setVisibility(View.VISIBLE);

            }
        });
        db = new SQL(this, "projectdb10.db", null, 1);
        qdb = db.getReadableDatabase();

    }


    View.OnClickListener clickme = new View.OnClickListener() {

        @Override
        public void onClick(View v) { /*redirects to list view*/
            switch (v.getId()) {
                case R.id.ck:
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "1");
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.cmp:
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "2");
                            startActivity(intent);
                        }
                    });
                    break;

                case R.id.sodas:
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "3");
                            startActivity(intent);
                        }
                    });
                    break;

                case R.id.rbtn:
                    btn5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "4");
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.wbtn:
                    btn6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "5");
                            startActivity(intent);
                        }
                    });
                    break;
                case R.id.gbtn:
                    btn7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MenuFood.this, list_view.class);
                            intent.putExtra("id", "6");
                            startActivity(intent);
                        }
                    });
                    break;

            }
        }
    };


}



