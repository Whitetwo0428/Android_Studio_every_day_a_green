package com.example.week8_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;

    MediaController mediaController;

    String vidAddress = "https://dl.dropbox.com/scl/fi/9obxmoc6f4oto3y8gua9m/INA_beam.mp4?rlkey=5o9kusqqnh4rhx10euy62epms&dl=0";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mVideoView = findViewById(R.id.videoView);
        mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);

        //影片在專案中
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ina_beam));
        mVideoView.requestFocus();
        mVideoView.start();

//        Uri vidUri = Uri.parse(vidAddress);
//        mVideoView.setVideoURI(vidUri);
//        mVideoView.start();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(MainActivity.this, "LANDSCAPE", Toast.LENGTH_LONG).show();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(MainActivity.this, "PORTRAIT", Toast.LENGTH_LONG).show();
        }
    }
}