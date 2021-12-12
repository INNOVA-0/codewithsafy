package com.example.codewithsafy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class slight_weight_gain3 extends AppCompatActivity {
    ViewPager viewPager;
    ImageView backarrowday2;
    private  Myadapter myadapter;
    ArrayList<Mymodel>  mymodelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slight_weight_gain3);


        backarrowday2=findViewById(R.id.backarrowday2);
        backarrowday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openswg2();
            }
        });

        viewPager= findViewById(R.id.viewpager);
        loadCards();




    }

    private void loadCards() {
        mymodelArrayList = new ArrayList<>();
        mymodelArrayList.add(new Mymodel("Eat three to five meals a day"));
        mymodelArrayList.add(new Mymodel("Consume up to 1,000 calories more per day"));
        mymodelArrayList.add(new Mymodel("Eat foods that are high in sugar "));
        mymodelArrayList.add(new Mymodel("Snacking between meals can also help to increase the number of calories in the diet"));
       mymodelArrayList.add(new Mymodel("Weight training at least three times a week "));
       mymodelArrayList.add(new Mymodel("Eat enough protein for muscle growth. Consume  0.8–2.0 grams of protein per kilogram of body weight "));
        mymodelArrayList.add(new Mymodel("Eat meals with fibrous carbohydrates and healthful fats"));
        mymodelArrayList.add(new Mymodel("Drink high-calorie smoothies or shakes"));
        mymodelArrayList.add(new Mymodel("Do not drink water before meals. This can fill your stomach and make it harder to get in enough calories"));
        mymodelArrayList.add(new Mymodel("Use bigger plates to eat. Eating in smaller plates cause people to eat less."));
        mymodelArrayList.add(new Mymodel("Get quality sleep. Sleeping properly is very important for muscle growth"));
        mymodelArrayList.add(new Mymodel("Eat your protein first and vegetables last. If you have a mix of foods on your plate, eat the calorie-dense and protein-rich foods first. Eat the vegetables last."));
        mymodelArrayList.add(new Mymodel("Do not smoke, Smoking often leads to weight loss."));
        mymodelArrayList.add(new Mymodel("Eat Avocados, Just one large avocado provides around 322 calories, 29 grams of fat, and 14 grams of fiber "));




        myadapter= new Myadapter(this,mymodelArrayList);
        viewPager.setAdapter(myadapter);
        viewPager.setPadding(100,0,100,0);
    }

    public  void openswg2(){
        Intent intent= new Intent(this, Slightly_weight_gain2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);

    }
}