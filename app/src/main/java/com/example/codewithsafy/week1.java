package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class week1 extends AppCompatActivity {
    ImageView backbuttonnew;
    CardView day1;
    CardView day2;
    CardView day3;
    CardView day4;
    CardView day5;
    CardView day6;
    CardView day7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week1);

        backbuttonnew = findViewById(R.id.back);
        day1=findViewById(R.id.day1);
        day2=findViewById(R.id.day2);
        day3=findViewById(R.id.day3);
        day4=findViewById(R.id.day4);
        day5=findViewById(R.id.day5);
        day6=findViewById(R.id.day6);
        day7=findViewById(R.id.day7);
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openthigh();
            }
        });
        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openarms2();
            }
        });
        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbutt();
            }
        });
        day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openabs();
            }
        });
        day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openarms2();
            }
        });
        day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openabs();
            }
        });
        day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
openrestdat();
            }
        });
        backbuttonnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfullbody();
            }
        });
    }
        private void openfullbody(){

            Intent intent= new Intent(this, fullbodyChallenge.class);
            startActivity(intent);
            overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
        }
    private void openarms2(){

        Intent intent= new Intent(this, arms2.class);
        startActivity(intent);

    }
    private void openabs(){

        Intent intent= new Intent(this, abs.class);
        startActivity(intent);

    }
    private void openthigh(){

        Intent intent= new Intent(this, thigh.class);
        startActivity(intent);
    }
    private void openbutt(){

        Intent intent= new Intent(this, butt.class);
        startActivity(intent);
    }
    private void openrestdat(){

        Intent intent= new Intent(this, restdat.class);
        startActivity(intent);
    }


}
