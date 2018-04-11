package util;

public class Util {
	public static float constrain(float in, float min, float max) {
		
		    return (in > max) ? max : (in < min ? min:in );
		
	}
	public static void println(Object...objects ) {
		for(Object o : objects) {
			System.out.print(o);
			System.out.print(", ");
		}
		System.out.println();
	}
	
}
