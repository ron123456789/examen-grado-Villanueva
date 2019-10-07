package com.example.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

public class MainPelotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pelotas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout3);
        SlidingDrawerToggle toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button as = (Button) findViewById(R.id.button1);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainPelotas.this, MainPelotas.class);
                startActivity(d);
            }
        });

        Button asi = (Button) findViewById(R.id.button2);
        asi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainPelotas.this, MainActivityRegistrarUsuario.class);
                startActivity(d);
            }
        });
    }

    @Override
    public void onBackPressed() {
        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout3);
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }

    }
}