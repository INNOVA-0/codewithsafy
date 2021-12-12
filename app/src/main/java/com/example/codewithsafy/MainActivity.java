package com.example.codewithsafy;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText username , pasword;

 DB db;
  private Button button,button1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();
        createNotificationChannel();
        Intent intent= new Intent(getApplicationContext(), Notification_receiver.class);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        username = findViewById(R.id.email);
        pasword = findViewById(R.id.password);

        button= (Button) findViewById(R.id.button);
        button1= (Button) findViewById(R.id.but11);
        db= new DB(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass= pasword.getText().toString();

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(pasword.getText().toString())){
                    Toast.makeText(MainActivity.this,"please fill every fields",Toast.LENGTH_SHORT).show();

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(user).matches() && !user.matches("^((\\+92)|(0092))-{0,1}\\d{3}-{0,1}\\d{7}$|^\\d{11}$|^\\d{4}-\\d{7}$")) {
                    username.setError("please enter a valid email address/phone no");
                }

                else {

                    if(db.isloginvalid(user,pass) ==true)
                    {
                        Toast.makeText(MainActivity.this, "sign-in successfully", Toast.LENGTH_SHORT).show();
                        openActivity2();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "IN-Valid Data", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregisterActivity2();
            }
        });


    }

    private void openregisterActivity2() {
        Intent intent= new Intent(this, registerActivity2.class);
        startActivity(intent);
    }

    public void openActivity2 (){
        Intent intent= new Intent(this, Activity2.class);
        startActivity(intent);
    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "dfdfs";
            String description = "dsdsd";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("safy", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }}
}