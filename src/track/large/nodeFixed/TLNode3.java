package track.large.nodeFixed;

import track.large.TLArc;
import track.large.TLLine;

public class TLNode3 extends TLNodeFixed{
	
	private TLLine higher, lower;
	private TLArc arc;
	public TLNode3(float x, float y) {
		super(x, y, 3);
		
	}
	
	
	

	
	public void setHigher(TLLine t) {
		higher = t;
		set(t, 0);
	}
	
	public void setLower(TLLine t) {
		lower = t;
		set(t, 1);
	}
	public void setArc(TLArc t) {
		arc = t;
		set(t, 2);
	}





	public TLLine getHigher() {
		return higher;
	}

	public TLLine getLower() {
		return lower;
	}

	public TLArc getArc() {
		return arc;
	}

}
