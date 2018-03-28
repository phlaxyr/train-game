package track.large;

import track.Ap;
import track.Main;
import util.DrawContext;

public class TLLine extends TLTrack{
	
	public final float dx, dy;
	public final double slope;
	public TLLine(TLNode from, TLNode to) {
		super(from, to);
		dx = from.x() - to.x();
		dy = from.y() - to.y();
		slope = dx / dy;
		
	}
	@Override
	public void drawMap(DrawContext dc) {
		Main p = Ap.p();
		p.fill(0,0,0);
		
		p.stroke(0);
		p.strokeWeight(0.1F);
		p.pushStyle();
			p.fill(0xFF4E2D04);
			p.linetf(from.x(), from.y(),to.x(), to.y(), dc.db);
		p.popStyle();
		// System.out.println(start.drawX() + " " +  start.drawY() + " " + end.drawX() + " " +  end.drawY());
		// Ap.p().line(10,10,10,20);
		
		
	}
	
}
