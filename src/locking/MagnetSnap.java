package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Difference;
import language.Node;
import language.Rotate;
import language.Cylinder;
import language.Cube;
import language.Translate;
import language.Union;
import prostheticSystem.SizingBlock;
import prostheticSystem.SCADModel;

public class MagnetSnap extends LockingMechanism {

	private double radius;
	private double height;
	private double sliceH;
	private double medium;
	
	public MagnetSnap(double r, double h, double zs, double m){
		super();
		radius =r;
		height =h;
		sliceH=zs;
		this.medium=m;
		makeLock();
		makeKey();
	}
	
	@Override
	protected void makeLock() {
		Difference diff = new Difference(new ArrayList<Node>());
		diff.addChild(new Cylinder(radius,height));
		double slices = height/(2*this.sliceH);
		double xs= medium*sliceH/height;
		for(int i=0; i<=slices; i++){
			diff.addChild(new Translate(new Cube(xs*i+radius,xs*i+radius,sliceH),-i*xs,-i*xs,i*sliceH));
			diff.addChild(new Translate(new Cube(medium-i*xs,medium-i*xs,sliceH),-(slices-i)*xs,-(slices-i)*xs,i*sliceH+height/2));
		}
		diff.addChild(new Rotate(super.magnet(),0.0,90.0,45.0));
		super.lock=new SCADModel(diff, new SizingBlock(radius, height));
	}

	@Override
	protected void makeKey() {
		Union union = new Union(new ArrayList<Node>());
		double slices = height/(2*this.sliceH);
		double xs= medium*sliceH/height;
		for(int i=0; i<=slices; i++){
			union.addChild(new Translate(new Cube(xs*i+radius,xs*i+radius,sliceH),-i*xs,-i*xs,i*sliceH));
			union.addChild(new Translate(new Cube(medium-i*xs,medium-i*xs,sliceH),-(slices-i)*xs,-(slices-i)*xs,i*sliceH+height/2));
		}
	}

	public static void main(String[] arg){
		double r=20;
		double h=40;
		double z=.1;
		double m=10;
		MagnetSnap snap = new MagnetSnap(r,h,z,m);
		SCADWriter.writeSCAD(snap.encodeLock(), "magnetSnap");//TODO: DIDN"Tworkd
	}
}
