package track;

import util.MapPos;

public interface PRideable extends PSelectable{
	public float distance();
	public default void onTick(TRider rider) {}
	public MapPos posAt(float distance);

	public default void exit(TRider r) {
		r.distst -= distance();
		
	}
	public default boolean shouldExit(TRider r) {
		return r.distst >= distance();
	}
	public default PRideable nextRidable(TRider r) {
		return r.iteratePath();
	}
	public void enter(TRider r);
}
