package br.uff.ihm.traffic;

import com.google.android.maps.MapActivity;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class RouteActivity extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.route_layout2);
		WebView routeWebview = (WebView)findViewById(R.id.routeWebview);
		routeWebview.getSettings().setBuiltInZoomControls(true);
		routeWebview.loadUrl("file:///android_asset/print.png");
	}

}

//package br.uff.ihm.traffic;
//
//import com.google.android.maps.MapActivity;
//
//public class RouteActivity extends MapActivity {
//
//	@Override
//	protected void onCreate(android.os.Bundle icicle) {
//		super.onCreate(icicle);
//		setContentView(R.layout.route_layout);
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
