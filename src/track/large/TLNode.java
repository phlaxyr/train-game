package track.large;

public interface TLNode {
	
	public float x();
	public float y();
	public default boolean isBefore(TLNode n) {
		return !isAfter(n);
	}
	public default boolean isAfter(TLNode n) {
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
}
