package util;
import main.Main;

public interface Transform {
	
	
	
	public static void linetf(Main m, float x, float y, float a, float b, float dilateby) {
		m.line(x * dilateby, y * dilateby, a * dilateby, b * dilateby);
	}
	public static void circletf(Main m, float x, float y, float a, float b, float db) {
		// if(Ap.p().getGraphics().ellipseMode == PConstants.CORNER) {
		m.ellipse(x * db, y * db, a * db, b * db);
		// afaik this works with all ellipsemodes
//		} else {
//			throw new UnsupportedOperationException("Non-`CORNER` ellipseMode not implemented yet");
//		}
	}
	public static void recttf(Main m, float x, float y, float a, float b, float db) {
		m.rect(x * db, y * db, a * db, b * db);
	}
}
