package br.uff.ihm.traffic;

import java.util.ArrayList;

import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.models.Line;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends Activity {
	
	public static Line currentLine;
	public static Bus currentBus;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback_layout);
		
		Spinner s = (Spinner)findViewById(R.id.busIDSpinner);
		ArrayList<String> options = new ArrayList<String>();
		options.add("N/A");
		int selectedBusPos = -1;
		Bus [] busList = currentLine.bus;
		for(int i = 0; i < busList.length; i++){
			Bus b = busList[i];
			options.add(b.id + "");
			if(currentBus != null && b.id == currentBus.id)
				selectedBusPos = i + 1;
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, options);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
		s.setPrompt("N/A");
		
		
		if(selectedBusPos != -1)
			s.setSelection(selectedBusPos);
	}
	
	public void sendFeedback(View v){
		TextView msgView = (TextView)findViewById(R.id.feedbackMsg);
		String msgContent = msgView.getText().toString();
		String msg;
		if(msgContent.isEmpty())
			msg = "Mensagem vazia, feedback não enviado.";
		else
			msg = "Feedback enviado.";
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
		this.finish();
	}
	
	@Override
	public void finish() {
		super.finish();
		currentBus = null;
	}
}
