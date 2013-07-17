package br.uff.ihm.traffic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LinesActivity extends Activity {
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.layout_lines);
//		int id = R.id.lines_list;
//		ListView lv = (ListView)findViewById(id);
//		lv.setAdapter(new LineAdapter(getApplicationContext(), id, null));
	}
}

