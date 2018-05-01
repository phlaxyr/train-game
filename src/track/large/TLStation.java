package track.large;

import main.Ap;
import main.DrawContext;
import processing.core.PConstants;
import util.MapPos;

public class TLStation extends TLMultiNode implements TLNodeMutable{

	public String name;
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
	@Override
	public void calculate() {
		
	}
	@Override
	public void setX(float x) {
		this.pvx = x;
	}
	@Override
	public void setY(float y) {
		this.pvy = y;
	}
	public void setXY(MapPos mousePos) {
		setXY(mousePos.x, mousePos.y);
		
	}
}
