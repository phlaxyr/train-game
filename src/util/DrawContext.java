package util;

public class DrawContext {

	/**
	 * larger = more zoom
	 */
	public float db;
	/**
	 * larger = more zoom
	 */
	public int scrollStage;
	public DrawContext() {
		
	}

	public DrawContext(float db, int scrollStage) {

		this.db = db;
		this.scrollStage = scrollStage;
	}

	
}
