package main;

import track.PObjectSelectable;

public class SelectToolManager {
	public PObjectSelectable currentlySelected = null;
	
	public void select(PObjectSelectable pos) {

		this.currentlySelected = pos;
		System.out.println("selecting "+ (pos == null ? "null" : pos.getClass().getSimpleName()));
	}
	public void draw(DrawContext dc) {
		if(currentlySelected == null) return;
		currentlySelected.drawSelectionHalo(dc);
	}
	public boolean isSelectToolActive() {
		if(Ap.p().uid.activeTool == null) return false;
		return Ap.p().uid.activeTool.equals(Ap.p().uid.selectTool);
	}
}
