package com.ahmadnaser.servicesdemoinandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ahmadnaser.servicesdemoinandroid.services.NormalService;


public class NormalServiceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_service);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.normal, menu);
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

    public void btnClicked(View view) {

        Intent intent = new Intent(NormalServiceActivity.this, NormalService.class);

        switch (view.getId()) {
            case R.id.btnStartService:
                startService(intent);
                view.setEnabled(false);
                view.setAlpha(0.8f);
                break;
            case R.id.btnStopService:
                stopService(intent);
                Button startButton = (Button) findViewById(R.id.btnStartService);
                startButton.setEnabled(true);
                startButton.setAlpha(1.0f);
                break;
            default:
                Log.e("ERROR", "A click event was generated unexpectedly");
        }
    }
}
