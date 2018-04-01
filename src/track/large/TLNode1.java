package track.large;

import main.Ap;
import main.DrawContext;
import main.Main;

public class TLNode1 extends TLNodeAbstract{

	
	public TLNode1(float x, float y) {
		super(x, y, 1);
		
	}

	public TLTrack track1() {
		return all.get(0);
	}
	public void set1(TLTrack t) {
		
		set(t, 0);
	}

	

}
