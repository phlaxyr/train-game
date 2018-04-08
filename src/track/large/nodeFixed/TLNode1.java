package track.large.nodeFixed;

import track.large.TLTrack;
import track.large.TLTrack1;

public class TLNode1 extends TLNodeFixed{

	
	public TLNode1(float x, float y) {
		super(x, y, 1);
		
	}

	public TLTrack track1() {
		return all.get(0);
	}
	public void set1(TLTrack1 t) {
		
		set(t, 0);
	}

	

}
