package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorDetailsActivity extends AppCompatActivity {
    TextView tv;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
     tv=findViewById(R.id.textDoctordetails);
     btn=findViewById(R.id.backtopre);
     Intent it=getIntent();
     String title= it.getStringExtra("title");
     tv.setText(title);
     btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(DoctorDetailsActivity.this, DoctorActivity.class));
         }
     });
    }
}