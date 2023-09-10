package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LAbTestBookActivity extends AppCompatActivity {
   EditText edname,edaddress,edcontact,edpincode;
   Button btnbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edname=findViewById(R.id.BookinName);
        edaddress=findViewById(R.id.bookingAddress);
        edcontact=findViewById(R.id.bookingEmail);
        edpincode=findViewById(R.id.bookingPIn);
        btnbook=findViewById(R.id.buttonBook);
        Intent intent=getIntent();
        String[] price =intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    String username = sharedPreferences.getString("username", "");
                    String originalPrice = price[1].toString();
                    Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                    db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpincode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(originalPrice.substring(0, originalPrice.length() - 2).toString()), "Lab");
                    db.removeCart(username, "Lab");

                    Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LAbTestBookActivity.this, HomeActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "An error here  " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}