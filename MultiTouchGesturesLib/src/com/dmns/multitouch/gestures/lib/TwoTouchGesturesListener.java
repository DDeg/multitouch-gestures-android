package com.dmns.multitouch.gestures.lib;

import com.dmns.multitouch.gestures.helpers.DisplayParams;
import com.dmns.multitouch.gestures.touchzonelisteners.TouchZoneListener;
import com.dmns.multitouch.gestures.touchzones.DownLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.LeftMultiLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.RightMultiLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.UpLinearTouchZone;

import android.view.MotionEvent;

public class TwoTouchGesturesListener implements IGestureListener{
	
	DisplayParams dispParams;
	TouchZoneListener upLinearTouchZoneListener, downLinearTouchZoneListener,
	rightLinearTouchZoneListener, leftLinearTouchZoneListener;
	
	public TwoTouchGesturesListener(MotionEvent event, DisplayParams params){
		dispParams = params;
		upLinearTouchZoneListener = new TouchZoneListener(
				new UpLinearTouchZone(event, params));
		downLinearTouchZoneListener = new TouchZoneListener(
				new DownLinearTouchZone(event, params));
		rightLinearTouchZoneListener = new TouchZoneListener(
				new RightMultiLinearTouchZone(event,params));
		leftLinearTouchZoneListener = new TouchZoneListener(
				new LeftMultiLinearTouchZone(event,params));
	}

	@Override
	public int Update(MotionEvent event) {
		if(upLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.TWO_FINGERS_UP;
		}
		if(downLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.TWO_FINGERS_DOWN;
		}
		if(rightLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.TWO_FINGERS_RIGHT;
		}
		if(leftLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.TWO_FINGERS_LEFT;
		}
		return Gestures.UNSUPPORTED_GESTURE;
	}


}
