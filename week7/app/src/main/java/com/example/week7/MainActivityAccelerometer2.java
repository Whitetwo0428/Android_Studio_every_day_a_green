package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityAccelerometer2 extends AppCompatActivity implements SensorEventListener {

    TextView mTextViewR;

    SensorManager sensorManager;

    Sensor sensor;

    float gravity[] = new float[3];

    float linear_acceleration[] = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_accelerometer2);

        mTextViewR = findViewById(R.id.textView5);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensor = event.sensor;
        String str1 = "";
        str1 += "sensor name:" + sensor.getName() + "\n";
        str1 += "sensor type:" + sensor.getType() + "\n";
        str1 += "sensor power:" + sensor.getPower() + "\n";
//        str1 += "values: \n";
//        float values[] = event.values;
//        for(int i = 0; i < values.length; i++){
//            str1 += "-values[" + i + "] = " + values[i] + "\n";
//        }

        // alpha is calculated as t / (t + dT)
        // with t, the low-pass filter's time-constant
        // and dT, the event delivery rate

        final float alpha = 0.8F;

        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];
        str1 += "-values[0] = " + linear_acceleration[0] + "\n";
        str1 += "-values[1] = " + linear_acceleration[1] + "\n";
        str1 += "-values[2] = " + linear_acceleration[2] + "\n";

        mTextViewR.setText(str1);



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}