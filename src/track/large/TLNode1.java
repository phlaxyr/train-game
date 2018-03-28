package track.large;

public class TLNode1 extends TLNodeAbstract implements TLNodeIndexed{

	TLTrack t;
	public TLNode1(float x, float y) {
		super(x, y);
		
	}
	public void attachTrack(TLTrack t, int i) {
		if(i != 0) throw new IllegalArgumentException("index must be 0");
		this.t = t;
	}
	public TLTrack getTrack(int i) {
		if(i != 0) throw new IllegalArgumentException("index must be 0");
		return t;
	}
	public TLTrack track1() {
		return t;
	}

}
