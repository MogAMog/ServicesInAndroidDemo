package com.ahmadnaser.servicesdemoinandroid.services;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class LongRunning extends IntentService {
	
	public LongRunning() {
		super("LongRunning");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Long Running Service finished", Toast.LENGTH_LONG).show();
	}

}
