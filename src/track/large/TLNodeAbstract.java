package track.large;

import java.util.ArrayList;

import java.util.List;

import main.Ap;
import main.DrawContext;
import main.Main;


/**
 * Actually functions as sort of a multinode, as if you set over the limit, the array automatically resizes
 * @author Owner
 *
 */
public abstract class TLNodeAbstract implements TLNode{
	private float pvx, pvy;
	protected List<TLTrack> higher = new ArrayList<>();
	protected List<TLTrack> lower = new ArrayList<>();
 	protected List<TLTrack> all;
 	
	protected TLNodeAbstract(float x, float y, ArrayList<TLTrack> list) {
		this.pvx = x;
		this.pvy = y;
 		all = list;
 		register(Ap.p().td);
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

	@Override
	public boolean isWithinBounds(float x, float y, DrawContext dc) {
		float d2pt = square(x-pvx)+square(y-pvy);
		return d2pt < square(radius() + tolerance(dc));
	}
	private float square(float in) {
		return in * in;
	}
	
	
	public List<TLTrack> higher() {return higher;}
	public List<TLTrack> lower() {return lower;}
	public List<TLTrack> all() {return all;}
	@Override
	public void draw(DrawContext dc) {
		Main p = Ap.p();
		p.pushStyle();
			p.fill(0, 255, 0);
			p.stroke(0, 128, 0);
			TLNode.super.draw(dc);
		p.popStyle();
	}

}
