package br.uff.ihm.traffic;

import br.uff.ihm.traffic.models.Line;
import br.uff.ihm.traffic.utils.ImageHelper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LineAdapter extends ArrayAdapter<Line>{

	private Activity act;
	private Line[] objects;
	private int layoutID;
	
	public LineAdapter(Activity a, Context context, int textViewResourceId, Line[] objects) {
		super(context, textViewResourceId, objects);
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
        Line l = objects[position];
        nameView.setText(l.number);
        
        ImageHelper.applyImage(logoView, l.company.imgName, act);
        
        return row;
	}
	
}
