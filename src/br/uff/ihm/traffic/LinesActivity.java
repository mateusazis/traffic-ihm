package br.uff.ihm.traffic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LinesActivity extends Activity {
	
	
	
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		setContentView(R.layout.layout_lines);
		int id = R.id.lines_list;
		ListView lv = (ListView)findViewById(id);
		
		LineAdapter a = new LineAdapter(this, getApplicationContext(), R.layout.line_data, getLines());
		
		lv.setAdapter(a);
		
		TextView pointTV = (TextView)findViewById(R.id.lineName);
		pointTV.setText(Html.fromHtml("Conectado ao ponto: <font color=red>Plazza Shopping</font>"));


	}
	
	private Line[] getLines(){
		return new Line[]{new Line("49"), new Line("725-D")};
	}
	
//	@Override
//	public void onBackPressed() {
//	   Log.d("CDA", "onBackPressed Called");
//	   Intent setIntent = new Intent(Intent.ACTION_MAIN);
//	   setIntent.addCategory(Intent.CATEGORY_HOME);
//	   setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//	   startActivity(setIntent);
//	}
	
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
}

