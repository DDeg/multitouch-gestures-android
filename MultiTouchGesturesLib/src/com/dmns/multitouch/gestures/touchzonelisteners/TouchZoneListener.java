package com.dmns.multitouch.gestures.touchzonelisteners;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.geometric.Point;
import com.dmns.multitouch.gestures.helpers.TouchZoneHelper;
import com.dmns.multitouch.gestures.touchzones.ITouchZone;


public class TouchZoneListener implements ITouchZoneListener {
	
	ITouchZone touchZone;
	
	public TouchZoneListener(ITouchZone touchZone){
		this.touchZone = touchZone;
	}

	@Override
	public boolean ContainsNeeded(MotionEvent event) {
		ArrayList<Point> points = TouchZoneHelper.ToPoints(event);
		for(int i = 0;i<event.getPointerCount();i++){
			if(!touchZone.Contains(points.get(i), i))
				return false;
		}
		return true;
	}
	
}
