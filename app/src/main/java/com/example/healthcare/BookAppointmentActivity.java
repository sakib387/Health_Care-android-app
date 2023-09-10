package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
  EditText ed1,ed2,ed3,ed4;
  private DatePickerDialog datePickerDialog;
  private TimePickerDialog timePickerDialog;
  Button dateButton,TimeButton,btnbook,btnback;
  TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        dateButton=findViewById(R.id.buttondateforcrd);
        TimeButton=findViewById(R.id.buttontimeforcrd);
        btnback=findViewById(R.id.buttonbacktodoctor);
        btnbook=findViewById(R.id.buttonRegisterbook);
        tv=findViewById(R.id.bookappointment);
        ed1=findViewById(R.id.editTextUserName);
        ed2=findViewById(R.id.bookingEmail);
        ed3=findViewById(R.id.userphone);
        ed4=findViewById(R.id.fees);
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);
        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String userphone=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");
        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(userphone);
        ed4.setText("cons fees"+fees+"/-");
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointmentActivity.this, DoctorActivity.class));
            }
        });
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //date
        initDatepicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        //time
        initTimePicker();
        TimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

    }
    private void initDatepicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private  void  initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
           TimeButton.setText(i+":"+i1);
            }
        };
        Calendar cal =Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int min=cal.get(Calendar.MINUTE);
        int style=AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,min,true);
    }
}