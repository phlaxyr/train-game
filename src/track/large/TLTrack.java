package track.large;

import util.DrawContext;

public abstract class TLTrack {
	public TLNode from, to;
	
	public TLTrack(TLNode from, TLNode to) {
		
		this.from = from;
		
		this.to = to;
	
	}
	public abstract void drawMap(DrawContext dc);
	
}
