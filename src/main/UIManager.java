package main;

import java.util.ArrayList;
import java.util.List;

import processing.core.PConstants;
import ui.Button;
import util.TransformContext;

public class UIManager {
	public final DrawContext flatdc = new DrawContext(0, new TransformContext(1, 0, 0), 0, 0);
	public Button nodeCreate;
	public Button select;
	public Button activeTool;
	public List<Button> tools = new ArrayList<>();
	{
		Ap.p().rectMode(PConstants.CORNER);
		nodeCreate = new Button(0, 400, 100, 50, "Create Node");
		select = new Button(100, 400, 100, 50, "Select Tool") {
			@Override
			public void setUnpressed() {
				super.setUnpressed();
				Ap.p().stm.select(null);
			}
		};
		tools.add(nodeCreate);
		tools.add(select);
	}
	public void draw( ){
		Ap.p().pushStyle();

		Ap.p().fill(255);
//		nodeCreate.draw(flatdc);
//		select.draw(flatdc);
		for(Button b : tools) {
			b.draw(flatdc);
		}
		Ap.p().popStyle();
	}
	

	

	/**
	 * draw standard
	 * @param x
	 * @param y
	 */
	public void mousePressed(int x, int y) {
//		Util.println(x, y);
//		System.out.println(nodeCreate.isWithinBounds(x, y, flatdc));
//		isPressed = true;
//		if(nodeCreate.onMousePress(x, y, flatdc)) {
//			
//			activeTool = nodeCreate;
//			
//			select.setUnpressed();
//		} else if(select.onMousePress(x, y, flatdc)) {
//			
//			activeTool = select;
//			
//			nodeCreate.setUnpressed();
//		}
		for(Button b : tools) {
			boolean wasPressed = b.isPressed();
			if(b.buttonClicked(x, y, flatdc)) { 
				
				activeTool = wasPressed ? null : b;
				break;
			}
			
		}
		for(Button b : tools) {
			if(b.equals(activeTool)) continue;
			b.setUnpressed();
		}
		
	}
	public void mouseReleased() {
//		nodeCreate.mouseReleased();
//		select.mouseReleased();
		for(Button b : tools) b.mouseReleased();
	}
	
//	/**
//	 * Depends on rectmode
//	 * @param x
//	 * @param y
//	 * @param a
//	 * @param b
//	 */
//	public void button1(float x, float y, float a, float b, String text) {
//		Main p = Ap.p();
//		p.rect(x, y, a, b);
//		int rmode = p.g.rectMode;
//		float cx = x; // center
//		float cy = y;
//		if(rmode == PConstants.CORNER) {
//			cx = x + a/2;
//			cy = y + b/2;
//		} else if(rmode == PConstants.CORNERS) {
//			cx = (x + a) / 2;
//			cy = (y + b) / 2; // average (midpoint) of 2 points
//		} // else if(rmode == PConstants.CENTER || rmode == PConstants.RADIUS) {
//		
//		p.pushStyle();
//		
//			p.fill(0);
//			p.textSize(10);
//			p.textAlign(PConstants.CENTER, PConstants.CENTER);
//			p.text(text, cx, cy);
//
//		p.popStyle();
//	}
}
