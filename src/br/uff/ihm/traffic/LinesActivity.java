package br.uff.ihm.traffic;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Typeface;

public class LinesActivity extends Activity implements OnItemClickListener {
	
	private Line[] lines;
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		lines = getLines();
		setContentView(R.layout.layout_lines);
		
		//setting point typeface
		TextView pointView = (TextView)findViewById(R.id.pointView);
		Typeface typeface = Typeface.createFromAsset(getAssets(), "PermanentMarker.ttf");
		pointView.setTypeface(typeface);
		
		//setting up listview
		ListView lv = (ListView)findViewById(R.id.lines_list);
		LineAdapter a = new LineAdapter(this, getApplicationContext(), R.layout.line_data, lines);
		lv.setAdapter(a);
		lv.setOnItemClickListener(this);
	}
	
	private Line[] getLines(){
		return new Line[]{
				new Line("43", Company.COMPANY_INGA, "Icaraí - Fonseca", .5788f, 37.3f),
				new Line("49", Company.COMPANY_INGA, "Icaraí - Fonseca", .1858f, 44.5f),
				new Line("740D", Company.COMPANY_1001, "Charitas - Ipanema", .259f, 27.2f),
				new Line("751", Company.COMPANY_1001, "Charitas - Gávea", .72f, 46.6f),
				new Line("761", Company.COMPANY_1001, "Charitas - Galeão", .235f, 38.76f),
				new Line("775D", Company.COMPANY_1001, "Charitas - Gávea (via Lapa)", .873f, 49.15f)
			};
	}

	
	 @Override
     public boolean onKeyDown(int keyCode, KeyEvent event)  {
         if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
                 && keyCode == KeyEvent.KEYCODE_BACK
                 && event.getRepeatCount() == 0) {
             Log.d("CDA", "onKeyDown Called");
             finish();
             return true;
         }

         return super.onKeyDown(keyCode, event);
     }

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Line chosenLine = lines[position];
		LineDetailsActivity.selectedLine = chosenLine;
		
		Intent i = new Intent(getApplicationContext(), LineDetailsActivity.class);
		startActivity(i);
	}
}

