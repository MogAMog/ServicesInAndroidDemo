package com.ahmadnaser.servicesdemoinandroid;

import android.app.Activity;
import android.os.Bundle;



import android.os.IBinder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import android.view.View;
import android.widget.Toast;

import com.ahmadnaser.servicesdemoinandroid.services.BoundService;
/*
*
* When creating a service that provides binding,
* you must provide an IBinder that provides the programming interface
* that clients can use to interact with the service.
* There are three ways you can define the interface:
*1-Extending the Binder class
*2-Using a Messenger
*3-Using AIDL (Android Interface Definition Language)
* */

public class BoundServiceActivity extends Activity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        intent = new Intent(BoundServiceActivity.this, BoundService.class);
    }

    BoundService theService;
    boolean isBound = false;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BoundService.LocalBinder binder = (BoundService.LocalBinder) service;
            theService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };




    protected void onStart() {
        super.onStart();
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    protected void onStop() {
        super.onStop();
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }

    public void onBtnClick(View view) {




            if (R.id.button1 == view.getId()) {

                //pop a toast with the result of the current answer:
                if (isBound)
                Toast.makeText(this, theService.getAnswer(), Toast.LENGTH_LONG).show();
            }

            if (R.id.button2 ==view.getId()) {
                if (isBound)
                theService.PlayMusic();
            }


            if (R.id.button3 == view.getId()) {
                if (isBound)
                theService.StopMusic();
            }

    }

}
