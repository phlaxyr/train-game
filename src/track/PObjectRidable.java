package track;

public interface PObjectRidable extends PObjectSelectable{
	public float distance();
	public default void onTick(TRider rider) {}
	public Pos posAt(float distance);

	public default void exit(TRider r) {
		r.distst -= distance();
		
	}
	public default boolean shouldExit(TRider r) {
		return r.distst >= distance();
	}
	public default PObjectRidable nextRidable(TRider r) {
		return r.iteratePath();
	}
	public void enter(TRider r);
}
