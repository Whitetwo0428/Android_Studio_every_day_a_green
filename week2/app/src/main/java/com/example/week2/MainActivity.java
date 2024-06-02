package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText mEditTextSex, mEditTextAge;

    Button mButtonConfirm;

    TextView mTextViewResult; //虛擬物件

    String mSex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextSex = findViewById(R.id.editTextText);
        mEditTextAge = findViewById(R.id.editTextNumber);
        mButtonConfirm = findViewById(R.id.button);
        mTextViewResult = findViewById(R.id.textView4);

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //mTextViewResult.setText("結果:" + mEditTextSex.getText().toString() + mEditTextAge.getText().toString() + "歲");
                mSex = mEditTextSex.getText().toString();
                int mAge = Integer.parseInt(mEditTextAge.getText().toString());
                String strSug = "";

                if(mSex.equals("M")){
                    if(mAge < 28){
                        strSug += "不急";
                    }
                    else if(mAge > 33){
                        strSug += "趕快結婚";
                    }
                    else{
                        strSug += "開始找對象";
                    }
                }
                else if(mSex.equals("F")){
                    if(mAge < 25){
                        strSug += "不急";
                    }
                    else if(mAge > 30){
                        strSug += "趕快結婚";
                    }
                    else{
                        strSug += "開始找對象";
                    }
                }
                mTextViewResult.setText("結果:" + strSug);


            }
        });
    }
}