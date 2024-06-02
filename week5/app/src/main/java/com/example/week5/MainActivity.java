package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mButtonAlertDialogBuilder, mButtonAlertDialog;
    TextView mTextViewR;
    String[] items = {"魏", "蜀", "吳"};
    boolean[] checked = {false, false, false};

    int pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonAlertDialogBuilder = findViewById(R.id.button5);
        mButtonAlertDialog = findViewById(R.id.button6);
        mTextViewR = findViewById(R.id.textView);

        mButtonAlertDialogBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("AlertDialog.Builder_Title")
//                        .setMessage("AlertDiagog.Builder_Example")
//                        .setItems(items, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                mTextViewR.setText("你選擇了:" + items[which]);
//                            }
//                        })
//                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                pre = which;
//                                mTextViewR.setText("你選擇了:" + items[which]);
//                               Toast.makeText(MainActivity.this,
//                                        "你選擇了:" + items[which],
//                                        Toast.LENGTH_LONG).show();
//                            }
//                        })
                        .setMultiChoiceItems(items, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                String str = "你選擇了:";
                                for(int i = 0; i < items.length; i++){
                                    if(checked[i] == true){
                                        str += items[i] + ' ';
                                    }
                                }
                                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                            }
                        })
                        .setIcon(R.drawable.ic_launcher_background)
                        .setCancelable(false)
                        .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                mTextViewR.setText("你啟動了AlertDialog.Builder且按下確認按鈕");

                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTextViewR.setText("你啟動了AlertDialog.Builder且按下取消按鈕");

                            }
                        }).setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mTextViewR.setText("你啟動了AlertDialog.Builder且按下忽略按鈕");

                            }
                        }).show();

            }
        });

        mButtonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextViewR.setText("");
                MyAlertDialog myAlertDialog = new MyAlertDialog(MainActivity.this);
                myAlertDialog.setTitle("AlertDialog_類別標題");
                myAlertDialog.setMessage("AlertDialog類別範例");
                myAlertDialog.setIcon(R.drawable.ic_launcher_background);
                myAlertDialog.setCancelable(false);
                myAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "正確", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTextViewR.setText("你啟動了AlertDialog類別且按下確認按鈕");
                    }
                });
                myAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTextViewR.setText("你啟動了AlertDialog類別且按下取消按鈕");
                    }
                });
                myAlertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTextViewR.setText("你啟動了AlertDialog類別且按下忽略按鈕");
                    }
                });
                myAlertDialog.show();

            }
        });

    }
}