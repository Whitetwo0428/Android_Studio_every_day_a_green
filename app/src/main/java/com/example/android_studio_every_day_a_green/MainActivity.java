package com.example.android_studio_every_day_a_green;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DailyTaskManager dailyTaskManager;
    EcoActivityManager ecoActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyTaskManager = new DailyTaskManager(this);
        ecoActivityManager = new EcoActivityManager(this);
    }

    public void onAddDailyTask(View view) {
        dailyTaskManager.addTask("New Daily Task");
    }

    public void onAddEcoActivity(View view) {
        ecoActivityManager.addEcoActivity("Participate in Beach Cleanup");
    }

    public void onViewTasks(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }
}
