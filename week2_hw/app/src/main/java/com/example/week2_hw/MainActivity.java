package com.example.week2_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mEditNum1, mEditNum2;
    Button mButton1, mButton2, mButton3, mButton4;
    TextView mTextView1, mTextViewResult;

    int num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditNum1 = findViewById(R.id.editTextText);
        mEditNum2 = findViewById(R.id.editTextText2);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);
        mTextView1 = findViewById(R.id.textView);
        mTextViewResult = findViewById(R.id.textView3);



        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mTextView1.setText("+");
                num1 = Integer.parseInt(mEditNum1.getText().toString());
                num2 = Integer.parseInt(mEditNum2.getText().toString());
                String strRet = Integer.toString(num1 + num2);
                mTextViewResult.setText(strRet);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mTextView1.setText("-");
                num1 = Integer.parseInt(mEditNum1.getText().toString());
                num2 = Integer.parseInt(mEditNum2.getText().toString());
                String strRet = Integer.toString(num1 - num2);
                mTextViewResult.setText(strRet);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mTextView1.setText("*");
                num1 = Integer.parseInt(mEditNum1.getText().toString());
                num2 = Integer.parseInt(mEditNum2.getText().toString());
                String strRet = Integer.toString(num1 * num2);
                mTextViewResult.setText(strRet);
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mTextView1.setText("/");
                num1 = Integer.parseInt(mEditNum1.getText().toString());
                num2 = Integer.parseInt(mEditNum2.getText().toString());
                String strRet = Integer.toString(num1 / num2);
                mTextViewResult.setText(strRet);
            }
        });

    }

}