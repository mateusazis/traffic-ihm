package br.uff.ihm.traffic;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;
import android.os.Bundle;

public class LineDetailsActivity extends Activity {

	public static Line selectedLine;
	private TextView lineNameView, routeView, lotationView, averageSpeedView;
	private ImageView logoView;
	private ProgressBar lotationBar;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_details_layout);
		logoView = (ImageView)findViewById(R.id.lineLogo);
		lineNameView = (TextView)findViewById(R.id.lineName);
		routeView = (TextView)findViewById(R.id.route);
		lotationView = (TextView)findViewById(R.id.lotation);
		averageSpeedView = (TextView)findViewById(R.id.averageSpeed);
		lotationBar = (ProgressBar)findViewById(R.id.lotationProgressBar);
		
		fillData(selectedLine);
	}
	
	private void fillData(Line l){
		ImageHelper.applyImage(logoView, l.company.imgName, this);
		
		lineNameView.setText(l.number);
		routeView.setText(l.route);
		
		setLotation(l.lotationPcgt);
		setAverageSpeed(l.averageSpeed);
	}
	
	private void setLotation(float pctg){
		int roundValue = (int)Math.round(pctg * 100);
		int color = 0;
		
		Resources r = getResources();
		if(pctg < 0.33f)
			color = r.getColor(R.color.LotationGood);
		else if(pctg < 0.66f)
			color = r.getColor(R.color.LotationMiddle);
		else
			color = r.getColor(R.color.LotationBad);
		
		lotationView.setTextColor(color);
		lotationView.setText(roundValue + "%");
		lotationBar.setMax(100);
		lotationBar.setProgress(roundValue);
	}
	
	private void setAverageSpeed(float speed){
		int roundValue = (int)Math.round(speed);
		averageSpeedView.setText(roundValue + " km/h");
	}
	
	public void showDetailedRoute(View v){
		Log.v("traffic", "show detailed route");
		Intent i = new Intent(getApplicationContext(), RouteActivity.class);
		startActivity(i);
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// TODO Auto-generated method stub
//		MenuInflater inflater = new MenuInflater(getApplicationContext());
//		inflater.inflate(R.menu.feedback_menu, menu);
//		return true;
//	}
//	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		Intent i = new Intent(getApplicationContext(), FeedbackActivity.class);
//		startActivity(i);
//		return super.onOptionsItemSelected(item);
//	}
	
	public void sendFeedbackClicked(View v){
		sendFeedback();
	}
	
	private void sendFeedback() {
		Intent i = new Intent(getApplicationContext(), FeedbackActivity.class);
		startActivity(i);
	}
}
