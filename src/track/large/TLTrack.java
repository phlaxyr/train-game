package track.large;

import main.DrawContext;

import track.PObjectSelectable;


public interface TLTrack extends PObjectSelectable{
	/*
	public TLNode from, to;
	
	public TLTrack(TLNode from, TLNode to) {
		
		this.from = from;
		
		
		this.to = to;
		
		// auto set
		
	}*/
	public TLNode from();
	public TLNode to();
	/**
	 * Use carefully; for instance, if the index is important, then be sure of the order.
	 * From is attached before to.
	 * Returns this for chaining.
	 */
	public default TLTrack autoAttach() {
		from().attach(this);
		to().attach(this);
		return this;
	}
	
	@Override
	public abstract void draw(DrawContext dc);
	
	@Override
	public abstract boolean isWithinBounds(float x, float y, DrawContext dc);
	
	public default TLNode otherNode(TLNode n) {
		if(from().equals(n)) return to();
		if(to().equals(n)) return from();
		throw new IllegalArgumentException("That TLNode is not attached to this TLTrack "
				+ "(perhaps you have 2 nodes in the same spot?)");
	}
	
}
