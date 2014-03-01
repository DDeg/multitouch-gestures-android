package com.dmns.multitouch.gestures.touchzones;

import java.util.ArrayList;
import java.util.Collections;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.geometric.Point;
import com.dmns.multitouch.gestures.helpers.DisplayParams;
import com.dmns.multitouch.gestures.helpers.TouchZoneHelper;

public class DownLinearTouchZone implements ILinearTouchZone {
	
	private float verge;	
	
	public DownLinearTouchZone(MotionEvent event, DisplayParams params){
		verge = GetVerge(event, params);
	}

	@Override
	public boolean Contains(Point point, int pointerIndex) {
		return point.getY()>verge?true:false;
	}

	@Override
	public float GetVerge(MotionEvent event, DisplayParams params) {
		ArrayList<Float> pointsY = TouchZoneHelper.ToFloatListY(event);
		float maxValue = Collections.max(pointsY);
		return (float) (maxValue + params.GetDisplayHeight()*0.1F);
	}

}
