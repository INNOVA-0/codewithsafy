package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class buttcongratulations extends AppCompatActivity {
    Button done;
    Button doit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttcongratulations);
        done=findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workoutplan();
            }
        });

        doit=findViewById(R.id.doit);
        doit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butt2();
            }
        });
    }
    public void workoutplan(){
        Intent intent= new Intent(this, workoutplan.class);
        startActivity(intent);

    }
    public void butt2(){
        Intent intent= new Intent(this, butt2.class);
        startActivity(intent);


    }
}