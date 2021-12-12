package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class day3 extends AppCompatActivity {
    ImageView backarrowday2;
    ImageView forwardarrowday1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);
        forwardarrowday1=findViewById(R.id.forwardarrowday1);
        forwardarrowday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
openday4();
            }
        });
        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday2();
            }
        });
    }
    public  void openday2(){
        Intent intent= new Intent(this, day2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    public  void openday4(){
        Intent intent= new Intent(this, day4.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_side_in,R.anim.left_slide__out);
    }
}