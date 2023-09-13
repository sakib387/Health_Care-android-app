package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailsActivity extends AppCompatActivity {
   TextView tvPackageName,tvTotalcost;
   EditText edDetails;
   Button btnBack,btnCrd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);
        tvTotalcost=findViewById(R.id.MDpriceDD);
        tvPackageName=findViewById(R.id.MDpackageDD);
        edDetails=findViewById(R.id.BuyMDmultilineDD);
        edDetails.setKeyListener(null);
        btnBack=findViewById(R.id.backfromMDDD);
        btnCrd=findViewById(R.id.DDcheckoutCart);
        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalcost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");
      btnBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
          }
      });
      btnCrd.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {


              SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
              String username = sharedPreferences.getString("username", "");
            String product=tvPackageName.getText().toString();
            float price=Float.parseFloat(intent.getStringExtra("text3").toString());
          Database db=new Database(getApplicationContext(),"healthcare",null,1);

         if(db.checkCart(username,product)==1){
             Toast.makeText(getApplicationContext(),"Product Already Added",Toast.LENGTH_SHORT).show();

         }
         else {
             db.addCart(username,product,price,"medicine");
             Toast.makeText(getApplicationContext(),"Product Added to Cart",Toast.LENGTH_SHORT).show();
             startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
         }

          }
      });
    }
}