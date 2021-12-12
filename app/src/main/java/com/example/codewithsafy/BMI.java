package com.example.codewithsafy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

public class BMI extends AppCompatActivity {
    EditText weight, height,age;
    private Button BMI;
    ProgressDialog progressDialog;
    String calculation;
  Float bmi;
  Toolbar toolbar;
  ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        toolbar=findViewById(R.id.tooolbar);
        setSupportActionBar(toolbar);
        weight = findViewById(R.id.editTextNumber);
        height = findViewById(R.id.editTextNumber2);
        age = findViewById(R.id.editTextNumber3);


        BMI = (Button) findViewById(R.id.button9);
        backbutton=findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        BMI.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       if (TextUtils.isEmpty(weight.getText().toString()) || TextUtils.isEmpty(height.getText().toString())|| TextUtils.isEmpty(age.getText().toString())) {

                                           Toast.makeText(BMI.this, "please fill every fields", Toast.LENGTH_SHORT).show();


                                       }



                                           else {
                                           progressDialog = new ProgressDialog(BMI.this);
                                           progressDialog.show();
                                           Handler handler = new Handler();

                                           handler.postDelayed(new Runnable() {
                                               @Override
                                               public void run() {


                                                   Float weight1 =Float.parseFloat(weight.getText().toString());

                                                   Float height1 = Float.parseFloat(height.getText().toString());

                                                   height1 = height1 / 100;
                                                    bmi = weight1 / (height1 * height1);

                                                   if (bmi < 16) {


                                                       showdialogue(R.drawable.underweight,"severely UnderWeight");
                                                   } else if (bmi >= 16 && bmi < 18.5  ) {


                                                       showdialogue(R.drawable.underweight,"UnderWeight");
                                                   } else if (bmi >= 18.5 && bmi <= 24.9) {

showdialogue(R.drawable.normal_weight,"Normal Weight");

                                                   } else if (bmi >= 25 && bmi <= 29.9) {

                                                       showdialogue(R.drawable.overweight,"OverWeight");

                                                   } else {

                                                       showdialogue(R.drawable.obesee,"Obese");
                                                   }


                                                   weight.getText().clear();
                                                   height.getText().clear();
                                                   age.getText().clear();

                                                   progressDialog.dismiss();



                                               }
                                           }, 1500);
                                           progressDialog.setContentView(R.layout.progress_dialog);
                                           progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                                           ;

                                       }
                                   }

                               }

        );
    }
    private void opendiet() {
        Intent intent= new Intent(this, day1.class);
        startActivity(intent);
    }

    private void showdialogue(int id, String title) {
        ViewGroup viewGroup=findViewById(android.R.id.content);
            View view= LayoutInflater.from(this).inflate(R.layout.dialogue_box,viewGroup,false);
        AppCompatButton ok = view.findViewById(R.id.checkdiet);
        AppCompatButton oki = view.findViewById(R.id.cancell);
        TextView result= view.findViewById(R.id.result1);
        result.setText(title);
        ImageView imageView= view.findViewById(R.id.pic);
        imageView.setImageResource(id);

       

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setView(view);
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bmi<16){
                  openday1weightgain();

                }
                else if (bmi < 18.5) {
                    openslightlygain();

                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    openNormalWeight();


                } else if (bmi >= 25 && bmi <= 29.9) {
                    openslightlylose();

                } else {
                    openday1();

                }
                alertDialog.dismiss();
            }
        });

oki.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        alertDialog.dismiss();
    }
});
    }
public void openActivity2(){
    Intent intent= new Intent(this, Activity2.class);
    startActivity(intent);
    overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
}

    public void openday1(){
        Intent intent= new Intent(this, day1.class);
        startActivity(intent);
    }
    public void openday2(){
        Intent intent= new Intent(this, day2.class);
        startActivity(intent);
    }
    public void openday1weightgain(){
        Intent intent= new Intent(this, day1_weightgain.class);
        startActivity(intent);
    }
    public void openNormalWeight(){
        Intent intent= new Intent(this, NormalWeight.class);
        startActivity(intent);
    }
    public void openslightlygain(){
        Intent intent= new Intent(this, slightly_weight_gain.class);
        startActivity(intent);
    }
    public void openslightlylose(){
        Intent intent= new Intent(this, slightly_weightlose.class);
        startActivity(intent);
    }
}
