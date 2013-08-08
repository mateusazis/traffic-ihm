package br.uff.ihm.traffic;

import com.github.espiandev.showcaseview.ShowcaseView;
import com.github.espiandev.showcaseview.ShowcaseView.OnShowcaseEventListener;

import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.models.Line;
import br.uff.ihm.traffic.utils.ImageHelper;
import br.uff.ihm.traffic.utils.Showcase;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;

public class LineDetailsActivity extends Activity implements OnItemClickListener{

	public static Line selectedLine;
	private static boolean showCased = false;
	private TextView lineNameView, routeView, nextBusTV;
	private ImageView logoView;
	private ListView busListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.line_details_layout);
		logoView = (ImageView)findViewById(R.id.lineLogo);
		lineNameView = (TextView)findViewById(R.id.lineName);
		routeView = (TextView)findViewById(R.id.route);
		nextBusTV = (TextView)findViewById(R.id.nextBusTV);
		busListView = (ListView)findViewById(R.id.busListView);
		
		fillData(selectedLine);
		
		TextView parkedVechilesTV = (TextView)findViewById(R.id.parkedVechilesText);
		parkedVechilesTV.setText(Html.fromHtml("Veículos <u><font color=\"#F7F757\">parados</font></u> no ponto:"));
		
		if(!showCased){
			ShowcaseView showCase = Showcase.make(this, R.id.busListView, "Veículos", "Estes são os veículos parados no ponto. Toque em algum para saber mais a respeito.");
			showCase.setOnShowcaseEventListener(new ShowCaseListener(this));
			showCase.show();
			
			showCased = true;
		}
	}
	
	private void fillData(Line l){
		ImageHelper.applyImage(logoView, l.company.imgName, this);
		
		lineNameView.setText(l.number);
		routeView.setText(l.route);
		nextBusTV.setText(String.format("00:%02d:%02d", l.nextBusTime / 60, l.nextBusTime % 60));
		
		BusAdapter adapter = new BusAdapter(this, R.layout.bus_list_item, selectedLine.bus);
		busListView.setAdapter(adapter);
		busListView.setOnItemClickListener(this);
	}
	
	public void showDetailedRoute(View v){
		Intent i = new Intent(getApplicationContext(), RouteActivity.class);
		startActivity(i);
	}
	
	public void sendFeedbackClicked(View v){
		sendFeedback();
	}
	
	private void sendFeedback() {
		Intent i = new Intent(getApplicationContext(), FeedbackActivity.class);
		startActivity(i);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
		Bus chosenBus = selectedLine.bus[position];
		FeedbackActivity.currentBus = BusDetailsActivity.selectedBus = chosenBus;
		
		Intent i = new Intent(getApplicationContext(), BusDetailsActivity.class);
		startActivity(i);
		SlideTransition.forwardTransition(this);
	}
	
	@Override
	public void onBackPressed() 
	{
	    this.finish();
	    SlideTransition.backTransition(this);
	}
	
	private class ShowCaseListener implements OnShowcaseEventListener {
		private boolean firstCase = true;
		private Activity activity;
		
		public ShowCaseListener(Activity act){
			this.activity = act;
		}
		
		@Override
		public void onShowcaseViewHide(ShowcaseView arg0) {
			if(firstCase){
				ShowcaseView v = Showcase.make(activity, R.id.routeButton, "Percurso", "Acesse aqui para visualizar um mapa com o percurso do ônibus e saber por onde ele passa :)");
				v.show();
			}
			firstCase = false;
		}

		@Override
		public void onShowcaseViewShow(ShowcaseView arg0) {		}
	}
}
