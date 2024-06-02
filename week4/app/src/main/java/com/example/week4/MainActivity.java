package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextName;

    Button mButtonConfirm;

    TextView mTextViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("ZCC", "OnCreate()");
        Toast.makeText(MainActivity.this, "OnCreate()", Toast.LENGTH_LONG).show();

        mEditTextName = findViewById(R.id.editTextText);
        mButtonConfirm = findViewById(R.id.button);
        mTextViewResult = findViewById(R.id.textView3);



    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ZCC", "onStart()");
        Toast.makeText(MainActivity.this, "onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ZCC", "onStop()");
        Toast.makeText(MainActivity.this, "onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ZCC", "onDestroy()");
        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ZCC", "onPause()");
        Toast.makeText(MainActivity.this, "onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ZCC", "onResume()");
        Toast.makeText(MainActivity.this, "onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ZCC", "onRestart()");
        Toast.makeText(MainActivity.this, "onRestart()", Toast.LENGTH_LONG).show();
    }

    public void OnConfirm(View view) {

        //String mName = mEditTextName.getText().toString();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("S", mEditTextName.getText().toString());
        startActivity(intent);

        mTextViewResult.setText("我是" + mEditTextName.getText().toString());




    }
}