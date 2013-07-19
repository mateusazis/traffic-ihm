package br.uff.ihm.traffic;

import com.google.android.maps.MapActivity;

public class RouteActivity extends MapActivity {

	@Override
	protected void onCreate(android.os.Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.route_layout);
		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}

}
