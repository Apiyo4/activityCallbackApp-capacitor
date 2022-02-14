package com.example.app

import android.app.*
import android.content.Context
import android.app.Service
import android.content.Intent
import android.os.Build
import android.graphics.BitmapFactory
import android.os.IBinder
import android.widget.RemoteViews

import androidx.core.app.NotificationCompat

class BtnClickedService: Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createIncomingNotification();

        return START_STICKY
    }

    private fun createIncomingNotification() {
        val notificationIntent = Intent(this, ImportantActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel("IncomingCall",
                "IncomingCall", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.setSound(null, null)
            notificationManager.createNotificationChannel(notificationChannel)
            val notification = NotificationCompat.Builder(this, "IncomingCall")

            notification.setContentTitle(getString(R.string.app_name))
            notification.setTicker("Call_STATUS")
            notification.setContentText("IncomingCall")
            notification.setSmallIcon(R.drawable.ic_launcher_background)
            notification.setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
            notification.setCategory(NotificationCompat.CATEGORY_CALL)
            notification.setVibrate(null)
            notification.setOngoing(true)
            notification.priority = getPriority()

            notification.setStyle(NotificationCompat.DecoratedCustomViewStyle())
            notification.setContentIntent(pendingIntent)
            notification.setFullScreenIntent(pendingIntent, true)
            notification.setAutoCancel(true)
            startForeground(1124, notification.build())
        }
        else {
            val notification = NotificationCompat.Builder(this)
            notification.setContentTitle(getString(R.string.app_name))
            notification.setTicker("Call_STATUS")
            notification.setContentText("IncomingCall")
            notification.setSmallIcon(R.drawable.ic_launcher_background)
            notification.setLargeIcon(BitmapFactory.decodeResource(this.resources,
                R.drawable.ic_launcher_foreground
            ))
            notification.setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
            notification.setVibrate(null)
            notification.setContentIntent(pendingIntent)
            notification.setOngoing(true)
            notification.setCategory(NotificationCompat.CATEGORY_CALL)
            notification.priority = getPriority()
            notification.setAutoCancel(true)
            startForeground(1124, notification.build())
        }


        }
    private fun getPriority(): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NotificationManager.IMPORTANCE_HIGH
        } else {
            Notification.PRIORITY_MAX
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
//        TODO("Not yet implemented")
        return null;
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}
