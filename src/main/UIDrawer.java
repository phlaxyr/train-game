package main;

import processing.core.PConstants;

public class UIDrawer {
	public void draw() {
		
	}
	/**
	 * Depends on rectmode
	 * @param x
	 * @param y
	 * @param a
	 * @param b
	 */
	public void button1(float x, float y, float a, float b, String text) {
		Main p = Ap.p();
		p.rect(x, y, a, b);
		int rmode = p.g.rectMode;
		float cx = x; // center
		float cy = y;
		if(rmode == PConstants.CORNER) {
			cx = x + a/2;
			cy = y + b/2;
		} else if(rmode == PConstants.CORNERS) {
			cx = (x + a) / 2;
			cy = (y + b) / 2; // average (midpoint) of 2 points
		} // else if(rmode == PConstants.CENTER || rmode == PConstants.RADIUS) {
		
		p.pushStyle();
		

			p.textAlign(PConstants.CENTER);
			p.text(text, cx, cy);
		p.popStyle();
	}
}
