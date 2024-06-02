package com.example.week4_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView mTextViewResult;
    Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextViewResult = findViewById(R.id.textView5);
        mButtonBack = findViewById(R.id.button2);

        Intent intent2 = getIntent();
        mTextViewResult.setText(intent2.getStringExtra("S"));

    }

    public void Back(View view) {
        finish();
    }
}