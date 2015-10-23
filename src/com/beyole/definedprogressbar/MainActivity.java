package com.beyole.definedprogressbar;

import com.beyole.view.HorizontalProgressbarWithNumbers;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

	private HorizontalProgressbarWithNumbers mProgressBar;
	private static final int PROGRESS_UPDATE = 0x111;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mProgressBar = (HorizontalProgressbarWithNumbers) findViewById(R.id.id_myHorizontalProgressBar);
		MyHandler.sendEmptyMessage(PROGRESS_UPDATE);
	}

	private Handler MyHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int progress = mProgressBar.getProgress();
			mProgressBar.setProgress(++progress);
			if (progress > 100) {
				MyHandler.removeMessages(PROGRESS_UPDATE);
			}
			MyHandler.sendEmptyMessageDelayed(PROGRESS_UPDATE, 100);
		};
	};

}
