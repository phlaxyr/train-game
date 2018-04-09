package track;

import java.util.List;

import track.large.TLNode;
import track.large.TLTrack;

public class TRider {
	public TLNode destination;
	public List<TLTrack> path;
	
	
	public void setDestination(TLNode destination, List<TLNode> nodes, List<TLTrack> edges) {
		this.destination = destination;
		
		// my attempt at implementing dijkstra's algorithm
		
	}
}
