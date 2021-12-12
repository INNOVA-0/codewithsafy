package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class slightly_weightlose3 extends AppCompatActivity {
    ImageView backarrowday2;
    ViewPager viewPager;
    private  Myadapter myadapter;
    ArrayList<Mymodel> mymodelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slightly_weightlose3);
        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openswl2();
            }
        });
        viewPager= findViewById(R.id.viewpager);
        loadCards();


    }
    private void loadCards() {
        mymodelArrayList = new ArrayList<>();
        mymodelArrayList.add(new Mymodel("Do not skip breakfast"));
        mymodelArrayList.add(new Mymodel("Do not skip meals, take three proper meals"));
        mymodelArrayList.add(new Mymodel("Chew more slowly"));
        mymodelArrayList.add(new Mymodel("Drink water, especially before meals"));
        mymodelArrayList.add(new Mymodel("Use smaller plates "));
        mymodelArrayList.add(new Mymodel("Eat spicy foods "));
        mymodelArrayList.add(new Mymodel("Eat more fiber"));
        mymodelArrayList.add(new Mymodel("Get good sleep"));
        mymodelArrayList.add(new Mymodel("Try intermittent fasting"));
        mymodelArrayList.add(new Mymodel("Exercise portion control or count calories "));
        mymodelArrayList.add(new Mymodel("Focus on your food while eating do not eat while watching television  "));
        mymodelArrayList.add(new Mymodel("Engage in regular physical activity and exercise"));



        myadapter= new Myadapter(this,mymodelArrayList);
        viewPager.setAdapter(myadapter);
        viewPager.setPadding(100,0,100,0);
    }
    public  void openswl2(){
        Intent intent= new Intent(this, slightly_weightlose2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
}