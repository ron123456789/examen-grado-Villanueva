package com.example.myapplicationparqueo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button as=(Button)findViewById(R.id.button1);

        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a =new Intent(MainActivity.this,MainVentana2.class);
                startActivity(a);
            }
        });
    }
}
