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

public class HealthArticalActivity extends AppCompatActivity {

    private  String[][] health_details={
        {"walking daily","","","","click more details"},
            {"Home care of covid 19","","", "","click more details"},
            {"stop smoking","","","","click more details"},
            {"menstrual cramps","","","","click more details"},
            {"healthy gut","","","","click more details"}
    };
    private int [] Image={
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,

    };
    HashMap<String,String >item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnback;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_artical);

    btnback=findViewById(R.id.backfromartical);
    lst=findViewById(R.id.ListviewArtical);
    btnback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(HealthArticalActivity.this,HomeActivity.class));
        }
    });
    list =new ArrayList();
    for (int i=0;i<health_details.length;i++){
        item=new HashMap<String,String>();
        item.put("line1",health_details[i][0]);
        item.put("line2",health_details[i][1]);
        item.put("line3",health_details[i][2]);
        item.put("line4",health_details[i][3]);
        item.put("line5",health_details[i][4]);
        list.add(item);
    }
    sa=new SimpleAdapter(this,list,R.layout.multiline,
            new String[]{"line1","line2","line3","line4","line5"},
            new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
            );
    lst.setAdapter(sa);
    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            Intent it=new Intent(HealthArticalActivity.this,HealthArticalDetailsActivity.class);
           it.putExtra("text1",health_details[i][0]);
           it.putExtra("text2",Image[i]);
           startActivity(it);
        }
    });
    }
}