package com.dmns.multitouch.gestures.lib;

import android.view.MotionEvent;

public class UnsupportedGesturesListener implements IGestureListener{

	@Override
	public int Update(MotionEvent event) {
		return Gestures.UNSUPPORTED_GESTURE;
	}

}
