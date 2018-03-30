package track.large;

/**
 * Simply connects 2 tracks
 * 
 *
 */
public class TLNode2 extends TLNodeAbstract{
	public TLNode2(float x, float y) {
		super(x, y, 2);
		
	}
	
	public TLTrack track1() {
		return all.get(0);
	}
	public TLTrack track2() {
		return all.get(1);
		
	}
	public void set1(TLTrack t) {
		set(t, 0);
	}
	public void set2(TLTrack t) {
		set(t, 1);
	}
	
	

}
