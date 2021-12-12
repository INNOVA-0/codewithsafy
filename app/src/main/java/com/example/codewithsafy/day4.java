package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class day4 extends AppCompatActivity {
    ImageView backarrowday2;
    ImageView forwardarrowday1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4);
        forwardarrowday1=findViewById(R.id.forwardarrowday1);
        forwardarrowday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday5();
            }
        });

        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday3();
            }
        });
    }
    public  void openday3(){
        Intent intent= new Intent(this, day3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    public  void openday5(){
        Intent intent= new Intent(this, day5.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_side_in,R.anim.left_slide__out);
    }
}