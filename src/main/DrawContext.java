package main;

import util.TransformContext;

public class DrawContext {
	/**
	 * larger = more zoom
	 */
	public int scrollStage;
	public TransformContext tc;
	public DrawContext(int scrollStage, TransformContext c) {
		this.scrollStage = scrollStage;
		tc = c;
	}
	
}
