package track.large;

import main.DrawContext;

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


}
