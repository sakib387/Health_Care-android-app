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

public class LoginActivity extends AppCompatActivity {
   EditText edUseranamem,edPassword;
   Button btn;
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUseranamem=findViewById(R.id.editTextUserName);
        edPassword=findViewById(R.id.editTextpASSWORD);
        btn=findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textRgForNewUser);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edUseranamem.getText().toString();
                String password=edPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if(username.length()==0||password.length()==0){
                   // startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    Toast.makeText(getApplicationContext(),"All  fields are required to fill",Toast.LENGTH_SHORT).show();

                }
                else{
                    if(db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(),"Login success ",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreference=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreference.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"usernaem or passowrd wrong ",Toast.LENGTH_SHORT).show();
                    }

                }
             }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }


        });
    }
}