package util;

import processing.core.PVector;

public class ScreenPos implements Vectorable{
	public float x,y;

	public ScreenPos(float x, float y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public PVector toVector() {
		return new PVector(x, y);
	}
	
	
}
