package track.large.nodeFixed;

import java.util.Arrays;

import main.DrawContext;
import track.large.TLNodeAbstract;
import track.large.TLTrack;

public class TLNodeFixed extends TLNodeAbstract{
	public final int size;
	public TLNodeFixed(float x, float y, int size) {
		super(x, y);
		this.size = size;
		all = Arrays.asList(new TLTrack[size]);
	}
	/**
	 * Must be called whenever something is set
	 * if the index doesn't exist, then it acts as an arraylist
	 * @param t
	 * @param i
	 */
	protected void set(TLTrack t, int i) {
		
		if(i >= size) {
			throw new IndexOutOfBoundsException("The size is "+size+", so the index must be <=" + (size - 1));
		}
		
		TLTrack old = all.set(i, t);
		detach(old);
		if(t.otherNode(this).isHigherThan(this)) {
			higher.add(t);
			
		}
		else lower.add(t);
//		if(i >= all.size()) {
//			
//			while(i > all.size()) {
//				all.add(null);
//			} // ends at all.size() == i
//			all.add(t); // all.size == i + 1; also, t is now at i position
//			
//			
//		} else {
//		
//			
//		}
		

		


		

	}
	

	
	int currentindex = 0;
	public void attach(TLTrack t) {
		set(t, currentindex++);
	}
	@Override
	public float tolerance(DrawContext dc) {
		return 0;
	}
	@Override
	public void detach(TLTrack t) {
		
		for(int i=0;i<all.size();i++) {
			TLTrack it = all.get(i);
			if(it != null && it.equals(t)) {
				all.set(i, null);
			}
		}
		higher.remove(t);
		lower.remove(t);
	}

	
}
