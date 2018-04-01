package track;

import main.DrawContext;

public interface PObjectSelectable extends PObject{

	public boolean isWithinBounds(float x, float y, DrawContext dc);
}
