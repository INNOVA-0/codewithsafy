package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class dailychallenge extends AppCompatActivity {

Button complete;
Button abort;
ImageView backbutton;
ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailychallenge);

        Calendar cal = Calendar.getInstance();



        imageView = (ImageView)findViewById(R.id.challenges);

        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {

            imageView.setImageResource(R.drawable.day7);

        }else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            imageView.setImageResource(R.drawable.day1);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY ){
            imageView.setImageResource(R.drawable.day2);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            imageView.setImageResource(R.drawable.day3);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
            imageView.setImageResource(R.drawable.day4);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
            imageView.setImageResource(R.drawable.day5);
        }
        else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            imageView.setImageResource(R.drawable.day6);
        }
        abort=findViewById(R.id.abort);
        complete=findViewById(R.id.compl);
        backbutton=findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                main();
            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                complete.setVisibility(View.GONE);
                abort.setVisibility(View.GONE);
                imageView.setImageResource(R.drawable.ubm);

                }

        });
        abort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abort();
            }
        });

    }



    private void comlete(){
        Intent intent= new Intent(this, completed.class);
        startActivity(intent);


    }
    private void abort(){
        Intent intent= new Intent(this, abort.class);
        startActivity(intent);

    }
    private void main(){
        Intent intent= new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);

    }

}