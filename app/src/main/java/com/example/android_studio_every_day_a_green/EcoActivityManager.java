package com.example.android_studio_every_day_a_green;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EcoActivityManager {
    private SQLiteHelper dbHelper;
    private SimpleDateFormat dateFormat;

    public EcoActivityManager(Context context) {
        dbHelper = new SQLiteHelper(context);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void addEcoActivity(String activity) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_TASK, activity);
        values.put(SQLiteHelper.COLUMN_DATE, dateFormat.format(new Date()));
        values.put(SQLiteHelper.COLUMN_STATUS, 0); // 未完成
        db.insert(SQLiteHelper.TABLE_DAILY_TASKS, null, values);
        db.close();
    }

    public List<String> getCompletedEcoActivities() {
        List<String> activities = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(SQLiteHelper.TABLE_DAILY_TASKS,
                new String[]{SQLiteHelper.COLUMN_TASK},
                SQLiteHelper.COLUMN_STATUS + "=?",
                new String[]{"1"},
                null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                activities.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_TASK)));
            }
            cursor.close();
        }
        db.close();
        return activities;
    }
}

