package com.example.codewithsafy.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.codewithsafy.Activity2;
import com.example.codewithsafy.R;
import com.example.codewithsafy.callback.stepsCallback;
import com.example.codewithsafy.helper.GeneralHelper;
import com.example.codewithsafy.helper.PrefsHelper;
import com.example.codewithsafy.service.StepDetectorService;

public  class steptracking extends AppCompatActivity implements stepsCallback  {
    private static final int CODE = 1;
    private TextView TV_STEPS, TV_CALORIES, TV_DISTANCE;
    Button stopstep;
    Button startstep;
    Button removestep;
    ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steptracking);

        TV_DISTANCE = findViewById(R.id.TV_DISTANCE);
        TV_CALORIES = findViewById(R.id.TV_CALORIES);
        TV_STEPS = findViewById(R.id.TV_STEPS);
backbutton=findViewById(R.id.back);
backbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity2();
    }
});

        startstep=findViewById(R.id.startsteps);
        removestep=findViewById(R.id.resetteps);
        removestep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefsHelper.putString("TodayDate","");
                PrefsHelper.putInt("Steps", 0);
                PrefsHelper.putInt("FSteps", 0);
                subscribeSteps(0);

            }
        });
 



startstep.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(steptracking.this, StepDetectorService.class);
        startService(intent);
        StepDetectorService.register(steptracking.this);
    }
});



        checkPermission();
    }

    private void checkPermission() {
        if ((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACTIVITY_RECOGNITION)
                != PackageManager.PERMISSION_GRANTED) ||
                (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.FOREGROUND_SERVICE)
                        != PackageManager.PERMISSION_GRANTED))
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACTIVITY_RECOGNITION,
                    android.Manifest.permission.FOREGROUND_SERVICE}, CODE);
    }

    @Override
    public void subscribeSteps(int steps) {
        TV_STEPS.setText(String.valueOf(steps));
        TV_CALORIES.setText(GeneralHelper.getCalories(steps));
        TV_DISTANCE.setText(GeneralHelper.getDistanceCovered(steps));

    }
    public void openActivity2(){
        Intent intent= new Intent(this, Activity2.class);

        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
}