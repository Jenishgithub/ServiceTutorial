package com.example.servicetutorial;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

public class MyService extends Service {

	static long timeInMilliseconds = 0L;
	public static Handler customHandler = new Handler();
	public static long updatedTime = 0L;
	private static long startTime = 0L;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Let it continue running until it is stopped.
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		startTime = SystemClock.uptimeMillis();
		customHandler.postDelayed(updateTimerThread, 0);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		customHandler.removeCallbacks(updateTimerThread);
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

	public static Runnable updateTimerThread = new Runnable() {

		public void run() {

			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

			updatedTime = timeInMilliseconds;

			int secs = (int) (updatedTime / 1000);
			int mins = secs / 60;
			secs = secs % 60;
			int milliseconds = (int) (updatedTime % 1000);
			MainActivity.timerValue.setText("" + mins + ":"
					+ String.format("%02d", secs) + ":"
					+ String.format("%03d", milliseconds));
			customHandler.postDelayed(this, 0);
		}

	};
}
