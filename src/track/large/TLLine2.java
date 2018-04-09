package track.large;

import main.DrawContext;

/**
 * This is symmetric
 * @author carlw_000
 *
 */
public class TLLine2 extends TLTrack2Abstract<TLLine>{

	public TLLine2(TLNode a, TLNode b) {
		super(new TLLine(a, b), new TLLine(b, a));
		
	}

	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		return ab.isWithinBounds(x, y, dc);
	}

	@Override
	public float tolerance(DrawContext dc) {
		return ab.tolerance(dc);
	}

	@Override
	public void draw(DrawContext dc) {
		ab().draw(dc);
	}

	@Override
	public void drawSelectionHalo(DrawContext dc) {
		ab.drawSelectionHalo(dc);
	}

	@Override
	public float distance() {
		return ab().distance();
	}

	
}
