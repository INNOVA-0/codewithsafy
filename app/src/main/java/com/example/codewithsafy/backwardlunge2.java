package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class backwardlunge2 extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backwardlunge2);
        button=findViewById(R.id.checkskip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfor9();
            }
        });
    }

    public void restfor9(){
        Intent intent= new Intent(this, thighrestfor14.class);
        startActivity(intent);
    }
}