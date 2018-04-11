package main;


import static main.GameStage.*;
import static main.OriginMode.*;
import static util.Transform.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import processing.core.PApplet;
import processing.event.MouseEvent;
import track.DijkstraManager;
import track.TRider;
import track.TrackManager;
import track.large.TLNode;
import track.large.TLTrack1;
import track.small.TSSegment;
import util.TransformContext;

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
	



	// Tester tester = new Tester();

	public void draw() {

		@SuppressWarnings("unused")
		OriginMode omode = DRAW_DEFAULT;
		background(255);
		strokeWeight(1);
		point(fromMouseX, fromMouseY);
		// tester.draw();
		
//		uid.draw();
		pushStyle();
		pushMatrix(); // so we can pop it and restore it to omode = DRAW_DEFAULT 
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
		
		DrawContext dc = drawContext();//new DrawContext(db,0-scrollLen);
		stm.draw(dc);
		float db = dc.tc.db;
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
				
				
				linetf(this, i * 10, -100, i * 10, 100, dc.tc);
				text (i * 10, i * 10 * db, 0);
				
				linetf(this, -100, j * 10, 100, j * 10, dc.tc);
				text(j * 10, 0, j * 10 * db);
				popStyle();
			}
		}
		
		
		td.drawLargeTracks(dc);
		
		for(TRider r : riders) {
			r.tick();
			r.draw();
		}
		
		popStyle();
		popMatrix();
		omode = DRAW_DEFAULT;
		uid.draw();
		
	}
	public TransformContext transformContext() {
		float db = (float)Math.pow(2, 0-scrollLen);
		
		return  new TransformContext(db);//,0-scrollLen);
	}
	public DrawContext drawContext() {
		return new DrawContext(0-scrollLen, transformContext());
	}
	public TrackManager td = new TrackManager();

	
	float centerX;
	float centerY;
	
	public UIDrawer uid;
	
	public List<TRider> riders = new ArrayList<>();
	
	public void setup() {
		
		if(Ap.p() == null) System.out.println("Ap.p() somehow is null");
		
		td.setupLarge();
		uid = new UIDrawer();
		TLNode origin = td.a;
		dij.recalculate(origin);
		List<TLTrack1> o = dij.getPathTracks(td.c);
		System.out.println("DJPATH "+o);
		riders.add(new TRider(o, td.a));
		riders.get(0).v = 1;
		// seg = new TSSegment(new Pos(10, 10), new Pos(10,20));
		// seg.setup(new DrawContext());
		

		centerX = this.width/ 2;
		centerY = this.height / 2;
		System.out.println(Arrays.toString(td.largeNodes.toArray()));
		System.out.println(Arrays.toString(td.largeTracks.toArray()));
		
	}
	int drawOriginX, drawOriginY, mOriginX, mOriginY; // map origin x/y
	int translateX, translateY, tlateTempX, tlateTempY, fromMouseX, fromMouseY; 
	int scrollLen = -2;
	// to control the mouse grabbing
	
	
	TSSegment seg;// = new TSegment();
	
	
	
	public void mousePressed(MouseEvent e) {
		uid.mousePressed(e.getX(), e.getY());
		if(stage == WORLDMAP) {
			
			fromMouseX = mouseX;
			fromMouseY = mouseY;
			
			td.onMousePress(e);
		}
	}
	public void mouseDragged(MouseEvent e) {
		if(stage == WORLDMAP) {
			
			tlateTempX = (fromMouseX - mouseX) ;
			tlateTempY = (fromMouseY - mouseY) ;
			
		}
	}
	public void mouseReleased() {
		uid.mouseReleased();
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
	
	public SelectToolManager stm = new SelectToolManager();
	public DijkstraManager dij = new DijkstraManager();
}
