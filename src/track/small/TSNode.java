package track.small;

import track.large.TLNode;

public class TSNode implements ITSNode {

	public TLNode lnode;
	
	
	public TSNode(TLNode lnode) {
		this.lnode = lnode;
	}


	@Override
	public TLNode largeNode() {
		return lnode;
	}
	
}
