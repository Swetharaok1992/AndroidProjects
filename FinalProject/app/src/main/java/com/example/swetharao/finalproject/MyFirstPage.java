package com.example.swetharao.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyFirstPage extends AppCompatActivity {
    ImageView foodmenu;
    ImageView drinksmenu;
    ImageView info;
    ImageView reserve,myOrders;
    ImageView reviews;
    ImageView cart;
    Button login;
    Button newuser;
SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_page);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        foodmenu = (ImageView) findViewById(R.id.foodicon);
        drinksmenu = (ImageView) findViewById(R.id.drinksicon);
        info = (ImageView) findViewById(R.id.infoicon);
        reserve = (ImageView) findViewById(R.id.reservationicon);
        reviews = (ImageView) findViewById(R.id.reviewsicon);
        cart = (ImageView) findViewById(R.id.cart);
        myOrders = (ImageView)findViewById(R.id.ordersIcon);
        login = (Button) findViewById(R.id.loginButton);
        newuser=(Button)findViewById(R.id.signUp);
        if(!(pref.getString("userName","").equals(""))){
         login.setText("Logout");
         }
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack=new Intent(MyFirstPage.this,New_User.class);
                startActivityForResult(goBack,1);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().equals("Login")){
                    Intent loginStuff = new Intent(MyFirstPage.this, Login.class);
                    startActivityForResult(loginStuff, 0);//what does this line of code do

                }else{
                    pref.edit().putString("userName","").commit();
                    login.setText("Login");
                }


            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFirstPage.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,Reviews.class);
                startActivity(intent);
            }
        });
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,Reservation.class);
                startActivity(intent);
            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,MyInfo.class);
                startActivity(intent);
            }
        });

        drinksmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,MenuFood.class);
                startActivity(intent);
            }
        });
        foodmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyFirstPage.this,FoodMenu.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int req, int res, Intent data) {
        if (res == 0) {
            login.setText("Logout");
        }if (res==1){
            login.setText("Logout");
        }


    }

}
