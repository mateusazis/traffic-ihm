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

public class LinesActivity extends Activity implements OnItemClickListener {
	
	private Line[] lines;
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		lines = getLines();
		setContentView(R.layout.layout_lines);
		int id = R.id.lines_list;
		ListView lv = (ListView)findViewById(id);
		
		LineAdapter a = new LineAdapter(this, getApplicationContext(), R.layout.line_data, lines);
		
		lv.setAdapter(a);
		lv.setOnItemClickListener(this);
		
		TextView pointTV = (TextView)findViewById(R.id.lineName);
		pointTV.setText(Html.fromHtml("Conectado ao ponto: <font color=red>Plazza Shopping</font>"));
		

	}
	
	private Line[] getLines(){
		return new Line[]{
				new Line("49", Company.COMPANY_INGA, "Icaraí - Fonseca"), 
				new Line("760D", Company.COMPANY_1001, "Charitas - Gávea")
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

