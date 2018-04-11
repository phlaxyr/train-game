package main;

import static main.OriginMode.*;

public class LargeMap {
	public static float toMapX(Main m, float x, OriginMode fromMode) {
		float rt = x;
		
		if(fromMode == DRAW_DEFAULT) {
			
			rt -= m.centerX;
		}
		if(fromMode != MAP_CENTER) {
			rt -= m.mOriginX;
		}
		return rt / m.transformContext().db;
	}
	public static float toMapY(Main m, float y, OriginMode fromMode) {
		float rt = y;
		if(fromMode == DRAW_DEFAULT) {
			rt -= m.centerY;
		}
		if(fromMode != MAP_CENTER) {
			rt -= m.mOriginY;
		}
		return rt / m.transformContext().db;
	}

}
