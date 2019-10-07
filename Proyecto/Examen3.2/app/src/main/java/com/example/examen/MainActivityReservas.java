package com.example.examen;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

import java.util.Calendar;

public class MainActivityReservas extends AppCompatActivity implements View.OnClickListener {

    Button bfecha,bhora;
    EditText efecha,ehora;
  private  int dia,mes,añho,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reservas);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
bfecha=(Button)findViewById(R.id.fecha);
bhora=(Button)findViewById(R.id.hora);
efecha=(EditText)findViewById(R.id.fecha1);
        bhora.setOnClickListener(this);
        bfecha.setOnClickListener(this);
 ehora=(EditText)findViewById(R.id.hora1);

        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layoutR);
        SlidingDrawerToggle toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button as = (Button) findViewById(R.id.button1);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivityReservas.this, MainPelotas.class);
                startActivity(d);
            }
        });

        Button asi = (Button) findViewById(R.id.button2);
        asi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivityReservas.this, MainActivityRegistrarUsuario.class);
                startActivity(d);
            }
        });

    }

    @Override
    public void onBackPressed() {
        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layoutR);
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
if(v==bfecha){
    final Calendar c =Calendar.getInstance();
    dia=c.get(Calendar.DAY_OF_MONTH);
    mes=c.get(Calendar.MONTH);
    añho=c.get(Calendar.YEAR);

    DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
efecha.setText(dayOfMonth+"/"+(month +1)+"/"+ year);
        }
    },dia,mes,añho);
    datePickerDialog.show();
}
if (v==bhora){
final Calendar c= Calendar.getInstance();
hora=c.get(Calendar.HOUR_OF_DAY);
minutos=c.get(Calendar.MINUTE);

    TimePickerDialog  timePickerDialog =new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            ehora.setText(hourOfDay+":"+minute);
        }
    },hora,minutos,false);
timePickerDialog.show();
}
    }
}