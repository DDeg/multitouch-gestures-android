package com.dmns.multitouch.gestures.touchzones;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.geometric.Circle;
import com.dmns.multitouch.gestures.geometric.Point;
import com.dmns.multitouch.gestures.helpers.DisplayParams;
import com.dmns.multitouch.gestures.helpers.TouchZoneHelper;

public class CircleCenterTouchZone implements ITouchZone{
	
	Circle verge;
	
	public CircleCenterTouchZone(MotionEvent event, DisplayParams params){
		verge = GetPossibleVerge(event, params);
	}
	
	private Circle GetPossibleVerge(MotionEvent event, DisplayParams params){
		Circle circle = new Circle();
		Point screenCenter = new Point(params.GetDisplayWidth()/2,
				params.GetDisplayHeight()/2);
		ArrayList<Point> eventPoints = TouchZoneHelper.ToPoints(event);
		if(ContainsUpperX(eventPoints, screenCenter.getX())&&
				ContainsUpperY(eventPoints, screenCenter.getY())&&
				ContainsLowerX(eventPoints, screenCenter.getX())&&
				ContainsLowerY(eventPoints, screenCenter.getY()))
				{
			circle = new Circle(screenCenter,
					TouchZoneHelper.GetMinDistance(screenCenter, eventPoints)*0.9F);
		}
		return circle;
	}
	
	private boolean ContainsUpperX(ArrayList<Point> points, float x){
		for(Point point : points){
			if(point.getX()<x)
				return true;
		}
		return false;
	}
	
	private boolean ContainsUpperY(ArrayList<Point> points, float y){
		for(Point point : points){
			if(point.getY()<y)
				return true;
		}
		return false;
	}
	
	private boolean ContainsLowerX(ArrayList<Point> points, float x){
		for(Point point : points){
			if(point.getX()>x)
				return true;
		}
		return false;
	}
	
	private boolean ContainsLowerY(ArrayList<Point> points, float y){
		for(Point point : points){
			if(point.getY()>y)
				return true;
		}
		return false;
	}

	@Override
	public boolean Contains(Point point, int poinerIndex) {
		return verge.Contains(point);
	}
	
	

}
