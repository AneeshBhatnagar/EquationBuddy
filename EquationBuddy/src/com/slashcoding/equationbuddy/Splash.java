package com.slashcoding.equationbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1500); // time to sleep (in ms)
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent startApp = new Intent(
							"com.slashcoding.equationbuddy.START");
					startActivity(startApp);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
