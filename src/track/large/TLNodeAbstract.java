package track.large;

public class TLNodeAbstract implements TLNode{
	private float pvx, pvy;
	
	public TLNodeAbstract(float x, float y) {
		this.pvx = x;
		this.pvy = y;
	}

	@Override
	public float x() {
		return pvx;
	}

	@Override
	public float y() {
		return pvy;
	}
}
