package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Uprise-D3 1000UI Capsule", "", "", "", "50"},
            {"Uprise-D3 1000UI Capsule", "", "", "", "50"},
            {"Uprise-D3 1000UI Capsule", "", "", "", "50"},
            {"Uprise-D3 1000UI Capsule", "", "", "", "50"},
            {"Uprise-D3 1000UI Capsule", "", "", "", "50"},


    };
    private  String[] package_details={
            "Building and keeping the bones & teeth strong\n Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increaseing resistance against infaction",
            "Building and keeping the bones & teeth strong\n Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increaseing resistance against infaction",
            "Building and keeping the bones & teeth strong\n Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increaseing resistance against infaction",

            "Building and keeping the bones & teeth strong\n Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increaseing resistance against infaction",

            "Building and keeping the bones & teeth strong\n Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increaseing resistance against infaction",

    };
   HashMap<String,String >item;
   ArrayList list;
   SimpleAdapter sa;
   ListView lst;
   Button btnBack,btncrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst=findViewById(R.id.ListviewMedicine);
        btnBack=findViewById(R.id.backfrommedicine);
        btncrd=findViewById(R.id.gotocardM);

        btncrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CardBuyMedicine.class));

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<package_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total cost: "+ packages[i][04]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multiline,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}