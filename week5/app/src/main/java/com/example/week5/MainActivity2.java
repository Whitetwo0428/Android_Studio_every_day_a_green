package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button mButtonAlertDialogView;
    TextView mTextViewRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mButtonAlertDialogView = findViewById(R.id.button3);
        mTextViewRe = findViewById(R.id.textView5);

        mButtonAlertDialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAlertDialog myAlertDialog = new MyAlertDialog(MainActivity2.this);
                myAlertDialog.setCancelable(false);
                myAlertDialog.setContentView(R.layout.dig_log_in);

                Button mLogin_OK = myAlertDialog.findViewById(R.id.button);
                Button mLogin_Cancel = myAlertDialog.findViewById(R.id.button2);

                mLogin_OK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText mEditTextUser = myAlertDialog.findViewById(R.id.editTextText);
                        EditText mEditTextPassWord = myAlertDialog.findViewById(R.id.editTextTextPassword);

                        mTextViewRe.setText("你輸入的帳號是:" + mEditTextUser.getText().toString() + "\n" +
                                "密碼是:" + mEditTextPassWord.getText().toString());
                        myAlertDialog.cancel();

                    }
                });

                mLogin_Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTextViewRe.setText("你啟動了AlertDialog自訂UI且按下取消按鈕");
                        myAlertDialog.cancel();

                    }
                });

                myAlertDialog.show();




            }
        });

    }
}