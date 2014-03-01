package com.dmns.multitouch.gestures.helpers;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.dmns.multitouch.gestures.geometric.Point;

public class TouchZoneHelper {
	
	public static float GetMinDistance(Point point, ArrayList<Point> points){
		float minDistance = point.DistanceTo(points.get(0));
		for(Point pointTo : points){
			if(point.DistanceTo(pointTo)<minDistance)
				minDistance = point.DistanceTo(pointTo);
		}
		return minDistance;
	}
	
	public static ArrayList<Float> ToFloatListX (ArrayList<Point> points){
		ArrayList<Float> result = new ArrayList<Float>();
		for(Point point : points){
			result.add(ToFloatX(point));
		}
		return result;
	}
	
	public static ArrayList<Float> ToFloatListY (ArrayList<Point> points){
		ArrayList<Float> result = new ArrayList<Float>();
		for(Point point : points){
			result.add(ToFloatY(point));
		}
		return result;
	}
	
	public static ArrayList<Float> ToFloatListX (MotionEvent event){
		ArrayList<Point> points = ToPoints(event);
		ArrayList<Float> result = new ArrayList<Float>();
		for(Point point : points){
			result.add(ToFloatX(point));
		}
		return result;
	}
	
	public static ArrayList<Float> ToFloatListY (MotionEvent event){
		ArrayList<Point> points = ToPoints(event);
		ArrayList<Float> result = new ArrayList<Float>();
		for(Point point : points){
			result.add(ToFloatY(point));
		}
		return result;
	}
	

	public static ArrayList<Point> ToPoints(MotionEvent event){
		ArrayList<Point> result = new ArrayList<Point>();
		int pointerCount = event.getPointerCount();
		for(int i = 0; i < pointerCount;i++) {
			result.add(new Point(event.getX(i),event.getY(i)));
		}
		return result;
	}
	
	private static Float ToFloatX(Point point){
		return point.getX();
	}
	
	private static Float ToFloatY(Point point){
		return point.getY();
	}

}
