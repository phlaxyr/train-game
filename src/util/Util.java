package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	public static float constrain(float in, float min, float max) {
		
		    return (in > max) ? max : (in < min ? min:in );
		
	}
	
}
