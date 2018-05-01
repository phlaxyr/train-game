package main;

import track.PSelectable;
import track.large.TLStation;
import ui.Button;
import util.MapPos;
import util.Util;


public class ToolManager {
	public PSelectable currentlySelected = null;
	
	public void select(PSelectable pos) {

		this.currentlySelected = pos;
		System.out.println("selecting "+ (pos == null ? "null" : pos.getClass().getSimpleName()));
	}
	public void draw(DrawContext dc) {
		if(currentlySelected != null) {
			currentlySelected.drawSelectionHalo(dc);
			
		} else if(ghost != null) {
			ghost.setXY(dc.mousePos);
			Main p = Ap.p();
			p.pushStyle();
			// p.alpha(256);
			System.out.println(ghost.x() + " " + ghost.y());
			ghost.draw(dc);
			p.popStyle();
		}
	}
	public boolean isSelectToolActive() {
		return isActive(Ap.p().uid.select);
	}
	public boolean isCreateNodeActive() {
		return isActive(Ap.p().uid.nodeCreate);
	}
	public boolean isActive(Button b) {
		return Ap.p().uid.activeTool != null && Ap.p().uid.activeTool.equals(b);
	}
//	public void onClicked(PClickable pc) {
//		
//	}
	public void onClicked(PSelectable ps) {
		if(isSelectToolActive()) {
			select(ps);
		}
	}
	
	static class CreateMode {
		public static final int BROWSE, GHOST;
		static {
			BROWSE = 0;
			GHOST = 1;
		}
	}
	public int nodemode;
	
	public TLStation ghost;
	
	public void onMousePress(boolean objClicked, MapPos pos, DrawContext dc) {
		if(isCreateNodeActive()) {
			// if(!objClicked) {\
			if(ghost == null) {
				ghost = new TLStation(pos.x, pos.y, "TESTING");
			} else {
				Ap.p().td.register(ghost);
				
				
				
				
			// }
			}
			

		} else {
			ghost = null;
		}
	}
}
