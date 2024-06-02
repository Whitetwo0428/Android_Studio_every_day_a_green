package com.example.week15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    Button mButton;

    TextView mTextView3;

    public static final int RQS_VOICE_RECOGNITION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mButton = findViewById(R.id.button3);
        mTextView3 = findViewById(R.id.textView3);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speech");
                startActivityForResult(intent, RQS_VOICE_RECOGNITION);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RQS_VOICE_RECOGNITION){
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String firstMatch = result.get(0);
            mTextView3.setText(firstMatch);

            if(firstMatch.indexOf("肚子餓") != -1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.foodpanda.com.tw/?utm_source=google&utm_medium=cpc&utm_campaign=17205082201&sem_tracker=17205082201&gad_source=1&gclid=Cj0KCQjwu8uyBhC6ARIsAKwBGpRJsGd1Swuh0Ezl65jtRwY0MxFow40McfU0UwXTYrLpfGDyVAFetQAaAg4aEALw_wcB"));
                startActivity(intent);
            }
            else if(firstMatch.indexOf("想聽歌") != -1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/://www.foodpanda.com.tw/?utm_source=google&utm_medium=cpc&utm_campaign=17205082201&sem_tracker=17205082201&gad_source=1&gclid=Cj0KCQjwu8uyBhC6ARIsAKwBGpRJsGd1Swuh0Ezl65jtRwY0MxFow40McfU0UwXTYrLpfGDyVAFetQAaAg4aEALw_wcB"));
                startActivity(intent);
            }
        }
    }
}