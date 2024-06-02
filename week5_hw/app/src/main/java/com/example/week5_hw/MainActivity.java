package com.example.week5_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTextViewResult;

    Button mButtonOrder;

    String[] menu = new String[]{"大麥克", "麥香雞", "牛排", "烏龍麵"};

    boolean[] menubool = new boolean[]{false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.textView2);
        mButtonOrder = findViewById(R.id.button);


    }

    public void Order(View view) {
        new AlertDialog.Builder(MainActivity.this)
                .setMultiChoiceItems(menu, menubool, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        menubool[which] = isChecked;
                    }
                })
                .setPositiveButton("確認點餐", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strOrder = "";
                        for(int i = 0; i < menu.length; i++){
                            if(menubool[i] == true){
                                strOrder += menu[i] + " ";
                            }
                        }
                        Toast.makeText(MainActivity.this, "你所點的餐點有: " + strOrder, Toast.LENGTH_LONG).show();
                        //Log.v("menu", "你所點的餐點有: " + strOrder);
                        mTextViewResult.setText("你所點的餐點有: " + strOrder);
                    }
                }).show();


    }
}