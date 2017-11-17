package com.example.swetharao.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/* Login page to check the credentials of a user */
public class Login extends AppCompatActivity {
    Button enter;
    EditText userText;
    EditText passwordText;
    SQLiteDatabase dbNew;
    SQL db;
    SharedPreferences pref;
    static int tempValue = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        enter=(Button)findViewById(R.id.enterCredentials);
        userText=(EditText)findViewById(R.id.userName);
        passwordText=(EditText)findViewById(R.id.password);
        db = new SQL(this,"projectdb10.db",null,1);
        dbNew = db.getReadableDatabase();
        passwordText.setText("");
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor getLoginData = dbNew.query("userDetails",null,"emailID = '" + userText.getText().toString() + "' AND password = '" + passwordText.getText().toString() + "'",null,null,null,null);

                if(!(getLoginData.moveToFirst()) || getLoginData.getCount() == 0){
                    userText.setText("Enter Email");
                    passwordText.setText("");
                    pref.edit().putString("userName", "G001"+ tempValue).commit();
                    Toast.makeText(Login.this,"Wrong credentials. Please enter the correct Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent goBack=new Intent();
                    pref.edit().putString("userName", userText.getText().toString().substring(0,userText.getText().toString().indexOf("@"))).commit();
                    goBack.putExtra("userName",userText.getText().toString().substring(0,userText.getText().toString().indexOf("@") ));
                    setResult(0,goBack);
                    Toast.makeText(Login.this, "Hello," + userText.getText().toString(), Toast.LENGTH_LONG).show();
                    finish();
                }



            }
        });




    }
}
