package com.example.week15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextView2 = findViewById(R.id.textView2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchx = event.getX();
        float touchy = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mTextView2.setText("狀態按下\nX座標:" + touchx + "Y座標:" + touchy);
                break;

            case MotionEvent.ACTION_MOVE:
                mTextView2.setText("狀態移動\nX座標:" + touchx + "Y座標:" + touchy);
                break;

            case MotionEvent.ACTION_UP:
                mTextView2.setText("狀態放開\nX座標:" + touchx + "Y座標:" + touchy);
                break;

            default:
                break;
        }

        return super.onTouchEvent(event);
    }
}