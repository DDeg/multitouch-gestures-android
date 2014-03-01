package com.dmns.multitouch.gestures.touchzones;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.geometric.Point;
import com.dmns.multitouch.gestures.helpers.DisplayParams;
import com.dmns.multitouch.gestures.helpers.TouchZoneHelper;

public class RightMultiLinearTouchZone implements IMultiLinearTouchZone {
	
	private ArrayList<Float> verges;
	
	public RightMultiLinearTouchZone(MotionEvent event, DisplayParams params){
		verges = GetVerges(event, params);
	}

	@Override
	public boolean Contains(Point point, int pointerIndex) {
		return point.getX()>verges.get(pointerIndex)?true:false;
	}

	@Override
	public ArrayList<Float> GetVerges(MotionEvent event, DisplayParams params) {
		ArrayList<Float> vergesRes = new ArrayList<Float>();
		for(float verge: TouchZoneHelper.ToFloatListX(event)){
			vergesRes.add(verge + params.GetDisplayWidth()*0.1F);
		}
		return vergesRes;
	}

}
