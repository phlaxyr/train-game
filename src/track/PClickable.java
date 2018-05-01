package track;

import main.DrawContext;

public interface PClickable extends PObject{

	public boolean isWithinBounds(float x, float y, DrawContext dc);
	public float tolerance(DrawContext dc);
	
//	public default void onMousePress(int x, int y, DrawContext dc) {}

	
}
