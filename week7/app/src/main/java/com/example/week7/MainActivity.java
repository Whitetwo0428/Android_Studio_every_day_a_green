package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onaccelerometer(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityAccelerometer.class);
        startActivity(intent);
    }

    public void onAccelerometer2(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityAccelerometer2.class);
        startActivity(intent);
    }

    public void onLight(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityLight.class);
        startActivity(intent);
    }
}