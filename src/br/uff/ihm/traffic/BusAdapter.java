package br.uff.ihm.traffic;

import br.uff.ihm.traffic.models.Bus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BusAdapter extends ArrayAdapter<Bus>{

	private Activity act;
	private Bus[] objects;
	private int layoutID;
	
	public BusAdapter(Activity a, int textViewResourceId, Bus[] objects) {
		super(a.getBaseContext(), textViewResourceId, objects);
		act = a;
		this.objects = objects;
		this.layoutID = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
View row = convertView;
        
        if(row == null)
        {
            LayoutInflater inflater = LayoutInflater.from(act.getApplicationContext());
            row = inflater.inflate(layoutID, parent, false);
        }
        TextView nameView = (TextView)row.findViewById(R.id.lineName);
        ImageView logoView = (ImageView)row.findViewById(R.id.lineLogo);
        Bus b = objects[position];
        nameView.setText(b.id);
        
        logoView.setImageResource(R.drawable.bus);
        return row;
	}
	
}
