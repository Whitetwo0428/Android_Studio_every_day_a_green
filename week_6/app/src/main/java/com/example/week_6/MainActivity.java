package com.example.week_6;

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

    public void onCheckBox(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityCheckBox.class);
        startActivity(intent);
    }

    public void onSpinner(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivitySpinner.class);
        startActivity(intent);
    }

    public void onWebView(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityWebView.class);
        startActivity(intent);
    }

    public void onIntent(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivityIntent.class);
        startActivity(intent);
    }
}