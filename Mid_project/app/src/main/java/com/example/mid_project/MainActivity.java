package com.example.mid_project;

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

    public void onAddtodo(View view) {
        Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
        startActivity(intent);
    }

    public void onTask(View view) {
        Intent intent = new Intent(MainActivity.this, TaskActivity.class);
        startActivity(intent);
    }
}