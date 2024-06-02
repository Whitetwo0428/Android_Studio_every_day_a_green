package com.example.wee9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;

    Button mButtonSave, mButtonRead, mButtonExit;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editTextText3);
        mButtonRead = findViewById(R.id.button);
        mButtonSave = findViewById(R.id.button2);
        mButtonExit = findViewById(R.id.button3);



    }

    public void onButtonSave(View view) {
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        sharedPreferences.edit().putString("Name", mEditText.getText().toString()).commit();

    }

    public void onButtonRead(View view) {
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        mEditText.setText(sharedPreferences.getString("Name", ""));
    }

    public void onButtonExit(View view) {

        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        sharedPreferences.edit().putString("Name", mEditText.getText().toString()).commit();
    }

}

