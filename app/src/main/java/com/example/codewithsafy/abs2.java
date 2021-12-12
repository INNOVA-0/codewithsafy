package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class abs2 extends AppCompatActivity {

    private TextView textView;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs2);

        textView = findViewById(R.id.textabs);
        long duration = TimeUnit.SECONDS.toMillis(15);
        new CountDownTimer(duration , 1000) {

            @Override
            public void onTick(long l) {

                String sDuration = String.format(Locale.ENGLISH, "%02d",  TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))

                );
                textView.setText(sDuration);



            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                openjumpingjack1();
            }
        }.start();

    }
    public void openjumpingjack1(){
        Intent intent= new Intent(this, jumping_jack1.class);
        startActivity(intent);
    }
}