package com.ahmadnaser.servicesdemoinandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.ahmadnaser.servicesdemoinandroid.services.LongRunning;


public class IntentServiceActivity extends Activity {
    int seconds = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeLayoutColor(View view) {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        switch(view.getId()) {
            case R.id.btnRed:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.btnGreen:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnBlue:
                layout.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    public void startClicked(View view) {
    	/*
    	//this code blocks the main UI thread:
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/

        //This starts an IntentService, which executes code on
        //it's own thread:
        Intent intent = new Intent(IntentServiceActivity.this, LongRunning.class);
        startService(intent);

    }
}
