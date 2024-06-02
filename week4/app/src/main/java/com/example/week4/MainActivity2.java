package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mTextView2;
    Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextView2 = findViewById(R.id.textView2);
        mButton2 = findViewById(R.id.button2);

        Intent intent2 = getIntent();
        mTextView2.setText("我是" + intent2.getStringExtra("S"));


    }

    public void Back(View view) {
        finish();


    }
}