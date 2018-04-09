package track.large;

import main.Ap;
import main.DrawContext;
import main.Main;
import track.TAStraight;

public class TLLine implements TAStraight{
	
	public float dx, dy;
	TLNode from, to;
	public TLLine(TLNode from, TLNode to) {
		this.from = from;
		this.to= to;
		dx = from.x() - to.x();
		dy = from.y() - to.y();

		
	}
	@Override
	public void draw(DrawContext dc) {
		Main p = Ap.p();
		p.fill(0,0,0);
		
		p.stroke(0);
		if(dc.scrollStage >= 2) {
			p.strokeWeight(0.5F * dc.tc.db);
		} else {
			p.strokeWeight(0.75F * dc.tc.db);
		}
		p.pushStyle();
			p.fill(0xFF4E2D04);
			
			util.Transform.linetf(p,from.x(), from.y(),to.x(), to.y(), dc.tc);
			
		p.popStyle();
		// System.out.println(start.drawX() + " " +  start.drawY() + " " + end.drawX() + " " +  end.drawY());
		// Ap.p().line(10,10,10,20);
		
//		register(Ap.p().td);
	}
	

	/*
	float dist2_line_pt(float vx, float vy, float wx, float wy, float px, float py) {
		// tak'd from https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment  
		
		// Return minimum distance between line segment vw and point p
		
		// len of VW
		  float l2 = dist2(vx, vy, wx, wy);  // i.e. |w-v|^2 -  avoid a sqrt
		  if (l2 == 0.0) return dist2(px, py, vx, vy);   // v == w case
		  
		  // Consider the line extending the segment, parameterized as v + t (w - v).
		  // https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line#Vector_formulation
		  // We find projection of point p onto the line. 
		  // It falls where t = [(p-v) . (w-v)] / |w-v|^2
		  // We clamp t from [0,1] to handle points outside the segment vw.
		  
		  // pretend that v is the origin; that's why we subtract
		  float t = dot(px - vx, py-vy, wx - vx, wy-vy);
		  // dot product projects the point onto the WV line
		  
		  t = t / l2; 
		  t = util.Util.constrain(t, 0, 1);
		  // limit it so it can at most be at endpoitns
		  // think of it as the length from v
		  
		  float pjx = vx + t * (wx - vx);
		  float pjy = vy + t * (wy - vy);  // Projection falls on the segment
		  
		  // turn the length into a vector
		  
		  return dist2(px, py, pjx, pjy);
		}
	float dist2(float ax,float ay,float bx,float by) {
		return Math.abs(square(ax - bx) + square(ay - by));
	}
	float square(float x) {
		return x * x;
	}
	float dot(float ax, float ay, float bx, float by) {
		 return ax * bx + ay * by;
	}*/
	@Override
	public TLNode a() {
		return from;
	}
	@Override
	public TLNode b() {
		return to;
	}
	@Override
	public void drawSelectionHalo(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
		styleHalo(dc);
		if(dc.scrollStage >= 2) {
			p.strokeWeight(0.5F * dc.tc.db * 2);
		} else {
			p.strokeWeight(0.75F * dc.tc.db * 2);
		}
		util.Transform.linetf(p,from.x(), from.y(),to.x(), to.y(), dc.tc);
		p.popStyle();
		
	}
	
	
}
