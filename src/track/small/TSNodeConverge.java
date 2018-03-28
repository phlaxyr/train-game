package track.small;

import track.large.TLNode;

public class TSNodeConverge extends TSNode{
	public TSSegment merge1, merge2;
	public TSSegment next;
	public TSNodeConverge(TLNode lnode, TSSegment merge1, TSSegment merge2, TSSegment next) {
		super(lnode);
		this.merge1 = merge1;
		this.merge2 = merge2;
		this.next = next;
	}
	

	
	
}
