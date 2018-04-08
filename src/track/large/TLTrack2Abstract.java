package track.large;

public abstract class TLTrack2Abstract<T extends TLTrack1> extends TLTrackAbstract implements TLTrack2{
	
	T ab, ba;
	public TLTrack2Abstract(T ab, T ba) {
		super(ab.a(), ab.b());
		this.ab = ab;
		this.ba = ba;
	}

	@Override
	public T ab() {
		return ab;
	}

	@Override
	public T ba() {
		return ba;
	}

}
