package main;

import util.MapPos;
import util.TransformContext;

public class DrawContext {
	/**
	 * larger = more zoom
	 */
	public int scrollStage;
	public int mouseX, mouseY;
	public MapPos mousePos;
	public TransformContext tc;
	public DrawContext(int scrollStage, TransformContext c, int mouseX, int mouseY) {
		this.scrollStage = scrollStage;
		tc = c;
		mousePos = tc.mouseToMap(mouseX, mouseY);
	}
	
}
