package track.large;

import main.Ap;
import main.DrawContext;
import processing.core.PConstants;

public class TLStation extends TLMultiNode{

	String name;
	public TLStation(float x, float y, String name) {
		super(x, y);
		this.name = name;
	}
	@Override
	public void draw(DrawContext dc) {
		super.draw(dc);
		Ap.p().pushStyle();
		Ap.p().textSize(20F);
		Ap.p().textAlign(PConstants.CENTER, PConstants.CENTER);
		Ap.p().text(name, x() * dc.tc.db, y() * dc.tc.db);
		Ap.p().popStyle();
	}
	public String toString() {
		return this.getClass().getSimpleName() + ":" + name;
	}
}
