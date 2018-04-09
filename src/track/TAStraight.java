package track;

import main.DrawContext;
import track.large.TLTrack1;

public interface TAStraight extends TLTrack1{
	@Override
	public default boolean isWithinBounds(float x, float y, DrawContext dc) {
		
		// System.out.println( dist2_line_pt(a().x(), a().y(), b().x(), b().y(), x, y));
		return dist2_line_pt(a().x(), a().y(), b().x(), b().y(), x, y) < square(tolerance(dc));
	}
	@Override
	public default float tolerance(DrawContext dc) {

		return 1.5F;
	}

	public default float dist2_line_pt(float vx, float vy, float wx, float wy, float px, float py) {
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
	public static float dist2(float ax,float ay,float bx,float by) {
		return Math.abs(square(ax - bx) + square(ay - by));
	}
	public static float square(float x) {
		return x * x;
	}
	public static float dot(float ax, float ay, float bx, float by) {
		 return ax * bx + ay * by;
	}
}
