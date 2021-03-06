package track.large;

import main.Ap;
import main.DrawContext;
import main.Main;
import track.PSelectable;

/**
 * Connects a and b
 * 
 *
 */
public interface TLTrack extends PSelectable{
	public TLNode a();
	public TLNode b();
	
	public TLTrack autoAttach();
	
	public default TLNode otherNode(TLNode n) {
		if(a().equals(n)) return b();
		if(b().equals(n)) return a();
		throw new IllegalArgumentException("That TLNode is not attached to this TLTrack "
				+ "(perhaps you have 2 nodes in the same spot?)");
	}
	
	public default void styleHalo(DrawContext dc) {
		Main p = Ap.p();
		p.stroke(255, 255, 0);
	}
	
	
	public float distance();
	


}
