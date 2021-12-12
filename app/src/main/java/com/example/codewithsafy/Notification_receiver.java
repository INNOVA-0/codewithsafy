package com.example.codewithsafy;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notification_receiver extends BroadcastReceiver  {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent re= new Intent(context,dailychallenge.class);
        re.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =PendingIntent.getActivity(context,100,re,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"safy")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.main_logo)
          .setContentTitle("Daily Challenge")
           .setContentText("Hello! A New Challenge is there for you :)")
                .setAutoCancel(true)
           .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(100,builder.build());

    }
}
