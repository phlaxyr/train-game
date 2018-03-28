package track;

import java.util.ArrayList;
import java.util.List;

import track.large.TLNode;

public class TrackDrawer {
	public void drawLargeTracks() {
		for(TLNode node : large) {
			
		}
	}
	
	private final List<TLNode> large = new ArrayList<>();
	public void addLargeNode(TLNode node) {
		

		// size check
		TLNode before = large.get(large.size() - 1);
		if(before.isAfter(node)) {
			throw new IllegalArgumentException("addLargeNode did not place it in order!");
		}
		large.add(node);
		
		
	}
	public void getLargeNode(int index) {
		
	}
}
