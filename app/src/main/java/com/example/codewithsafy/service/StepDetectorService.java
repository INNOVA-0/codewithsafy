package com.example.codewithsafy.service;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.codewithsafy.callback.stepsCallback;
import com.example.codewithsafy.helper.GeneralHelper;
import com.example.codewithsafy.helper.PrefsHelper;

public class StepDetectorService  extends Service implements SensorEventListener {

    public static stepsCallback callback;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);


        if (countSensor != null ) {
            Toast.makeText(this, "Step Detecting Start", Toast.LENGTH_SHORT).show();
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_NORMAL);


            GeneralHelper.updateNotification(this, this, PrefsHelper.getInt("FSteps"));
            callback.subscribeSteps(PrefsHelper.getInt("FSteps"));

        } else {
            Toast.makeText(this, "Sensor Not Detected", Toast.LENGTH_SHORT).show();
        }

        return START_STICKY;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onSensorChanged(SensorEvent p0) {
        if (!PrefsHelper.getString("TodayDate").equals(GeneralHelper.getToadyDate())) {
            PrefsHelper.putInt("Steps", (int) p0.values[0]);
            PrefsHelper.putString("TodayDate", GeneralHelper.getToadyDate());
        } else {
            int storeSteps = PrefsHelper.getInt("Steps");
            int sensorSteps = (int) p0.values[0];
            int finalSteps = sensorSteps - storeSteps;
            if (finalSteps > 0) {
                PrefsHelper.putInt("FSteps", finalSteps);
                GeneralHelper.updateNotification(this, this, finalSteps);
                callback.subscribeSteps(finalSteps);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("SERVICE", sensor.toString());
    }

    public static void register(Activity activity) {

        callback = (stepsCallback) activity;
    }
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Step detecting stop", Toast.LENGTH_LONG).show();


    }
    public void onstop(){

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Toast.makeText(this, "Step Detecting Stop", Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this, countSensor);

    }

}