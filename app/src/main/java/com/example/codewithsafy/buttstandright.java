package com.example.codewithsafy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class buttstandright extends AppCompatActivity {
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttstandright);
        button=findViewById(R.id.checkskip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restfor8();
            }
        });
    }

    public void restfor8(){
        Intent intent= new Intent(this, buttrestfor5.class);
        startActivity(intent);
    }
    public  void youtuber(View view){
        Intent youtuberintent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Wp4BlxcFTkE"));
        startActivity(youtuberintent);
    }
}