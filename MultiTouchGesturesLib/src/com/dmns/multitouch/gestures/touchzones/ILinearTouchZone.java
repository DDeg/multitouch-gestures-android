package com.dmns.multitouch.gestures.touchzones;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.helpers.DisplayParams;

public interface ILinearTouchZone extends ITouchZone {
	
	public float GetVerge(MotionEvent event, DisplayParams params);

}
