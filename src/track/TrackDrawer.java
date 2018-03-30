package track;

import java.util.ArrayList;
import java.util.List;

import track.large.TLNode;
import track.large.TLTrack;
import util.DrawContext;

public class TrackDrawer {
	public void drawLargeTracks(DrawContext dc) {
		
		for(TLNode node : large) { // start at the highest

			for(TLTrack track : node.lower()) {
				
//				System.out.printf("%f%f%f%f", track.from.x(),track.from.y(),
//						track.to.x(),track.to.y());
//				System.out.println();
				track.draw(dc);
			}
			node.draw(dc); // this means nodes are always drawn on top
			// since we draw nodes up to lower, we will not need to worry about an undrawn track above
		}
	}
	
	private final List<TLNode> large = new ArrayList<>();
	/**
	 * Must be registered in order
	 * high to low
	 * @param node
	 */
	public void registerTLNodes(TLNode node) {
		

		// size check
		int s = large.size();
		if(s != 0) {
			TLNode before = large.get(s - 1);
			if(before.isLowerThan(node)) {
				throw new IllegalArgumentException("registerTLNOde did not place it in order!");
			}
		}
		large.add(node);
		
		
	}
	public TLNode getLargeNode(int index) {
		return large.get(index);
	}
}
