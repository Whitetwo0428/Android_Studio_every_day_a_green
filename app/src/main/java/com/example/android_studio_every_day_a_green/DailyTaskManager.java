package com.example.android_studio_every_day_a_green;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyTaskManager {
    private SQLiteHelper dbHelper;
    private SimpleDateFormat dateFormat;

    public DailyTaskManager(Context context) {
        dbHelper = new SQLiteHelper(context);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void addTask(String task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_TASK, task);
        values.put(SQLiteHelper.COLUMN_DATE, dateFormat.format(new Date()));
        values.put(SQLiteHelper.COLUMN_STATUS, 0); // 未完成
        db.insert(SQLiteHelper.TABLE_DAILY_TASKS, null, values);
        db.close();
    }


    public List<String> getTasksForToday() {
        List<String> tasks = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(SQLiteHelper.TABLE_DAILY_TASKS,
                new String[]{SQLiteHelper.COLUMN_TASK},
                SQLiteHelper.COLUMN_DATE + "=?",
                new String[]{dateFormat.format(new Date())},
                null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                tasks.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_TASK)));
            }
            cursor.close();
        }
        db.close();
        return tasks;
    }

    public void markTaskAsCompleted(String task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_STATUS, 1); // 已完成
        db.update(SQLiteHelper.TABLE_DAILY_TASKS, values,
                SQLiteHelper.COLUMN_TASK + "=? AND " + SQLiteHelper.COLUMN_DATE + "=?",
                new String[]{task, dateFormat.format(new Date())});
        db.close();
    }
}

