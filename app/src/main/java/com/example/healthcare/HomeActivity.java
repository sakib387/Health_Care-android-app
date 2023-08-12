package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreference=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreference.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();
        CardView logout=findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreference.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(getApplicationContext(),"Good buy "+username,Toast.LENGTH_SHORT).show();

                startActivity(new Intent(HomeActivity.this, LoginActivity.class));

            }
        });
    }
}