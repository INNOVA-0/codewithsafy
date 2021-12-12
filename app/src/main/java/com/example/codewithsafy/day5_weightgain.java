package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class day5_weightgain extends AppCompatActivity {
    ImageView backarrowday2;
    ImageView forwardarrowday1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day5_weightgain);
        forwardarrowday1=findViewById(R.id.forwardarrowday1);
        forwardarrowday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday6weightgain();
            }
        });
        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openday4weightgain();
            }
        });
    }
    public  void openday4weightgain(){
        Intent intent= new Intent(this, day4_weightgain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    public  void openday6weightgain(){
        Intent intent= new Intent(this, day6_weightgain.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_side_in,R.anim.left_slide__out);

    }
}