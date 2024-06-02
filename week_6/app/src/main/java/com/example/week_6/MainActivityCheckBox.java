package com.example.week_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivityCheckBox extends AppCompatActivity {
    TextView mTextView;

    Button mButton;

    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_check_box);

        mButton = findViewById(R.id.button5);
        mCheckBox = findViewById(R.id.checkBox);
        mTextView = findViewById(R.id.textView3);

        mCheckBox.setChecked(false);
        mButton.setEnabled(false);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    mButton.setEnabled(true);

                }
                else{
                    mButton.setEnabled(false);
                    mTextView.setText(R.string.str1);
                }

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("B1143028詹朝成接受且同意!");

            }
        });

    }
}