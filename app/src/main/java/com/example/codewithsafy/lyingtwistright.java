package com.example.codewithsafy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class lyingtwistright extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyingtwistright);
        textView = findViewById(R.id.textabs);
        long duration = TimeUnit.SECONDS.toMillis(30);
        new CountDownTimer(duration , 1000) {

            @Override
            public void onTick(long l) {

                String sDuration = String.format(Locale.ENGLISH, "%02d''",  TimeUnit.MILLISECONDS.toSeconds(l) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))

                );
                textView.setText(sDuration);



            }

            @Override
            public void onFinish() {
                textView.setVisibility(View.GONE);
                congrats();
            }
        }.start();


    }

    public void  congrats(){
        Intent intent= new Intent(this, congratulations.class);
        startActivity(intent);

    }
    public  void youtuber(View view){
        Intent youtuberintent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9NuI7mUyGW8"));
        startActivity(youtuberintent);
    }
}