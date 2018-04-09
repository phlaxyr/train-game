package track;

import main.DrawContext;

public interface PObjectClickable extends PObject{

	public boolean isWithinBounds(float x, float y, DrawContext dc);
	public float tolerance(DrawContext dc);
	

	
}
