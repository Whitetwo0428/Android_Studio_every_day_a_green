package com.example.android_studio_every_day_a_green;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TaskActivity extends AppCompatActivity {
    DailyTaskManager dailyTaskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        dailyTaskManager = new DailyTaskManager(this);

        ListView listView = findViewById(R.id.taskListView);
        List<String> tasks = dailyTaskManager.getTasksForToday();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
    }
}
