package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class day1 extends AppCompatActivity {
ImageView arrowday1;
    ImageView backarrowday2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);



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
               openday2();
            }
        });

    }
    public  void openday2(){
        Intent intent= new Intent(this, day2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_side_in,R.anim.left_slide__out);
    }
    public  void openBMI(){
        Intent intent= new Intent(this, BMI.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
}