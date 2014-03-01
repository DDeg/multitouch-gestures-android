package com.dmns.multitouch.gestures.lib;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.helpers.DisplayParams;
import com.dmns.multitouch.gestures.touchzonelisteners.TouchZoneListener;
import com.dmns.multitouch.gestures.touchzones.CircleCenterTouchZone;
import com.dmns.multitouch.gestures.touchzones.DownLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.LeftMultiLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.RightMultiLinearTouchZone;
import com.dmns.multitouch.gestures.touchzones.UpLinearTouchZone;

public class ThreeTouchGesturesListener implements IGestureListener{
	
	DisplayParams dispParams;
	TouchZoneListener upLinearTouchZoneListener, downLinearTouchZoneListener,
	rightLinearTouchZoneListener, leftLinearTouchZoneListener, catchCenterTouchZoneListener;
	
	public ThreeTouchGesturesListener(MotionEvent event, DisplayParams params){
		dispParams = params;
		upLinearTouchZoneListener = new TouchZoneListener(
				new UpLinearTouchZone(event, params));
		downLinearTouchZoneListener = new TouchZoneListener(
				new DownLinearTouchZone(event, params));
		rightLinearTouchZoneListener = new TouchZoneListener(
				new RightMultiLinearTouchZone(event,params));
		leftLinearTouchZoneListener = new TouchZoneListener(
				new LeftMultiLinearTouchZone(event,params));
		catchCenterTouchZoneListener = new TouchZoneListener(
				new CircleCenterTouchZone(event, params));
	}

	@Override
	public int Update(MotionEvent event) {
		if(upLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.THREE_FINGERS_UP;
		}
		if(downLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.THREE_FINGERS_DOWN;
		}
		if(rightLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.THREE_FINGERS_RIGHT;
		}
		if(leftLinearTouchZoneListener.ContainsNeeded(event)){
			return Gestures.THREE_FINGERS_LEFT;
		}
		if(catchCenterTouchZoneListener.ContainsNeeded(event)){
			return Gestures.THREE_FINGERS_CATCH;
		}
		return Gestures.UNSUPPORTED_GESTURE;
	}

}
