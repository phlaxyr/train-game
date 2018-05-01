package track.large;

import java.util.List;

import main.Ap;
import main.DrawContext;
import main.Main;
import processing.core.PConstants;
import track.PRideable;
import track.TRider;
import util.MapPos;

public interface TLNode extends PRideable{
	
	
	public float x();
	public float y();
	public List<TLTrack> higher();
	public List<TLTrack> lower();
	
	// these ones MUST be directional
	public List<TLTrack1> outwards();
	public List<TLTrack1> inwards();
	
	/**
	 * A list of connections
	 * A 2-way highway would count as 1 connection
	 * @return
	 */
	public List<TLTrack> all();
	
	

	
	// the implementation for attaching the tracks will be up to subclasses
	
	public default boolean isHigherThan(TLNode n) {
		return !isLowerThan(n);
	}
	
	public default boolean isLowerThan(TLNode n) {
		if(y() > n.y()) { // if self.y is more than n; if self is below
			return true;
		}
		if(y() < n.y()) { // if self is above
			return false;
		}
		if(y() == n.y()) { // if self has same y
			if(x() > n.x()) { // if self is to right
				return true; 
			}
			if(x() < n.x()) { // if self is to left
				return false;
			}
			// only if x == x && y == y
			// TODO edge case
			
		}
		throw new IllegalArgumentException("TLNode n cannot be at the same position as this!");
		
	}
	
	/**
	 * This should not handle outwards inwards
	 * @param t
	 */
	public void attach(TLTrack t); // this should not handle outwards inwards
	
	public void attach1(TLTrack1 t);
	public void attach2(TLTrack2 t);
	
	public void detach(TLTrack t);
	
	public void detach1(TLTrack1 t);
	public void detach2(TLTrack2 t);
	public default void styleNode(DrawContext dc) {
		Main p = Ap.p();
		p.fill(0, 255, 0);
		p.stroke(0, 128, 0);
		p.strokeWeight(0.5F * dc.tc.db);
	}
	public default void styleHalo(DrawContext dc) {
		Main p = Ap.p();
		p.noStroke();
		p.fill(255, 255, 0);
	}
	public default void draw(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
//		p.fill(0, 255, 0);
//		p.stroke(0, 128, 0);
		styleNode(dc);

		p.ellipseMode(PConstants.CENTER);
		util.Transform.circletf(Ap.p(), x(), y(), radius(), radius(), dc.tc);
		p.popStyle();
	}
	@Override
	public default void drawSelectionHalo(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
		styleHalo(dc);
		util.Transform.circletf(Ap.p(), x(), y(), radius() * 4F, radius() * 4F, dc.tc);
		p.popStyle();
		
	}
	public default float radius() {
		return 0.5F;
	}
	public default float distance() {
		return 0;
	}
	public default MapPos posAt(float distance) {
		if(distance != distance()) throw new IllegalArgumentException("Tlnode distance must be 0");
		return new MapPos(x(), y());
	}

	@Override
	public default PRideable nextRidable(TRider r) {
		if(r.isDestination(this)) return this;
		return PRideable.super.nextRidable(r);
	}
	@Override
	public default void enter(TRider r) {
		if(r.isDestination(this)) {
//			System.out.println("Destination reached!");
			r.a = 0;
			r.v = 0;
			r.distst = 0;
		}
	}
	@Override
	public default boolean shouldExit(TRider r) {
		if(r.isDestination(this)) return false;
		return true;
	}
	
}
