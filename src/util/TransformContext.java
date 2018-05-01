package util;

public class TransformContext {

	/**
	 * larger = more zoom
	 */
	public float db;
	/**
	 * Translatex
	 */
	public float tlx;
	/**
	 * translatey
	 */
	public float tly;
	
	public TransformContext() {
		
	}

	public TransformContext(float db, float translatex, float translatey) {
		this.db = db;
		this.tlx = translatex;
		this.tly = translatey;
	}
	
	/**
	 * The output of mouseEvent where transformations are not considered
	 * @param pos
	 * @return
	 */
	public MapPos mouseToMap(ScreenPos pos) {
		return mouseToMap(pos.x, pos.y);
	}

	public MapPos mouseToMap(float x, float y) {
		return new MapPos((x - tlx)/db, (y - tly)/db);
	}
	
//	public ScreenPos toScreen(MapPos pos) {
//		return new ScreenPos((pos.x + tlx)*db, (pos.y + tly)*db);
//	}
	

	
}
