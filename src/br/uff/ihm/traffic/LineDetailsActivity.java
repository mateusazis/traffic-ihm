package br.uff.ihm.traffic;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.os.Bundle;

public class LineDetailsActivity extends Activity {

	public static Line selectedLine;
	private TextView lineNameView, routeView, lotationView, averageSpeedView;
	private ImageView logoView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_details_layout);
		logoView = (ImageView)findViewById(R.id.lineLogo);
		lineNameView = (TextView)findViewById(R.id.lineName);
		routeView = (TextView)findViewById(R.id.route);
		lotationView = (TextView)findViewById(R.id.lotation);
		averageSpeedView = (TextView)findViewById(R.id.averageSpeed);
		
		fillData(selectedLine);
	};
	
	private void fillData(Line l){
		ImageHelper.applyImage(logoView, l.company.imgName, this);
		
		lineNameView.setText(l.number);
		routeView.setText(l.route);
		
		setLotation(0.87f);
		setAverageSpeed(43.11f);
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
	}
	
	private void setAverageSpeed(float speed){
		int roundValue = (int)Math.round(speed);
		averageSpeedView.setText(roundValue + " km/h");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		selectedLine = null;
	};
	
	public void showDetailedRoute(View v){
		Log.v("traffic", "show detailed route");
	}
	
}
