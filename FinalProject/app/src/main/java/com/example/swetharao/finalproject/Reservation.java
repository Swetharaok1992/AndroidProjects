package com.example.swetharao.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {
EditText tableFor, time, name,phone;
    Button reserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        tableFor = (EditText)findViewById(R.id.tableEdit);
        name = (EditText)findViewById(R.id.nameEdit);
        time = (EditText)findViewById(R.id.time);
        phone = (EditText)findViewById(R.id.editText6);

        reserve = (Button)findViewById(R.id.Reserve);

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage((phone.getText()).toString(), null,"Reservation Confirmed: Name:  " + name.getText().toString() + " Table for: " + tableFor.getText().toString() + " @ " + time.getText().toString(), null, null);

                Toast.makeText(Reservation.this, "Reservation Confirmed.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Reservation.this,MyFirstPage.class);
                startActivity(i);
            }
        });
    }
}
