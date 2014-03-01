package com.dmns.multitouch.gestures.touchzones;

import com.dmns.multitouch.gestures.geometric.Point;

public interface ITouchZone {
	
	public boolean Contains(Point point, int poinerIndex);

}
