package track.large;

import java.util.ArrayList;
import java.util.List;

import main.DrawContext;


/**
 * Actually functions as sort of a multinode, as if you set over the limit, the array automatically resizes
 * @author Owner
 *
 */
public abstract class TLNodeAbstract implements TLNode{
	protected float pvx, pvy;
	protected List<TLTrack> higher = new ArrayList<>();
	protected List<TLTrack> lower = new ArrayList<>();
	protected List<TLTrack1> outwards = new ArrayList<>();
	protected List<TLTrack1> inwards = new ArrayList<>();
 	protected List<TLTrack> all;
 	
	protected TLNodeAbstract(float x, float y, ArrayList<TLTrack> list) {
		this.pvx = x;
		this.pvy = y;
 		all = list;

	}
	public TLNodeAbstract(float x, float y) {
		this(x, y, new ArrayList<>());
	}

	@Override
	public float x() {
		return pvx;
	}

	@Override
	public float y() {
		return pvy;
	}
	
	
	protected void addToHigherLower(TLTrack t) {
		if(t.otherNode(this).isHigherThan(this)) {
			higher.add(t);
			
		}
		else lower.add(t);
	}
	protected void addToOutwardsInwards(TLTrack1 t) {
		if(t.from().equals(this)) {
			outwards.add(t);
		} else if(t.to().equals(this)) {
			inwards.add(t);
		} else {
			throw new IllegalArgumentException("None of TLTrack's nodes  is me");
		}
	}
	

	
	
	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		float d2pt = square(x-pvx)+square(y-pvy);
		return d2pt < square(radius() + tolerance(dc));
	}
	private float square(float in) {
		return in * in;
	}
	
	@Override
	public List<TLTrack> higher() {return higher;}
	@Override
	public List<TLTrack> lower() {return lower;}
	@Override
	public List<TLTrack> all() {return all;}
	@Override
	public List<TLTrack1> outwards() {return outwards;}
	@Override
	public List<TLTrack1> inwards() {return inwards;}
	
//	@Override
//	public void draw(DrawContext dc) {
//		Main p = Ap.p();
//		p.pushStyle();
//			p.fill(0, 255, 0);
//			p.stroke(0, 128, 0);
//			TLNode.super.draw(dc);
//		p.popStyle();
//	}
	public void attach1(TLTrack1 t) {
		this.attach(t);
		addToOutwardsInwards(t);
	}
	@Override
	public void detach1(TLTrack1 t) {
		detach(t);
		outwards.remove(t);
		inwards.remove(t);
	}

	public void attach2(TLTrack2 t) {
		this.attach(t);
		addToOutwardsInwards(t.ab());
		addToOutwardsInwards(t.ba());
	}
	@Override
	public void detach2(TLTrack2 t) {
		detach(t);
		// who cares about time complexity
		outwards.remove(t.ab());
		outwards.remove(t.ba());
		inwards.remove(t.ab());
		inwards.remove(t.ba());
	}
	

}
