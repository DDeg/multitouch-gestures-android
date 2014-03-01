package com.dmns.multitouch.gestures.helpers;

import android.content.Context;

import com.dmns.multitouch.gestures.geometric.Point;

public class DisplayParams {
	
	Point params;
	
	public DisplayParams(Context context){
		params = new Point(DisplayParamsHelper.GetDisplayWidth(context),
				DisplayParamsHelper.GetDisplayHeight(context));
	}
	
	public float GetDisplayWidth(){
		return params.getX();
	}
	
	public float GetDisplayHeight(){
		return params.getY();
	}

}
