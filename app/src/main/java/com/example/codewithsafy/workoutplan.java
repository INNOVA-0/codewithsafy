package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class workoutplan extends AppCompatActivity {
    ImageView backbutton;
    ImageView fullbody;
    ImageView abs;
    ImageView thigh;
    ImageView butt;
    ImageView arms;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutplan);
arms=findViewById(R.id.arms);
arms.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        arms2();
    }
});
        backbutton=findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        fullbody=findViewById(R.id.fulbody24);
fullbody.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        openfullbodyChallenge();
    }
});
        abs=findViewById(R.id.abs);
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openabs();
            }
        });
        thigh=findViewById(R.id.thigh);
        thigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
openthigh();
            }
        });
        butt=findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbutt();
            }
        });
}
private void openfullbodyChallenge(){
    Intent intent= new Intent(this, fullbodyChallenge.class);
    startActivity(intent);
}
    public void openActivity2(){
        Intent intent= new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    public void openabs(){
        Intent intent= new Intent(this, abs.class);
        startActivity(intent);
    }


    public void openthigh(){
        Intent intent= new Intent(this, thigh.class);
        startActivity(intent);
    }
    public void openbutt(){
        Intent intent= new Intent(this, butt.class);
        startActivity(intent);
    }
    public void arms2(){
        Intent intent= new Intent(this, arms2.class);
        startActivity(intent);
    }
}
