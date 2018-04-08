package track.large;

import java.util.List;

import main.Ap;
import main.DrawContext;
import main.Main;
import processing.core.PConstants;
import track.PObjectSelectable;

public interface TLNode extends PObjectSelectable{
	
	
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
	public default void draw(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
//		p.fill(0, 255, 0);
//		p.stroke(0, 128, 0);
		
		p.strokeWeight(0.5F * dc.tc.db);
		p.ellipseMode(PConstants.CENTER);
		util.Transform.circletf(Ap.p(), x(), y(), radius(), radius(), dc.tc);
		p.popStyle();
	}
	public default float radius() {
		return 0.5F;
	}
}
