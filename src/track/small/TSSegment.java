package track.small;

import main.Ap;
import main.Main;
import processing.core.PApplet;
import render.Element;
import track.Pos;
import util.DrawContext;

public class TSSegment extends Element{
	
	public Pos start, end;
	// PImage img; 
	public TSSegment(Pos start, Pos end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public void setup(DrawContext dc) {
		 // img = Ap.p().loadImage("art.png");
	}
	@Override
	public void drawMap(DrawContext dc) {
		Main p = Ap.p();
		p.fill(0,0,0);
		
		p.stroke(0);
		p.strokeWeight(0.1F);
		p.pushStyle();
			p.fill(0xFF4E2D04);
			util.Transform.linetf(p,start.x, start.y,end.x, end.y, dc.db);
		p.popStyle();
		// System.out.println(start.drawX() + " " +  start.drawY() + " " + end.drawX() + " " +  end.drawY());
		// Ap.p().line(10,10,10,20);
		
		
	}
	
	
	public void modes() {
		// Ap.p().scale(10);
		// Ap.p().rotate(45);
		Ap.p().rectMode( PApplet.CORNER);
		// Ap.p().noStroke();
	}

	@Override
	public boolean isWithin(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	
//	
//	Ap.p().fill(255,255,255);
//	
//	Ap.p().rect(0, 0, 32, 32);
//	Ap.p().fill(0xFF4E2D04); // the woods
//	for(int i=0; i< 4; i++) { // 4 rects
//		
//		Ap.p().rect(i * 8 + 2, 0, 3, 32);
//	}
//	
//	Ap.p().fill(0xFF545454);
//	
//	Ap.p().rect(0, 6, 32, 4); 
//	// ys 0 to 5 is blank ; len 6
//	// 6 to 9 is rail ; len 4
//	// 10 - 21 is empty; len 12
//	// 22 - 25 is rail; len 4
//	// 26 to 31 is blank; len 6
//	
//	Ap.p().rect(0, 22, 32, 4);
	// Ap.p().quad(10, 10, 20, 10, 30, 30, 0, 30); // parallelogram
}
