package track.large;

/**
 * connects a and b as an arrow
 *
 */
public interface TLTrack1 extends TLTrack {
	public default TLNode from() {
		return a();
	}
	public default TLNode to() {
		return b();
	}
	/*
	public TLNode from, to;
	
	public TLTrack(TLNode from, TLNode to) {
		
		this.from = from;
		
		
		this.to = to;
		
		// auto set
		
	}*/
	
	/**
	 * Use carefully; for instance, if the index is important, then be sure of the order.
	 * From is attached before to.
	 * Returns this for chaining.
	 */
	public default TLTrack1 autoAttach() {
		a().attach(this);
		b().attach(this);
		return this;
	}
	

	
	
	
}
