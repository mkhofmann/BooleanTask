package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.Cube;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Rotate;
import language.Translate;
import language.Union;
import prostheticSystem.SCADModel;
import prostheticSystem.SizingBlock;

public class SlideMagnet extends LockingMechanism{
	private double width;
	private double length;
	private double height;
	
	
	public SlideMagnet(double w, double l, double h){
		super();
		this.width=w;
		this.length=l;
		this.height=h;
		this.makeLock();
		this.makeKey();
	}
	
	private Node prism(){//TODO: make catch constant with variable width
		
		double a = Math.toDegrees(Math.atan(2*height/length));
		double h = Math.sqrt((length*length)/64 + (height*height)/16);
		Difference diff = new Difference(new ArrayList<Node>(3));
		diff.addChild(new Cube(length/8,width, height/2));
		diff.addChild(new Rotate(new Cube(h,width,h),0,90-a,0));
		diff.addChild(new Translate(new Rotate(new Cube(h,width,h),0,a,0),0,0,height/2));
		return diff;
	}
	@Override
	public Node magnet(){
		return new Cylinder(10, 5);
	}
	@Override
	protected void makeLock() {
		Union union = new Union(new ArrayList<Node>(2));
		union.addChild(new Cube(length, width, height/2));
		union.addChild(new Translate(new Cube(length/4,width, height/2),0,0,height/2));
		union.addChild(new Translate(this.prism(), length/4,0, height/2));
		Difference diff = new Difference(new ArrayList<Node>(2));
		diff.addChild(union);
		diff.addChild(new Translate(this.magnet(), length*3/8+10,width/2, height/2-5));
		super.lock = new SCADModel(diff,new SizingBlock(new Coordinate(length, width, height), new Coordinate()));
		
	}

	@Override
	protected void makeKey() {
		super.key = super.lock;
	}
	
	public static void main(String[] arg){
		SlideMagnet slide = new SlideMagnet(30,30,12);
		SCADWriter.writeSCAD(slide.encodeLock(), "slideMagnet");
	}

}
