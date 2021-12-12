package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Activity1 extends AppCompatActivity {

        Timer timer;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_1);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                               @Override
                               public void run() {
                                   Intent intent = new Intent(Activity1.this, MainActivity.class);
                                   startActivity(intent);
                                   finish();
                               }
                           },1300
            );
    }
}