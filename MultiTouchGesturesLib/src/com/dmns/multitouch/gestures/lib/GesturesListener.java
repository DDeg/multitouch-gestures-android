package com.dmns.multitouch.gestures.lib;

import android.content.Context;
import android.view.MotionEvent;

import com.dmns.multitouch.gestures.helpers.DisplayParams;

public class GesturesListener implements IGestureListener {
	
	private int currentTouchCount;
	private DisplayParams dispParams;
	

	private final int TWO_FINGERS	= 2;
	private final int THREE_FINGERS	= 3;
	private final int FOUR_FINGERS	= 4;
	private final int FIVE_FINGERS	= 5;
	
	private IGestureListener gestListener;
	
	
	public GesturesListener(Context context){
		currentTouchCount = 0;
		gestListener = new UnsupportedGesturesListener();
		dispParams = new DisplayParams(context);
	}

	@Override
	public int Update(MotionEvent event) {
		
		if(event.getPointerCount()!=currentTouchCount){
		
		switch(event.getPointerCount())
		{
		case TWO_FINGERS:
			gestListener = new TwoTouchGesturesListener(event, dispParams);
			break;
		case THREE_FINGERS:
			gestListener = new ThreeTouchGesturesListener(event, dispParams);
			break;
		case FOUR_FINGERS:
			gestListener = new FourTouchGesturesListener(event, dispParams);
			break;
		case FIVE_FINGERS:
			gestListener = new FiveTouchGesturesListener(event, dispParams);
			break;
		default:
			gestListener = new UnsupportedGesturesListener();
			break;
		}
		
		currentTouchCount = event.getPointerCount();
		
		}
		
		return gestListener.Update(event);
	}

}
