package render;

import util.DrawContext;

public abstract class Element {
	public float x, y;
	public void setup(DrawContext c) {
		
	}
	public abstract void drawMap(DrawContext c);
	public abstract boolean isWithin(int x, int y);
}
