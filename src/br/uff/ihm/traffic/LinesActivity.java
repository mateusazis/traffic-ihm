package br.uff.ihm.traffic;

import com.github.espiandev.showcaseview.ShowcaseView;
import br.uff.ihm.traffic.utils.Showcase;
import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.models.Company;
import br.uff.ihm.traffic.models.Line;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		LineAdapter a = new LineAdapter(this, getApplicationContext(), R.layout.line_list_item, lines);
		lv.setAdapter(a);
		lv.setOnItemClickListener(this);
		
		
		ShowcaseView showCase = Showcase.make(this, R.id.lines_list, "Linhas", "Toque em alguma linha para ver detalhes");
		showCase.show();
	}
	
	private Line[] getLines(){
		return new Line[]{
				new Line("43", Company.COMPANY_INGA, "Icaraí - Fonseca", makeBuses(2)),
				new Line("49", Company.COMPANY_INGA, "Icaraí - Fonseca", makeBuses(4)),
				new Line("740D", Company.COMPANY_1001, "Charitas - Ipanema", makeBuses(5)),
				new Line("751", Company.COMPANY_1001, "Charitas - Gávea", makeBuses(0)),
				new Line("761", Company.COMPANY_1001, "Charitas - Galeão", makeBuses(1)),
				new Line("775D", Company.COMPANY_1001, "Charitas - Gávea (via Lapa)", makeBuses(3))
			};
	}
	
	private static Bus [] makeBuses(int count){
		Bus [] resp = new Bus[count];
		for(int i = 0; i < count; i++)
			resp[i] = Bus.random();
		return resp;
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
		FeedbackActivity.currentLine = LineDetailsActivity.selectedLine = chosenLine;
		
		Intent i = new Intent(getApplicationContext(), LineDetailsActivity.class);
		startActivity(i);
		SlideTransition.forwardTransition(this);
	}
}

