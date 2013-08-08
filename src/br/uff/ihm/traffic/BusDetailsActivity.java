package br.uff.ihm.traffic;

import com.github.espiandev.showcaseview.ShowcaseView;

import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.utils.Showcase;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class BusDetailsActivity extends Activity {

	public static Bus selectedBus;
	private TextView lineNameView, routeView, lotationView, averageSpeedView, busIDView;
	private ImageView logoView;
	private ProgressBar lotationBar;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bus_details_layout);
		logoView = (ImageView)findViewById(R.id.lineLogo);
		
		lineNameView = getTextView(R.id.lineName);
		routeView = getTextView(R.id.route);
		lotationView = getTextView(R.id.lotation);
		averageSpeedView = getTextView(R.id.averageSpeed);
		busIDView = getTextView(R.id.tvBusID);
		
		lotationBar = (ProgressBar)findViewById(R.id.lotationProgressBar);
		
		fillData(selectedBus);
		
		ShowcaseView v = Showcase.make(this, R.id.feedback_button, "Enviar comentários", "Se quiser entrar em contato com esta empresa de ônibus, basta clicar no botão abaixo!\n\nÉ isso! Bom uso!");
		v.show();
	}
	
	private TextView getTextView(int resourceID){
		return (TextView)findViewById(resourceID);
	}
	
	private void fillData(Bus b){
		ImageHelper.applyImage(logoView, b.line.company.imgName, this);
		
		lineNameView.setText(b.line.number);
		busIDView.setText(selectedBus.id);
		routeView.setText(b.line.route);
		
		setLotation(b.lotationPcgt);
		setAverageSpeed(b.averageSpeed);
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
	
	public void sendFeedbackClicked(View v){
		sendFeedback();
	}
	
	private void sendFeedback() {
		FeedbackActivity.currentBus = selectedBus;
		
		Intent i = new Intent(getApplicationContext(), FeedbackActivity.class);
		startActivity(i);
	}
	
	@Override
	public void onBackPressed() 
	{
	    this.finish();
	    SlideTransition.backTransition(this);
	}
}
