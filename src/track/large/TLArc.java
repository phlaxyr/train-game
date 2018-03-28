package track.large;

import processing.core.PMatrix;
import track.Ap;
import track.Main;
import util.DrawContext;

public class TLArc extends TLTrack {
	

	public final double anglefrom;
	public final float todx, tody;
	public PMatrix mx;
	
	
	
	public TLArc(TLNode from, TLNode to, float fromdx, float fromdy, float todx, float tody) {
		
		// double from_perp = -fromdx / fromdy;
		super(from, to);
		// angle of the `from` line
		anglefrom = Math.atan(fromdy/fromdx);
		this.todx = todx;
		this.tody = tody;
		// if the slope is negative, then it will be counterclockwise; correct
		// if the slope is positive, then it will be clockwise; correct
		Main p = Ap.p();
		p.pushMatrix();
			p.translate(from.x(), from.y()); // rebase the origin to `from`
			p.rotate((float) anglefrom); // rotate by the angle of `from`
			mx = Ap.p().getMatrix();
		p.popMatrix();
		// slopes
		// f(x) = b + m (x - a), where (a,b) is the location of the point, m is slope
		
		
	}

	@Override
	public void drawMap(DrawContext dc) {
		Main p = Ap.p();
		p.scale(1000); // scale to see if setmatrix overrides this
		/*
		p.pushMatrix(); // good thing that pushmatrix also takes transformations from under the stack
			p.translate(from.x, from.y); // rebase the origin to `from`
			p.rotate((float) anglefrom); // rotate by the angle of `from`
			
			PMatrix pm = p.getMatrix(); // rotation matrix
			
			if(tody == 0) // edge case, slope is infinite then
			
			PVector newFrom = pm.mult(new PVector(from.x, from.y), null);
			PVector newTo = pm.mult(new PVector(to.x, to.y), null);
		p.popMatrix();*/
		p.setMatrix(mx);
		
		
		
	}


	

}