package com.example.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout);
        SlidingDrawerToggle toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button as=(Button)findViewById(R.id.button1);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivity.this,MainActivity.class);
                startActivity(d);
            }
        });

        Button asi=(Button)findViewById(R.id.button2);
        asi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivity.this,MainActivityReservas.class);
                startActivity(d);
            }
        });
        Button asi2=(Button)findViewById(R.id.button3);
        asi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivity.this,MainUniformes.class);
                startActivity(d);
            }
        });
        Button asi4=(Button)findViewById(R.id.button);
        asi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainActivity.this,MainPelotas.class);
                startActivity(d);
            }
        });
    }

    @Override
    public void onBackPressed() {
        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }

    }
}