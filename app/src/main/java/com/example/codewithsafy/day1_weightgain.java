package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class day1_weightgain extends AppCompatActivity {
    ImageView arrowday1;
    ImageView backarrowday2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_weightgain);
        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBMI();
            }
        });

        arrowday1=findViewById(R.id.forwardarrowday1);
        arrowday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday2weightgain();
            }
        });

    }
    public  void openday2weightgain(){
        Intent intent= new Intent(this, day2_weightgain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_side_in,R.anim.left_slide__out);
    }
    public  void openBMI(){
        Intent intent= new Intent(this, BMI.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    }