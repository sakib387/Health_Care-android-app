package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                if(username.length()==0||password.length()==0){
                    Toast.makeText(getApplicationContext(),"All  fields are required to fill",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Login button ",Toast.LENGTH_SHORT).show();

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