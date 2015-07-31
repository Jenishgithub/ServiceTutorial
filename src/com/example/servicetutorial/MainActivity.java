package com.example.servicetutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static TextView timerValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timerValue = (TextView) findViewById(R.id.timerValue);
	}

	// Method to start the service
	// this method will call onStartCommand() on class MyService
	public void startService(View view) {
		//MyService.customHandler.postDelayed(MyService.updateTimerThread, 0);
		startService(new Intent(getBaseContext(), MyService.class));
	}

	// Method to stop the service
	// this method will call onDestroy() on class MyService
	public void stopService(View view) {
		stopService(new Intent(getBaseContext(), MyService.class));
	}
}
