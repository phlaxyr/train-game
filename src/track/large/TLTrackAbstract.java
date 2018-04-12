package track.large;

public abstract class TLTrackAbstract implements TLTrack{
	TLNode a, b;
	
	public TLTrackAbstract(TLNode a, TLNode b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public TLNode a() {
		return a;
	}

	@Override
	public TLNode b() {
		return b;
	}
	public String toString() {
		return this.getClass().getSimpleName() +"["+ a().toString() +","+ b().toString()+"]";
	}
}
