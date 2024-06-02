package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityLight extends AppCompatActivity {
    TextView mTextViewR;

    SensorManager sensorManager;

    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_light);

        mTextViewR = findViewById(R.id.textView7);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    }

    SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            sensor = event.sensor;
            String str1 = "";
            str1 += "sensor name:" + sensor.getName() + "\n";
            str1 += "sensor type:" + sensor.getType() + "\n";
            str1 += "sensor power:" + sensor.getPower() + "\n";
            str1 += "values: \n";
            float values[] = event.values;
            str1 += values[0] + "\n";

            if(values[0] >= 10000)
                str1 += "可以做任何事情(除了壞事) \n";
            else if(values[0] >= 7000)
                str1 += "適合手術房 \n";
            else if(values[0] >= 500)
                str1 += "適合閱讀 \n";
            else if(values[0] >= 100)
                str1 += "適合一般起居生活 \n";
            else if(values[0] >= 30)
                str1 += "適合看電視 \n";
            else if(values[0] >= 5)
                str1 += "適合夜間散步 \n";
            else
                str1 += "適合睡覺囉 \n";
            mTextViewR.setText(str1);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(listener,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_UI);
    }
}