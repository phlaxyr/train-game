package track.large;

public interface TLNodeIndexed extends TLNode{
	public TLTrack getTrack(int index);
	public void attachTrack(TLTrack track, int index);
}
