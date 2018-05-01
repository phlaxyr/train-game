package track.large;

public interface TLNodeMutable extends TLNode {
	public void calculate();
	public void setX(float x);
	public void setY(float y);
	public default void setXY(float x, float y) {
		setX(x);
		setY(y);
	}
}
