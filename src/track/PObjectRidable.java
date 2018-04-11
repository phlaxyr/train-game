package track;

public interface PObjectRidable extends PObjectSelectable{
	public float distance();
	public default void onTick(TRider rider) {}
	public Pos posAt(float distance);
	public PObjectRidable onSurpass(TRider r);
}
