package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
   EditText edUsername,edEmail,edpassword,edConfirmpassword;
   Button btn;
   TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername=findViewById(R.id.editTextUserName);
        edEmail=findViewById(R.id.editTexEmail);
        edpassword=findViewById(R.id.editTextPassword);
        edConfirmpassword=findViewById(R.id.editConfirmPassword);
        btn=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textHaveAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edpassword.getText().toString();
                String confirmPassword=edConfirmpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0||email.length()==0||password.length()==0||confirmPassword.length()==0){
                    Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                }
                else if(password.compareTo(confirmPassword)!=0){

                    Toast.makeText(getApplicationContext(), "Password does't match",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(isValid(password)){
                        db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "Registration successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password must be at lest 6 character",Toast.LENGTH_SHORT).show();

                    }                }
            }
        });

    }
    public static boolean isValid(String password){
        if(password.length()>=6){
            return  true;
        }
        else {
            return  false;
        }
    }
}