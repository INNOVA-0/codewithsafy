package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class fullbodyChallenge extends AppCompatActivity {
ImageView backbuttonnew;
CardView week1;
    CardView week2;
    CardView week3;
    CardView week4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullbody_challenge);
        backbuttonnew=findViewById(R.id.back);
        week3=findViewById(R.id.week3);
        week2=findViewById(R.id.week2);
        week1=findViewById(R.id.week1);
        week4=findViewById(R.id.week4);
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweek4();
            }
        });
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweek3();
            }
        });
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweek2();
            }
        });
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweek1();
            }
        });
        backbuttonnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkoutplan();
            }
        });
    }

    private void openWorkoutplan(){

        Intent intent= new Intent(this, workoutplan.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    private void openweek1(){

        Intent intent= new Intent(this, week1.class);
        startActivity(intent);
    }
    private void openweek2(){

        Intent intent= new Intent(this, week2.class);
        startActivity(intent);
    }
    private void openweek3(){

        Intent intent= new Intent(this, week3.class);
        startActivity(intent);
    }
    private void openweek4(){

        Intent intent= new Intent(this, week4.class);
        startActivity(intent);
    }
}