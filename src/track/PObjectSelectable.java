package track;

import util.DrawContext;

public interface PObjectSelectable extends PObject{
	public boolean isWithinBounds(float x, float y, DrawContext dc);
}
