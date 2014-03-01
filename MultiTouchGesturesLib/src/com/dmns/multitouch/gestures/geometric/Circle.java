package com.dmns.multitouch.gestures.geometric;

public class Circle {
	
	private Point center;
	private float radius;
	
	public Circle(){
		center = new Point(0,0);
		radius = 0;
	}
	
	public Circle(float x, float y, float radius){
		center = new Point(x,y);
		this.radius = radius;
	}
	
	public Circle(Point center, float radius){
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Circle circle){
		this.center = circle.center;
		this.radius = circle.radius;
	}
	
	public Point GetCentralPoint(){
		return center;
	}
	
	public float GetCentralX(){
		return center.getX();
	}
	
	public float GetCentralY(){
		return center.getY();
	}
	
	public float GetRadius(){
		return radius;
	}
	
	public String toString()
    {
        String s = "Type: Round, x=";
        s += center.getX();
        s += ", y=";
        s += center.getY();
        s += ", Radius=";
        s += radius;
        s += ".";
        return s;
    }
	
	public boolean Contains(Point point)
    {
		return center.DistanceTo(point)<radius;
    }

}
