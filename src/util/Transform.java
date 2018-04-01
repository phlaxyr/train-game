package util;
import main.Main;

public interface Transform {
	
	
	
	public static void linetf(Main m, float x, float y, float a, float b, TransformContext dc) {
		m.line(x * dc.db, y * dc.db, a * dc.db, b * dc.db);
	}
	public static void circletf(Main m, float x, float y, float a, float b, TransformContext dc) {
		// if(Ap.p().getGraphics().ellipseMode == PConstants.CORNER) {
		m.ellipse(x * dc.db, y * dc.db, a * dc.db, b * dc.db);
		// afaik this works with all ellipsemodes
//		} else {
//			throw new UnsupportedOperationException("Non-`CORNER` ellipseMode not implemented yet");
//		}
	}
	public static void recttf(Main m, float x, float y, float a, float b, TransformContext dc) {
		m.rect(x * dc.db, y * dc.db, a * dc.db, b * dc.db);
	}
}
