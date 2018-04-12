package track;

public interface PObjectRidable extends PObjectSelectable{
	public float distance();
	public default void onTick(TRider rider) {}
	public Pos posAt(float distance);
	/**
	 * returns the ridable to ride on exit;
	 * on default gets the default path
	 * 
	 * @param r
	 * @return
	 */
	public default PObjectRidable exit(TRider r) {
		r.distst -= distance();
		return r.iteratePath();
	}
	public void enter(TRider r);
}
