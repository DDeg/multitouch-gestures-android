package com.dmns.multitouch.gestures.geometric;

public class Point {

    private float x;
    private float y;
    
    public Point() {
        this(0, 0);
    }

    public Point(Point point) {
        this(point.x, point.y);
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Point GetLocation() {
        return new Point(x, y);
    }

    
    public void SetLocation(Point point) {
        SetLocation(point.x, point.y);
    }

    public void SetLocation(float x, float y) {
        Move(x, y);
    }

    
    public void Move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    
    public void Translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean Equals(Object object) {
        if (object instanceof Point) {
            Point pt = (Point)object;
            return (x == pt.x) && (y == pt.y);
        }
        return super.equals(object);
    }
    
    public float DistanceTo(Point point){
    	return (float) Math.sqrt(Math.pow(getX()-point.x, 2) + Math.pow(getY()-point.y, 2));
    }

    
    public String ToString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + "]";
    }
}