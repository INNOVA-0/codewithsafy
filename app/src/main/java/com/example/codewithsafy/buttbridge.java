package com.example.codewithsafy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class buttbridge extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttbridge);

        button=findViewById(R.id.checkskip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfor9();
            }
        });
    }

    public void restfor9(){
        Intent intent= new Intent(this, restfor9.class);
        startActivity(intent);
    }
    public  void youtuber(View view){
        Intent youtuberintent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fDP6O_aJpDg"));
        startActivity(youtuberintent);
    }
}