package com.example.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

public class MainUniformes extends AppCompatActivity {

    private GridLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_uniformes);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layoutU);
        SlidingDrawerToggle toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Button as=(Button)findViewById(R.id.button1);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainUniformes.this,MainActivity.class);
                startActivity(d);
            }
        });

        Button asi=(Button)findViewById(R.id.button2);
        asi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainUniformes.this,MainActivityReservas.class);
                startActivity(d);
            }
        });
        Button asi2=(Button)findViewById(R.id.button3);
        asi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainUniformes.this,MainUniformes.class);
                startActivity(d);
            }
        });
        Button asi4=(Button)findViewById(R.id.button);
        asi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d=new Intent(MainUniformes.this,MainPelotas.class);
                startActivity(d);
            }
        });
    }

    @Override
    public void onBackPressed() {
        SlidingDrawerLayout drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layoutU);
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }

    }
}