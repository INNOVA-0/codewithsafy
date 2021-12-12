package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class thigh extends AppCompatActivity {
    ImageView backbutton;
    Button babs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thigh);

        backbutton=findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openworkoutplan();
            }
        });

        babs=findViewById(R.id.buttonabs);
        babs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthigh2();
            }
        });
    }


    public void openworkoutplan(){
        Intent intent= new Intent(this, workoutplan.class);
        startActivity(intent);
    }

    public void openthigh2(){
        Intent intent= new Intent(this, thigh2.class);
        startActivity(intent);
    }
}