package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticalDetailsActivity extends AppCompatActivity {
    TextView tv1;
    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_artical_details);
        btn=findViewById(R.id.backfromHA);
        img=findViewById(R.id.HAimage);
        tv1=findViewById(R.id.HApackage);
        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticalDetailsActivity.this,HealthArticalActivity.class));
            }
        });
    }
}