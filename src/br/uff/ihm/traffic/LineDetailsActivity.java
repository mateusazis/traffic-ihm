package br.uff.ihm.traffic;

import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.models.Line;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;

public class LineDetailsActivity extends Activity implements OnItemClickListener{

	public static Line selectedLine;
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
	}
	
	private void fillData(Line l){
		ImageHelper.applyImage(logoView, l.company.imgName, this);
		
		lineNameView.setText(l.number);
		routeView.setText(l.route);
		nextBusTV.setText(String.format("00:%2d:%2d", l.nextBusTime / 60, l.nextBusTime % 60));
		
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
	}
}
