package track;

import main.DrawContext;

public interface PSelectable extends PClickable{
	public void drawSelectionHalo(DrawContext dc);
	public default void onSelect(){}
	public default void onDeselect(){}
}
