package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class thighrestfor8 extends AppCompatActivity {
    private TextView textView;
    private boolean isPaused = false;
    Button homebutton;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thighrestfor8);
        textView = findViewById(R.id.textabs);
        button=findViewById(R.id.skip);
        homebutton=findViewById(R.id.backtohome);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPaused = true;
                workoutplan();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPaused = true;
                mountainclimber();

            }
        });
        long duration = TimeUnit.SECONDS.toMillis(18);
        new CountDownTimer(duration , 1000) {

            @Override
            public void onTick(long l) {
                if(isPaused == true)
                {

                    cancel();
                }
                String sDuration = String.format(Locale.ENGLISH, "%02d",  TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))

                );
                textView.setText(sDuration);



            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                mountainclimber();

            }
        }.start();
    }
    public void  mountainclimber(){
        Intent intent= new Intent(this, sidelyingright.class);
        startActivity(intent);
    }
    public void workoutplan(){
        Intent intent= new Intent(this, workoutplan.class);
        startActivity(intent);
    }
}