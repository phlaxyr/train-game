package track.large;

import java.util.List;

import main.Ap;
import main.DrawContext;
import main.Main;
import processing.core.PConstants;

public interface TLNode {
	
	
	public float x();
	public float y();
	public List<TLTrack> higher();
	public List<TLTrack> lower();
	

	
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
	
	public void attach(TLTrack t);
	
	
	public default void draw(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
//		p.fill(0, 255, 0);
//		p.stroke(0, 128, 0);
		
		p.strokeWeight(0.5F * dc.tc.db);
		p.ellipseMode(PConstants.CENTER);
		util.Transform.circletf(Ap.p(), x(), y(), 0.5F, 0.5F, dc.tc);
		p.popStyle();
	}
}
