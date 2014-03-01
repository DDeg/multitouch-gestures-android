package com.dmns.multitouch.gestures.helpers;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public class DisplayParamsHelper {
	
	public static int GetDisplayHeight(Context context){
		DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics); 
        return metrics.heightPixels;
	}
	
	public static int GetDisplayWidth(Context context){
		DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics); 
        return metrics.widthPixels;
	}

}
