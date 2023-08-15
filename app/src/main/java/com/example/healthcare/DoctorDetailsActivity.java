package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1={
            {"Doctor Name : Sakib Mollah","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
            {"Doctor Name : Minhaj Uddin","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
    };
    private String[][] doctor_details2={
            {"Doctor Name : Sakib Mollah","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
            {"Doctor Name : Minhaj Uddin","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
    };
    private String[][] doctor_details3={
            {"Doctor Name : Sakib Mollah","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
            {"Doctor Name : Minhaj Uddin","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
    };
    private String[][] doctor_details4={
            {"Doctor Name : Sakib Mollah","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
            {"Doctor Name : Minhaj Uddin","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
    };
    private String[][] doctor_details5={
            {"Doctor Name : Sakib Mollah","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
            {"Doctor Name : Minhaj Uddin","Hospital Address : Dhaka","Exp : 5yrs","Mobile NO:01836626334","500"},
    };
    String[][] getDoctor_details={};
    HashMap<String,String>item;
    ArrayList List;
    SimpleAdapter sa;
    TextView tv;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


     tv=findViewById(R.id.textlocation);
     btn=findViewById(R.id.backfromlab);
     Intent it=getIntent();
     String title= it.getStringExtra("title");
     tv.setText(title);
     if(title.compareTo("Family Physician")==0){
         getDoctor_details=doctor_details1;
     } else if (title.compareTo("Surgeon")==0) {
         getDoctor_details=doctor_details2;

     }
     else if (title.compareTo("Dietician")==0) {
         getDoctor_details=doctor_details3;

     }
     else if (title.compareTo("Dentist")==0) {
         getDoctor_details=doctor_details4;

     }
     else if (title.compareTo("Cardiologist")==0) {
         getDoctor_details=doctor_details5;

     }

        btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(DoctorDetailsActivity.this, DoctorActivity.class));
         }
     });
     List =new ArrayList<>();
     for(int i=0;i< getDoctor_details.length;i++){
         item=new HashMap<String,String>();
         item.put("line1",getDoctor_details[i][0]);
         item.put("line2",getDoctor_details[i][1]);
         item.put("line3",getDoctor_details[i][2]);
         item.put("line4",getDoctor_details[i][3]);
         item.put("line5","Doctor Fees: "+getDoctor_details[i][4]+"/-");
         List.add(item);

     }
     sa=new SimpleAdapter(this,List,R.layout.multiline,
             new String[]{"line1","line2","line3","line4","line5"},
             new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
             );
        ListView lst=findViewById(R.id.ListviewLab);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
               it.putExtra("text1",title);
                it.putExtra("text2",getDoctor_details[i][0]);
                it.putExtra("text3",getDoctor_details[i][1]);
                it.putExtra("text4",getDoctor_details[i][3]);
                it.putExtra("text5",getDoctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}