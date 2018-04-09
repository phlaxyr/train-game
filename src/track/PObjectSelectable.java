package track;

import main.DrawContext;

public interface PObjectSelectable extends PObjectClickable{
	public void drawSelectionHalo(DrawContext dc);
	public default void onSelect(){}
	public default void onDeselect(){}
}
