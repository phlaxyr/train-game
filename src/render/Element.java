package render;

import util.TransformContext;

@Deprecated
public abstract class Element {
	public float x, y;
	public void setup(TransformContext c) {
		
	}
	public abstract void drawMap(TransformContext c);
	public abstract boolean isWithin(int x, int y);
}
