package br.uff.ihm.traffic;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ImageRouteActivity extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.img_route_layout);
		WebView routeWebview = (WebView)findViewById(R.id.routeWebview);
		routeWebview.getSettings().setBuiltInZoomControls(true);
		routeWebview.loadUrl("file:///android_asset/print.png");
	}

}