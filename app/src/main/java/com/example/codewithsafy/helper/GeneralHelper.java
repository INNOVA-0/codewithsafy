package com.example.codewithsafy.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.codewithsafy.MainActivity;
import com.example.codewithsafy.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GeneralHelper {
    public static String getToadyDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        return df.format(date);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void updateNotification(Context context, Service service, int step) {
        int NOTIFICATION_ID = 7837;
        Notification.Builder notiBuilder = new Notification.Builder(context);
        NotificationManager notiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(context, "CHANNEL_ID")
                .setContentTitle("Step Counter")
                .setContentText(String.valueOf(step))
                .setTicker(String.valueOf(step))
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Step Counter"))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(String.valueOf(step)))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setProgress(500, step, false)
                //.setProgress(this.dailyStepGoal, totalSteps, false)
                .setVisibility(NotificationCompat.VISIBILITY_SECRET)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .build();


        service.startForeground(NOTIFICATION_ID, notification);
        // Set Service to run in the Foreground
        notiManager.notify(NOTIFICATION_ID, notification);

    }

    public static String getCalories(int steps) {
        int Cal = (int) (steps * 0.045);
        return Cal + " calories";
    }


    public static String getDistanceCovered(int steps) {
        int feet = (int) (steps * 2.5);
        double distance = feet / 3.281;
        double finalDistance = Double.valueOf(String.format("%.2f", distance));
        return finalDistance + " meter";
    }
}
