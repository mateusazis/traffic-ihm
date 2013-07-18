package br.uff.ihm.traffic;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class ImageHelper {
	
	public static void applyImage(ImageView destView, String path, Activity helper) {
		try {
			AssetManager manager = helper.getAssets();
			InputStream is = manager.open(path);
			Bitmap b = BitmapFactory.decodeStream(is);
			is.close();
			destView.setImageBitmap(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
