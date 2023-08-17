package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabDetailsActivity extends AppCompatActivity {
  TextView tvpackage,tvTotalcost;
  EditText edDetails;
  Button btnAdtoCard,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_details);
        tvpackage=findViewById(R.id.cartpackage);
        tvTotalcost=findViewById(R.id.labtestprice);
        edDetails=findViewById(R.id.labtestmultiline);
        btnBack=findViewById(R.id.backfromlabdtl);
        btnAdtoCard=findViewById(R.id.checkout);
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
        btnAdtoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreference=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreference.getString("username","").toString();
                String product=tvpackage.getText().toString();
                float price=Float.parseFloat((intent.getStringExtra("text3".toString())));
            Database db=new Database(getApplicationContext(),"healthcare",null,1);
            if(db.checkCart(username,product)==1){
                Toast.makeText(getApplicationContext(),"Product Already Added",Toast.LENGTH_SHORT).show();
            }
            else{
                db.addCart(username,product,price,"Lab");
                Toast.makeText(getApplicationContext(),"Added to card",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabDetailsActivity.this,LabTestActivity.class));
            }

            }
        });
    }
}