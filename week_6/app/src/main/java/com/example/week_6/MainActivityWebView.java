package com.example.week_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivityWebView extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view);

        webView = findViewById(R.id.WebView);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.google.com/");

    }
}