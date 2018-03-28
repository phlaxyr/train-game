package track;


import static track.GameStage.*;

import processing.core.PApplet;
import processing.event.MouseEvent;
import track.large.TLLine;
import track.large.TLNode1;
import track.small.TSSegment;
import util.DrawContext;
import util.Transform;
public class Main extends PApplet implements Transform{

	public static void setMain(Main p) {
		if (Ap.ap != null) {
			throw new IllegalStateException("two applets have been generated");
		}
		Ap.ap = p;
	}

	public static void main(String[] args) {

		PApplet.main("track.Main");
		
	}

	public void settings() {
		setMain(this);
		size(800,450);
	}
	

	// Tester tester = new Tester();

	public void draw() {
		background(255);
		strokeWeight(1);
		point(fromMouseX, fromMouseY);
		// tester.draw();
		
		int centerX = this.width / 2;
		int centerY = this.height / 2;
		
		// the origin is at DRAW DEFAULT (UP LEFT CORNER)
		
		translate(centerX, centerY);
		// the origin is at DRAW CENTERED
		
		pushStyle();
			rectMode(CENTER);
			rect(0,0,2,2);
		popStyle();
		
		
		mOriginX = translateX + tlateTempX;
		mOriginY = translateY + tlateTempY;
		translate(centerX + mOriginX, centerY + mOriginY);
		
		// the origin is at MAP CENTERED
		float db = (float)Math.pow(2, 0-scrollLen);
		
		DrawContext dc = new DrawContext(0, 0, db);
		
		
		fill(100,40,30);
		// rect(0,0,10,10);
		rect(0,0,10 * db,db);
		
		// a grid
		for(int i=-10;i<=10;i++) { // x
			for(int j=-10; j<=10;j++) { // y
				
				pushStyle();
				fill(0,0,0,10);
				stroke(0, 10);
				textSize(db * 2);

				linetf(i * 10, -100, i * 10, 100, db);
				text (i * 10, i * 10 * db, 0);
				
				linetf(-100, j * 10, 100, j * 10, db);
				text(j * 10, 0, j * 10 * db);
				popStyle();
			}
		}
		
		
		// how things are drawn:
		// 1st, place the nodes at their locations
		
		// the nodes shall contain a `prevs` TLTrack[] for previous tracks
		// and a `nexts` TLTrack[] for the next tracks
		
		// the `prevs` will contain every track whose nonself node is above
		// `nexts` will contain every track whose nonself node is below
		
		// if the nonself node is the same y as the self node:
			// if the nonself node is to the left of the self node then it's in `prev` 
			// if the nonself node is to the right, it's in 'next`
		
		
		// start at the leftest, uppermost node and work down (increase y)
		// if there are nodes with the same y then work left to right (increase x)
		
		
		
	}

	public void setup() {
		if(Ap.p() == null) System.out.println("nullapp");
		
		a = new TLNode1(10,10);
		b = new TLNode1(10,20);
		// seg = new TSSegment(new Pos(10, 10), new Pos(10,20));
		// seg.setup(new DrawContext());
		large = new TLLine(a, b);
	}
	int drawOriginX, drawOriginY, mOriginX, mOriginY; // map origin x/y
	int translateX, translateY, tlateTempX, tlateTempY, scrollLen, fromMouseX, fromMouseY; 
	// to control the mouse grabbing
	
	
	TSSegment seg;// = new TSegment();
	TLNode1 a, b;
	TLLine large;
	public void mousePressed() {
		if(stage == WORLDMAP) {
			
			fromMouseX = mouseX;
			fromMouseY = mouseY;
			

		}
	}
	public void mouseDragged(MouseEvent e) {
		if(stage == WORLDMAP) {
			
			tlateTempX = (fromMouseX - mouseX) ;
			tlateTempY = (fromMouseY - mouseY) ;
			
		}
	}
	public void mouseReleased() {
		if(stage == WORLDMAP) {
			
			translateX += tlateTempX;
			
			translateY += tlateTempY;
			
			
			fromMouseX = fromMouseY = tlateTempX = tlateTempY = 0;
		}
	}
	public void mouseWheel(MouseEvent e) {

		int i = e.getCount(); // 1 or -1
		scrollLen += i;
		scrollLen = 
			scrollLen < -3 ? -3 :
			scrollLen > 3 ? 3 : scrollLen;
		System.out.println(scrollLen);
		
	}
	public GameStage stage = WORLDMAP;
	


}
