package track;

import java.util.ArrayList;
import java.util.List;

import main.Ap;
import track.large.TLNode;
import track.large.TLTrack;
import track.large.TLTrack1;
import util.MapPos;

public class TRider {
	public TLNode finaldest;
	public List<TLTrack1> path;
	
	public List<TLNode> dests = new ArrayList<>();
	
	int index = 0;
	
	public PRideable con;
	
	/**
	 * Sub track distance
	 */
	public float distst;
	public float v, a;
	
	
	
	public TRider(List<TLTrack1> path, PRideable con) {
		
		setPath(path);
//		updateDest();
		this.con = con;
		distst = v = a = 0;
		index = 0;
	}

	public PRideable iteratePath() {
		if(path == null) System.out.println("Null path");
		return path.get(index++);
	}
	
//	public void setDestination(TLNode destination, List<TLNode> nodes, List<TLTrack> edges) {
//		this.destination = destination;
//		
//		
//	}
//	
	/**
	 * The path after the node following the destination
	 * Does not include the current track
	 * @param path
	 */
	public void setPath(List<TLTrack1> path) {
		this.path = path;
		
		updateDest();
		
		
	}
	private void updateDest() {
		TLTrack1 t = getLast(path);
		finaldest = (t == null ? null : t.to());
		dests.add(finaldest);
	}
	private <T> T getLast(List<T> list) {
		return list == null ? null : list.size() == 0 ? null : list.get(list.size() - 1);
	}
	
	/**
	 * The path after the node following the destination
	 */
	public void appendPath(List<TLTrack1> add) {
		this.path.addAll(add); // o(n)
		updateDest();
	}
	
	public void onReachNode(TLNode node) {
		if(node.equals(finaldest)) {
			onReachDestination(node);
		} else {
			con = path.get(index++); // eh, i'll use an iterator later
			distst -= con.distance();
		}
	}
	public void onReachDestination(TLNode dest) {
		dests.remove(dest);
		if(isFinalDestination(dest)) {
			
			 System.out.println( "Reached final destination; resetting!");
			 
			finaldest = null;
			index = 0;
			path = new ArrayList<>();
			dests = new ArrayList<>();
		}
	}
	
	public boolean isDestination(TLNode node) {
		return dests.contains(node);
	}
	public boolean isFinalDestination(TLNode node) {
		return finaldest.equals(node);
	}
	
	public void tick() {
		
		con.onTick(this);
		// dist, velocity update
		v += a;
		distst += v;

		
		if(con.shouldExit(this)) { // exceeds the ctrack distance
			// surpassed the node
			con.exit(this);
			con = con.nextRidable(this);
			con.enter(this);
			
		}
		if(distst >= con.distance()) {
			//idk
		}
		
		
		
	}
	public void draw() {
		MapPos p = con.posAt(distst);
		Ap.p().fill(128, 128, 0);
		util.Transform.circletf(Ap.p(), p.x, p.y, 2F, 2F, Ap.p().transformContext());
	}
	
}
