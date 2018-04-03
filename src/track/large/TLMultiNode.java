package track.large;

import main.DrawContext;

public class TLMultiNode extends TLNodeAbstract{

	public TLMultiNode(float x, float y) {
		super(x, y);
		
	}

	@Override
	public void attach(TLTrack t) {
		all.add(t);
		addToHigherLower(t);
	}

	@Override
	public float tolerance(DrawContext dc) {
		return 0;
	}
	@Override
	public void detach(TLTrack t) {
		all.remove(t);
		higher.remove(t);
		lower.remove(t);
	}

	


}
