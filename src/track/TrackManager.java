package track;

import java.util.ArrayList;

import java.util.List;

import main.Ap;
import main.DrawContext;
import main.LargeMap;
import main.OriginMode;
import processing.event.MouseEvent;
import track.large.TLLine;
import track.large.TLNode;
import track.large.TLNode1;
import track.large.TLNode2;
import track.large.TLTrack;
import track.small.TSNode;


public class TrackManager {
	public void drawLargeTracks(DrawContext dc) {
		
		for(TLNode node : largeNodes) { // start at the highest

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
	
	private final List<TLNode> largeNodes = new ArrayList<>();
	/**
	 * Must be registered in order
	 * high to low
	 * @param node
	 * 
	 * @return
	 * returns the in node for chaining
	 */
	public <L extends TLNode> L register(L node) {
		

		// size check
		int s = largeNodes.size();
		if(s != 0) {
			TLNode before = largeNodes.get(s - 1);
			if(before.isLowerThan(node)) {
				throw new IllegalArgumentException("registerTLNOde did not place it in order!");
			}
		}
		largeNodes.add(node);
		return node;
		
		
	}
	public <S extends TSNode> S register(S node) {
		// TODO
		return null;
	}
	public TLNode getLargeNode(int index) {
		return largeNodes.get(index);
	}
	public TLNode1 a, c, d;
	public TLNode2 b;
	public TLLine ab, bc;
	/**
	 * sets up large nodes and tracks
	 */
	public void setupLarge() {
		a = register(new TLNode1(10,10));
		b = register(new TLNode2(10,20));
//		TLNode1 error = register(new TLNode1(10,10));
//		TLNode1 error = register(new TLNode1(10,20));
		c = register(new TLNode1(5, 25)); // should be ok
		
		
		ab = (TLLine) new TLLine(a, b).autoAttach();
		bc = (TLLine) new TLLine(b, c).autoAttach();
	}
	public void onMousePress(MouseEvent e) {
		float mMouseX =  LargeMap.toMapX(Ap.p(),e.getX(), OriginMode.DRAW_DEFAULT);
		float mMouseY =  LargeMap.toMapY(Ap.p(),e.getY(), OriginMode.DRAW_DEFAULT);
		
		// recttf(this, mMouseX, mMouseY, 1, 1, dc.db);
		
		System.out.println("mMouseX " + mMouseX);
		System.out.println("mMouseY " + mMouseY);
		System.out.println("ab: "+ab.isWithinBounds(mMouseX, mMouseY, Ap.p().drawContext()));
		System.out.println("bc: "+bc.isWithinBounds(mMouseX, mMouseY, Ap.p().drawContext()));
		
	}
}
