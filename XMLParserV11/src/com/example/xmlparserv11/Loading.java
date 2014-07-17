package com.example.xmlparserv11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Loading extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		Thread loadingThread = new Thread() {
			@Override
			public void run() {
				try {
					super.run();
					sleep(20000);
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					Intent i = new Intent(Loading.this, XMLParserV11.class);
					startActivity(i);
					finish();
				}
			}
		};

		loadingThread.start();
	}

}
