package track.large;

/**
 * Connects a and b like a 2-way highway
 * 
 *
 */
public interface TLTrack2 extends TLTrack{
	public TLTrack1 ab();
	public TLTrack1 ba();
	
	public default TLTrack2 autoAttach() {
		a().attach2(this);
		b().attach2(this);
		return this;
	}
	
}
