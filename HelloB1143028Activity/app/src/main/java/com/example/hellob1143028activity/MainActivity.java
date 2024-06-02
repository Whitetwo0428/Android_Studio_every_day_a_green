package com.example.hellob1143028activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextName;

    Button mButtonConfirm;

    TextView mTextViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextName = findViewById(R.id.editTextText);
        mButtonConfirm = findViewById(R.id.button);
        mTextViewResult = findViewById(R.id.textView3);



    }

    public void OnConfirm(View view) {
        String mName = mEditTextName.getText().toString();
        mTextViewResult.setText("我是" + mName);
    }
}
