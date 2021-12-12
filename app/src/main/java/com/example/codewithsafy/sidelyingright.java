package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class sidelyingright extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidelyingright);
        button=findViewById(R.id.checkskip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfor9();
            }
        });
    }

    public void restfor9(){
        Intent intent= new Intent(this, thighrestfor9.class);
        startActivity(intent);
    }
}