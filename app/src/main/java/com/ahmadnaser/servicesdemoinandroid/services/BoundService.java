package com.ahmadnaser.servicesdemoinandroid.services;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.media.MediaPlayer;

import com.ahmadnaser.servicesdemoinandroid.R;

public class BoundService extends Service {

    MediaPlayer mp = null;		//for playing from the /res/raw folder
    MediaPlayer local_mp = null;//for playing from the sd card

	//we have to publish an IBinder to clients:
	private final IBinder binder = new LocalBinder();
	private String[] answer = {
			"It is certain",
			"It is decidedly so",
			"Yes - definitely",
			"You may rely on it",
			"As I see it, yes",
			"Most likely",
			"Outlook good",
			"Yes",
			"Signs point to yes",
			"Reply hazy, try again",
			"Ask again later",
			"Better not tell you now",
			"Cannot predict now",
			"Concentrate and ask again",
			"Don't count on it",
			"My reply is no",
			"My sources say no",
			"Outlook not so good",
			"Very doubtful",
	};
	private final Random randomGenerator = new Random();
	
	/**  
	 * Class passed back to the client activity.
	 */
	public class LocalBinder extends Binder {
		public BoundService getService() {
			return BoundService.this;
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return binder;
	}
	
	//available to the client process:
	public String getAnswer() {
		int msgIndex = randomGenerator.nextInt(20);
		return answer[msgIndex];
	}


    public void PlayMusic() {

        mp = MediaPlayer.create(getApplicationContext(), R.raw.contra);
        mp.start();

    }

    public void StopMusic() {


        if(mp != null) {
            mp.release();
            mp = null;
        }



}

}
/*    public void onStop() {
        super.onStop();
        if(mp != null) {
            mp.release();
            mp = null;
        }
        if(local_mp != null) {
            local_mp.release();
            local_mp = null;
        }
    }*/

    /**
     * Demonstrates playing a sound on button click:
     * sound is stored in /res/raw as a midi file
     * @param v - button clicked
     */


    /**
     * Demonstrates playing sound stored on the sdcard
     * @param v - button that was clicked
     */
