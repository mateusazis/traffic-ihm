package br.uff.ihm.traffic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				onConnected();
			};
		}, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onConnected(){
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				android.widget.Toast.makeText(getApplicationContext(), "connected", 1000).show();
			}
		});
		Intent i = new Intent(getApplicationContext(), LinesActivity.class);
		startActivity(i);
	}

}
