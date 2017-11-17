package com.example.swetharao.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class New_User extends AppCompatActivity {

    Button newUserButton;
    EditText email;
    EditText password;
    EditText confirm;
    boolean passwordCheck = false;
    SQLiteDatabase dbNew;
    SharedPreferences pref;
    SQL db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__user);
        pref = getSharedPreferences("sessionVariable", MODE_PRIVATE);
        newUserButton=(Button)findViewById(R.id.confirmSignUP);
        email=(EditText)findViewById(R.id.emailText);
        password=(EditText)findViewById(R.id.passwordText);
        confirm=(EditText)findViewById(R.id.confirmPasswordText);
        db = new SQL(this,"projectdb10.db",null,1);
        dbNew = db.getWritableDatabase();
        confirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                   if(!(password.getText().toString().equals(confirm.getText().toString()))){
                       Toast.makeText(New_User.this,"Password Do Not Match",Toast.LENGTH_SHORT).show();
                   }
                    else{
                       passwordCheck = true;
                   }

                }
            }
        });
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor ;
                if(passwordCheck){
                    String userName = email.getText().toString().substring(0,email.getText().toString().indexOf("@") );
                  dbNew.execSQL("insert into userDetails values ('" + userName + "', '" + password.getText().toString() + "', '" + email.getText().toString() + "');");
                    pref.edit().putString("userName",userName ).commit();
                    Intent goBack=new Intent();
                    goBack.putExtra("userName",userName);
                    setResult(1,goBack);
                    Toast.makeText(New_User.this, "Welcome," + userName, Toast.LENGTH_LONG).show();
                    finish();
                }


            }
        });

    }
}
