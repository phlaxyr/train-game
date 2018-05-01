package track.large;

import main.Ap;
import main.DrawContext;
import main.Main;
import processing.core.PMatrix;
import util.MapPos;


public class TLArc implements TLTrack1 {
	

	public double anglefrom;
	public float todx, tody = 0;
	public float centerx, centery, radius = 0; // TODO
	
	public PMatrix mx;
	
	TLNode from, to;
	
	public TLArc(TLNode from, TLNode to) {
		
		// double from_perp = -fromdx / fromdy;
		
		// angle of the `from` line
//		anglefrom = Math.atan(fromdy/fromdx);
//		this.todx = todx;
//		this.tody = tody;
		// if the slope is negative, then it will be counterclockwise; correct
		// if the slope is positive, then it will be clockwise; correct
		Main p = Ap.p();
		p.pushMatrix();
			p.translate(from.x(), from.y()); // rebase the origin to `from`
			// p.rotate((float) anglefrom); // rotate by the angle of `from`
			mx = Ap.p().getMatrix();
		p.popMatrix();
		// slopes
		// f(x) = b + m (x - a), where (a,b) is the location of the point, m is slope
//		register(Ap.p().td);
		
	}

	@Override
	public void draw(DrawContext dc) {
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
	
	
	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		float d2pt_to_center = square(x-centerx)+square(y-centery);
		float d2min = square(radius - tolerance(dc));
		float d2max = square(radius + tolerance(dc));
		
		return d2min < d2pt_to_center && d2pt_to_center < d2max;
	}
	private float square(float in) {return in*in;}
	@Override
	public TLNode a() {
		return from;
	}

	@Override
	public TLNode b() {
		return to;
	}

	@Override
	public float tolerance(DrawContext dc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drawSelectionHalo(DrawContext dc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float distance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MapPos posAt(float distance) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
