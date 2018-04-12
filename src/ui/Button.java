package ui;

import main.Ap;
import main.DrawContext;
import main.Main;
import main.UIDrawer;
import processing.core.PConstants;
import track.PObjectClickable;
import util.Util;

public class Button implements PObjectClickable{
	
	float x, y, a, b, cx, cy;
	float uplx, uply, downrx, downry; // up left and down right
	String text;
	int rmode;
	public UIDrawer ud;
	boolean isPressed;
	
	public Button(UIDrawer ud) {
		this.ud = ud;
	}
	
	public void setPressed() {
		isPressed = true;
	}
	public void setUnpressed() {
		isPressed = false;
		Ap.p().stm.select(null);
	}
	
	public boolean isPressed() {
		return isPressed;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param dc
	 * @return
	 * Is withinBounds
	 */
	public boolean onMousePress(int x, int y, DrawContext dc) {
		Util.println(x, y);
		boolean withinBounds = isWithinBounds(x, y, dc);
		isPressed = withinBounds ? !isPressed : isPressed; // if clicked, then toggle
		return withinBounds;
		
	}
	public void mouseReleased() {
//		isPressed = false;
	}
	
	public Button(float x, float y, float a, float b, String text) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		this.text = text;
		
		Main p = Ap.p();
		rmode = p.g.rectMode;
		
		if(rmode == PConstants.CENTER) {
			cx = x; // center
			cy = y;
			uplx = cx - a / 2;
			uply = cy - b / 2;
			downrx = cx + a / 2;
			downry = cy + b / 2;
		
		
		} else if(rmode == PConstants.RADIUS) {
			cx = x;
			cy = y;
			uplx = cx - a;
			uply = cx - b;
			downrx = cx + a;
			downry = cy + b;
		} else if(rmode == PConstants.CORNER) {
		
			cx = x + a/2;
			cy = y + b/2;
			uplx = x;
			uply = y;
			downrx = x + a;
			downry = y + b;
			
		} else if(rmode == PConstants.CORNERS) {
			cx = (x + a) / 2;
			cy = (y + b) / 2; // average (midpoint) of 2 points
			uplx = x;
			uply = y;
			downrx = a;
			downry = b;
			
		} // else if(rmode == PConstants.CENTER || rmode == PConstants.RADIUS) {
		Util.println(cx, cy, uplx, uply, downrx, downry);
	}

	@Override
	public void draw(DrawContext dc) {
		Main p = Ap.p();
		

		
		
		p.pushStyle();
			styleBox();
			p.rectMode(rmode);
			p.rect(x, y, a, b);

			
			styleText();
			p.text(text, cx, cy);

		p.popStyle();
	}

	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		return 	uplx < x && x < downrx
					&&
				uply < y && y < downry;
	}

	@Override
	public float tolerance(DrawContext dc) {
		return 0;
	}

	
	public void styleBox() {
		Main p = Ap.p();
		if(isPressed) {
			p.fill(0, 200, 200);

			
		} else {
			p.fill(255);
		}

	}
	public void styleText() {
		
		Main p = Ap.p();
		
		p.fill(0);
		
		p.textSize(10);
		p.textAlign(PConstants.CENTER, PConstants.CENTER);
	}
	
	

}
