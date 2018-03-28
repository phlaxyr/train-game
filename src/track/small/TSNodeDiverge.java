package track.small;

import track.large.TLNode;

public class TSNodeDiverge extends TSNode{
	public TSSegment prev;
	public TSSegment branch1, branch2;

	public TSNodeDiverge(TLNode lnode, TSSegment prev, TSSegment branch1, TSSegment branch2) {
		super(lnode);
		this.prev = prev;
		this.branch1 = branch1;
		this.branch2 = branch2;
	}


}
