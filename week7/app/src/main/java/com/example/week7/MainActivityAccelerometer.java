package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityAccelerometer extends AppCompatActivity {
    TextView mTextViewR;

    SensorManager sensorManager;

    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_accelerometer);

        mTextViewR = findViewById(R.id.textView3);

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
            for(int i = 0; i < values.length; i++){
                str1 += "-values[" + i + "] = " + values[i] + "\n";
            }
            mTextViewR.setText(str1);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(listener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }
}