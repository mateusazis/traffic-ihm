package br.uff.ihm.traffic;

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
//        TextView tvNome = (TextView)row.findViewById(R.id.tvNome);
//        TextView tvValor = (TextView)row.findViewById(R.id.tvValor);
        Line l = objects[position];
        nameView.setText(l.number);
        logoView.setImageResource(R.drawable.inga_logo);
        
//        int cor = m.isDespesa() ? Color.RED : Color.GREEN;
//        tvData.setTextColor(cor);
//        tvNome.setTextColor(cor);
//        tvValor.setTextColor(cor);
//        tvData.setText(m.getData().toString());
//        tvNome.setText(m.getNome());
//        int qtd = m.getQtd();
//        float val = m.getValor();
//        tvValor.setText(String.format("%d x %.2f = R$ %.2f", qtd, val, qtd*val));
        
        return row;
	}
	
}
