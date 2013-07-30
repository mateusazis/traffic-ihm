package br.uff.ihm.traffic;

import java.util.ArrayList;

import org.w3c.dom.Document;

import android.app.Activity;
import android.graphics.Color;
import app.akexorcist.googlemapsv2direction.GMapV2Direction;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsRouteActivity extends Activity {

	@Override
	protected void onCreate(android.os.Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.map_route_layout);
		View fragmentView =  findViewById(R.id.map);
		
		GoogleMap map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		
//		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//		showMapRoute(0, 0, 0, 0, map);
		
	}
	
	private void showMapRoute(double startX, double startY, double endX, double endY, GoogleMap mMap){
		
		LatLng fromPosition = new LatLng(13.687140112679154, 100.53525868803263);
		LatLng toPosition = new LatLng(13.683660045847258, 100.53900808095932);


		GMapV2Direction md = new GMapV2Direction();

		Document doc = md.getDocument(fromPosition, toPosition, GMapV2Direction.MODE_DRIVING);
		if(doc == null)
			Log.v("debug", "DOC IS NULL");
		ArrayList<LatLng> directionPoint = md.getDirection(doc);
		if(directionPoint == null)
			Log.v("debug", "directionPoint IS NULL");
		
		PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED);

		for(int i = 0 ; i < directionPoint.size() ; i++) {          
			rectLine.add(directionPoint.get(i));
		}

		mMap.addPolyline(rectLine);
	}

}


//package br.uff.ihm.traffic;
//
//import com.google.android.maps.MapActivity;
//
//public class MapsRouteActivity extends MapActivity {
//
//	@Override
//	protected void onCreate(android.os.Bundle icicle) {
//		super.onCreate(icicle);
//		setContentView(R.layout.map_route_layout);
//		
//	}
//	
//	@Override
//	protected boolean isRouteDisplayed() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
