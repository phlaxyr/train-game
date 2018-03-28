package util;
import track.Ap;

public interface Transform {
	
	
	
	public default void linetf(float x, float y, float a, float b, float dilateby) {
		Ap.p().line(x * dilateby, y * dilateby, a * dilateby, b * dilateby);
	}
}
