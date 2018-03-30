package track.large;

import java.util.ArrayList;

import java.util.List;

import main.Ap;
import main.Main;
import processing.core.PConstants;
import util.DrawContext;


public abstract class TLNodeAbstract implements TLNode{
	private float pvx, pvy;
	protected List<TLTrack> higher = new ArrayList<>();
	protected List<TLTrack> lower = new ArrayList<>();
	protected List<TLTrack> all;
	public TLNodeAbstract(float x, float y, int initIndices) {
		this.pvx = x;
		this.pvy = y;
		System.out.println(initIndices);
		all = new ArrayList<>(initIndices);
	}

	@Override
	public float x() {
		return pvx;
	}

	@Override
	public float y() {
		return pvy;
	}
	
	/**
	 * Must be called whenever something is set
	 * @param t
	 * @param i
	 */
	protected void set(TLTrack t, int i) {

		if(i >= all.size()) {
			
			while(i > all.size()) {
				all.add(null);
			} // ends at all.size() == i
			all.add(t); // all.size == i + 1; also, t is now at i position
			
			
		} else {
		
			TLTrack track = all.set(i, t); // track is the previous element
			if(track != null) {
				higher.remove(track);
				lower.remove(track);
			}
		}
		
		if(t.otherNode(this).isHigherThan(this)) {
			higher.add(t);
			
		}
		
		else lower.add(t);
		


		

	}
	
	@Override
	public void draw(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
		p.fill(0, 255, 0);
		p.stroke(0, 128, 0);
		
		p.strokeWeight(0.5F * dc.db);
		p.ellipseMode(PConstants.CENTER);
		util.Transform.circletf(Ap.p(), x(), y(), 0.5F, 0.5F, dc.db);
		p.popStyle();
	}
	
	int currentindex = 0;
	public void attach(TLTrack t) {
		set(t, currentindex++);
	}
	
	
	
	public List<TLTrack> higher() {return higher;}
	public List<TLTrack> lower() {return lower;}
	
	
	
}
