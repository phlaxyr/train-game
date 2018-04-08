package track.large;

import track.PObjectSelectable;

/**
 * Connects a and b
 * 
 *
 */
public interface TLTrack extends PObjectSelectable{
	public TLNode a();
	public TLNode b();
	
	public TLTrack autoAttach();
	
	public default TLNode otherNode(TLNode n) {
		if(a().equals(n)) return b();
		if(b().equals(n)) return a();
		throw new IllegalArgumentException("That TLNode is not attached to this TLTrack "
				+ "(perhaps you have 2 nodes in the same spot?)");
	}
	
	
	
}
