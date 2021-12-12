package com.example.codewithsafy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
   TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
textView=findViewById(R.id.nameofuser);
        sharedPreferences= getSharedPreferences("SHARED PREFRENCES",MODE_PRIVATE);
        String name1=sharedPreferences.getString("name1","");

textView.setText(name1);
    }
}