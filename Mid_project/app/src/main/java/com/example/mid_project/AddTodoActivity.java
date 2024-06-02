package com.example.mid_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddTodoActivity extends AppCompatActivity {
    Button selectTimeButton;
    EditText mEditTextContent;
    String selectedDate, selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        selectTimeButton = findViewById(R.id.buttonSelectTime);
        mEditTextContent = findViewById(R.id.editTextContent);

        selectTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 獲取當前時間
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                // 創建TimePickerDialog對象
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        AddTodoActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                // 在這裡處理用戶選擇的時間
                                selectedTime = hourOfDay + ":" + minute;
                                // 將選擇的時間設置到你的EditText或其他地方
                                // 創建一個AlertDialog來顯示選擇的時間
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddTodoActivity.this);
                                builder.setTitle("選擇的時間");
                                builder.setMessage(mEditTextContent.getText().toString() + '\n' + selectedTime);
                                builder.setPositiveButton("確定", null); // 確定按鈕，這裡可以添加點擊事件
                                builder.show();
                            }
                        },
                        hour, // 初始小時
                        minute, // 初始分鐘
                        false // 是否使用24小時制
                );

                // 顯示TimePickerDialog
                timePickerDialog.show();
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddTodoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // 在這裡處理用戶選擇的日期
                                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;

                            }
                        },
                        year, // 初始年份
                        month, // 初始月份
                        dayOfMonth // 初始日期
                );
                // 創建一個AlertDialog來顯示選擇的時間
                AlertDialog.Builder builder = new AlertDialog.Builder(AddTodoActivity.this);
                builder.setTitle("選擇的時間");
                builder.setMessage(mEditTextContent.getText().toString() + '\n' + selectedTime + '\n' + selectedDate);
                builder.setPositiveButton("確定", null); // 確定按鈕，這裡可以添加點擊事件
                builder.show();

                // 顯示日期選擇對話框
                datePickerDialog.show();
            }
        });

    }
}