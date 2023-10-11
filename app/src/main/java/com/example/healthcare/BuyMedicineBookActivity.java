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
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
   EditText edname,edaddress,edcontact,edpin;
   Button btnBook,back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);
        edname=findViewById(R.id.BookinNameMD);
        edaddress=findViewById(R.id.bookingAddressMD);
        edcontact=findViewById(R.id.bookingEmailMD);
        edpin=findViewById(R.id.bookingPInMD);
        btnBook=findViewById(R.id.buttonBookMD);
        back=findViewById(R.id.buttonBookMDBack);


        Intent intent=getIntent();
        String[] price =intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));

            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    String username = sharedPreferences.getString("username", "");
                    String originalPrice = price[1].toString();
                    Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                    db.addOrder(username, edname.getText().toString(), edaddress.getText().toString(), edcontact.getText().toString(), Integer.parseInt(edpin.getText().toString()), date.toString(), "", Float.parseFloat(originalPrice.substring(0, originalPrice.length() - 2).toString()), "medicine");
                    db.removeCart(username, "medicine");

                    Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "An error here  " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}