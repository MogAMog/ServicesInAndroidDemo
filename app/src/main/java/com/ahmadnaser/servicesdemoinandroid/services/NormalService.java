package com.ahmadnaser.servicesdemoinandroid.services;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.ahmadnaser.servicesdemoinandroid.R;

public class NormalService extends Service {
	
	
	private NotificationManager manager;
	private Timer counter = new Timer();
	private long seconds = 0L;
	private TimerTask clockTask = null;
	private PendingIntent notificationIntent = null;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onCreate() {
		super.onCreate();
		manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		displayNotification("Service Started");
		clockTask = new TimerTask() {
			public void run() {
				seconds++;
			}
		};
		startCounter();
	}
	
	public void onDestroy() {
		super.onDestroy();
		stopCounter();
		manager.cancel(R.string.notification);
		displayNotification(String.format("Service stopped after %d seconds.", seconds));
		seconds = 0L;
	}
	
	private void displayNotification(CharSequence text) {
		Notification notification = new Notification.Builder(this)
			.setTicker(text)
			.setContentTitle(text)
			.setContentIntent(notificationIntent)
			.setSmallIcon(R.drawable.ic_launcher)
			.build();
		
		manager.notify(R.string.notification, notification);
	}
	
	private void startCounter() {
		//set up a timer to increment seconds once per second (1000 milliseconds):
		counter.scheduleAtFixedRate(clockTask, 0, 1000L);
	}
	
	private void stopCounter() {
		if (counter != null) {
			counter.cancel();
		}
	}

}
