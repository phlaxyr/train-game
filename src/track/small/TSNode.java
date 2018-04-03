package track.small;

import main.DrawContext;
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


	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void draw(DrawContext dc) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public float tolerance(DrawContext dc) {
		return 0;
	}
	
}
