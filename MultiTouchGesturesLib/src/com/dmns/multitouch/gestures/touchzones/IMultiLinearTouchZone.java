package com.dmns.multitouch.gestures.touchzones;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.helpers.DisplayParams;

public interface IMultiLinearTouchZone extends ITouchZone {
	
	public ArrayList<Float> GetVerges(MotionEvent event, DisplayParams params);

}
