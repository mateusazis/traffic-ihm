package br.uff.ihm.traffic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback_layout);
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
}
