package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookRentalActivity extends AppCompatActivity {
    Button bookrental;
    EditText phone, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_rental);

        bookrental = findViewById(R.id.buttonBookrental);
        phone = findViewById(R.id.editTextPhone);
        date = findViewById(R.id.editTextDate);

        bookrental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendSMS();
                    } else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                } else {
                    sendSMS();
                }
            }
        });
    }

    private void sendSMS() {
        String phoneNo = phone.getText().toString().trim();
        String message = date.getText().toString().trim();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(BookRentalActivity.this, "Message sent successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(BookRentalActivity.this, "Failed to send message", Toast.LENGTH_LONG).show();
        }
    }
}
