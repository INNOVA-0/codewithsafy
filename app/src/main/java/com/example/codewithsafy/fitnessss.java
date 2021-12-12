package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class fitnessss extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitnessss);

        b=findViewById(R.id.jkjhjkhjkhk);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfor9();
            }
        });


    }
    public void restfor9(){
        Intent intent= new Intent(this, BMI.class);
        startActivity(intent);
    }

}