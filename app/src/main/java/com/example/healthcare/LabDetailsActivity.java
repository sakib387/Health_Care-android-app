package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LabDetailsActivity extends AppCompatActivity {
  TextView tvpackage,tvTotalcost;
  EditText edDetails;
  Button btnAdtoCard,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_details);
        tvpackage=findViewById(R.id.LabtestpackageLD);
        tvTotalcost=findViewById(R.id.labtestprice);
        edDetails=findViewById(R.id.labtestmultiline);
        btnBack=findViewById(R.id.backfromlabdtl);
        btnAdtoCard=findViewById(R.id.cardadd);
        edDetails.setKeyListener(null);
        Intent intent=getIntent();
        tvpackage.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalcost.setText("Total "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabDetailsActivity.this,LabTestActivity.class));
            }
        });
    }
}