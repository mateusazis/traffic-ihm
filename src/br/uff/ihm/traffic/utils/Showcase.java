package br.uff.ihm.traffic.utils;

import android.app.Activity;
import android.content.res.Resources;
import br.uff.ihm.traffic.R;

import com.github.espiandev.showcaseview.ShowcaseView;

public class Showcase {
	public static ShowcaseView make(Activity act, int resourceID, String title, String text){
		ShowcaseView.ConfigOptions co = new ShowcaseView.ConfigOptions();
		co.hideOnClickOutside = true;
		ShowcaseView showCase = ShowcaseView.insertShowcaseView(resourceID, act, title, text, co);
		
		Resources r = act.getResources();
		int bgColor = r.getColor(R.color.ShowcaseBG);
		showCase.setBackgroundColor(bgColor);
		return showCase;
	}
}
