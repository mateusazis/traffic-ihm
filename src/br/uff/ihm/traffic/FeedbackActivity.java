package br.uff.ihm.traffic;

import java.util.ArrayList;

import br.uff.ihm.traffic.models.Bus;
import br.uff.ihm.traffic.models.Line;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
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
		
		setupFeedbackSpinner();
		setupBusSpinner();
	}
	
	private void setupFeedbackSpinner(){
		Spinner s = (Spinner)findViewById(R.id.feedbackTypeSpinner);
		s.setPrompt("Selecione uma opção");
		
		String [] options = getResources().getStringArray(R.array.feedback_type);
		ArrayList<String> optionsList = new ArrayList<String>();
		optionsList.add("Selecione...");
		for(String str : options)
			optionsList.add(str);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, optionsList);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	}
	
	private void setupBusSpinner(){
		final Spinner busSpinner = (Spinner)findViewById(R.id.busIDSpinner);
		final ArrayList<String> options = new ArrayList<String>();
		options.add("Selecione...");
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
		busSpinner.setAdapter(adapter);
		busSpinner.setPrompt("Selecione uma opção");
		
		
		if(selectedBusPos != -1)
			busSpinner.setSelection(selectedBusPos);
		
//		busSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//		    @Override
//		    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
////		        items[0] = "ABC";
//		    	options.set(0, "ABCD");
//		    	busSpinner.setSelection(position);
//		    	Log.v("", "on item selected, position: " + position);
////		        selectedItem = options.get(position);
//		        
//		    }
//
//		    @Override
//		    public void onNothingSelected(AdapterView<?> arg0) {
//		    	this.onItemSelected(arg0, null, 0, 0);
//		    	Log.v("","on nothing item selected");
//		    }
//		});
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
