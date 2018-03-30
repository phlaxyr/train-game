package main;


import static main.GameStage.*;

import static util.Transform.*;

import static main.OriginMode.*;

import processing.core.PApplet;
import processing.event.MouseEvent;
import track.TrackDrawer;
import track.large.TLLine;
import track.large.TLNode1;
import track.small.TSSegment;
import util.DrawContext;

public class Main extends PApplet {

	public static void setMain(Main p) {
		if (Ap.ap != null) {
			throw new IllegalStateException("two applets have been generated");
		}
		Ap.ap = p;
	}

	public static void main(String[] args) {

		PApplet.main("main.Main");
		
	}

	public void settings() {
		setMain(this);
		size(800,450);
	}
	
	public float toMapX(float x, OriginMode fromMode) {
		float rt = x;
		
		if(fromMode == DRAW_DEFAULT) {
			
			rt -= centerX;
		}
		if(fromMode != MAP_CENTER) {
			rt -= mOriginX;
		}
		return rt / getContext().db;
	}
	public float toMapY(float y, OriginMode fromMode) {
		float rt = y;
		if(fromMode == DRAW_DEFAULT) {
			rt -= centerY;
		}
		if(fromMode != MAP_CENTER) {
			rt -= mOriginY;
		}
		return rt / getContext().db;
	}



	// Tester tester = new Tester();

	public void draw() {
		OriginMode omode = DRAW_DEFAULT;
		background(255);
		strokeWeight(1);
		point(fromMouseX, fromMouseY);
		// tester.draw();
		
		
		
		// the origin is at DRAW DEFAULT (UP LEFT CORNER)
		
		translate(centerX, centerY);
		omode = DRAW_CENTER;
		// the origin is at DRAW CENTERED
		
		pushStyle();
			rectMode(CENTER);
			rect(0,0,2,2);
		popStyle();
		
		
		mOriginX = translateX + tlateTempX;
		mOriginY = translateY + tlateTempY;
		
		
		translate(mOriginX, mOriginY);
		omode = MAP_CENTER;
	// the origin is at MAP CENTERED
		//float db = (float)Math.pow(2, 0-scrollLen);
		
		DrawContext dc = getContext();//new DrawContext(db,0-scrollLen);
		float db = dc.db;
//		System.out.println("--DC--");
//		System.out.println("db "+dc.db);
//		System.out.println("scrollStage "+dc.scrollStage);
//		System.out.println("\\-DC--");
		
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

				linetf(this, i * 10, -100, i * 10, 100, db);
				text (i * 10, i * 10 * db, 0);
				
				linetf(this, -100, j * 10, 100, j * 10, db);
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
		
		
		td.drawLargeTracks(dc);
		
	}
	public DrawContext getContext() {
		float db = (float)Math.pow(2, 0-scrollLen);
		
		return  new DrawContext(db,0-scrollLen);
	}
	TrackDrawer td = new TrackDrawer();
	float centerX;
	float centerY;
	
	public void setup() {
		if(Ap.p() == null) System.out.println("nullapp");
		
		a = new TLNode1(10,10);
		b = new TLNode1(10,20);
		// seg = new TSSegment(new Pos(10, 10), new Pos(10,20));
		// seg.setup(new DrawContext());
		large = (TLLine) new TLLine(a, b).autoAttach();
		td.registerTLNodes(a);
		td.registerTLNodes(b);
		centerX = this.width/ 2;
		centerY = this.height / 2;
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
			DrawContext dc = getContext();
			float mMouseX =  toMapX(mouseX, OriginMode.DRAW_DEFAULT);
			float mMouseY =  toMapY(mouseY, OriginMode.DRAW_DEFAULT);
			
			// recttf(this, mMouseX, mMouseY, 1, 1, dc.db);
			
			System.out.println("mMouseX " + mMouseX);
			System.out.println("mMouseY " + mMouseY);
			System.out.println("large: "+large.isWithinBounds(mMouseX, mMouseY, dc));
			
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
		scrollLen = /*
			scrollLen < -3 ? -3 :
			scrollLen > 3 ? 3 : scrollLen;*/
				constrain(scrollLen, -3, 3);
		
		
	}
	public GameStage stage = WORLDMAP;
	


}
