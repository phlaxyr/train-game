package track.large;

import track.PObjectRidable;
import track.TRider;

/**
 * connects a and b as an arrow
 *
 */
public interface TLTrack1 extends TLTrack, PObjectRidable{
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
		a().attach1(this);
		b().attach1(this);
		return this;
	}
	
	
	@Override
	public default PObjectRidable nextRidable(TRider r) {
		if(r.isDestination(to())) return to();
		return r.iteratePath();
	}
	@Override
	public default void enter(TRider r) {}
	
}
