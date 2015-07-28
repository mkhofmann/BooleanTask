package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Difference;
import language.Node;
import language.Rotate;
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
		double diagonal = Math.sqrt(2)*this.radius;
		diff.addChild(new Translate(new Rotate(new Cube(diagonal,diagonal,height,true),0,0, -45),0,0,this.height/2));
		double slices = height/(2*this.sliceH);
		double xs= medium*sliceH/height;
		double j= slices;
		for(int i=0; i<=slices; i++){
			j = (slices-i);
			diff.addChild(new Translate(new Cube(xs*i+radius,xs*i+radius,sliceH),-i*xs,-i*xs,i*sliceH));
			diff.addChild(new Translate(new Cube(xs*j+radius,xs*j+radius,sliceH),-j*xs,-j*xs,i*sliceH+height/2));
		}
		diff.addChild(new Translate(new Rotate(super.magnet(),-90,0,-45),-this.medium+1.5,-this.medium+1.5,this.height/2));
		super.lock=new SCADModel(diff, new SizingBlock(radius, height));
	}

	@Override
	protected void makeKey() {
		
		Union union = new Union(new ArrayList<Node>());
		double slices = height/(2*this.sliceH);
		double xs= medium*sliceH/(height/2);
		double j= slices;
		for(int i=0; i<=slices; i++){
			j = (slices-i);
			union.addChild(new Translate(new Cube(xs*i+radius,xs*i+radius,sliceH),-i*xs,-i*xs,i*sliceH));
			union.addChild(new Translate(new Cube(xs*j+radius,xs*j+radius,sliceH),-j*xs,-j*xs,i*sliceH+height/2));
		}
		double s = this.medium+this.radius;
		double diagonal = Math.sqrt(2)*s;
		union.addChild(new Translate(new Rotate(new Cube(diagonal,diagonal,height,true),0,0,-45),this.radius,this.radius,this.height/2));
		Difference diff = new Difference(new ArrayList<Node>(2));
		diff.addChild(union);
		diff.addChild(new Translate(new Rotate(super.magnet(),-90,0,-45),-this.medium,-this.medium,this.height/2));
		super.key=new SCADModel(diff, new SizingBlock(radius, height));
	}

	public static void main(String[] arg){
		double r=20;
		double h=40;
		double z=.1;
		double m=10;
		MagnetSnap snap = new MagnetSnap(r,h,z,m);
		SCADWriter.writeSCAD(snap.encodeLock(), "magnetSnapLock");
		SCADWriter.writeSCAD(snap.encodeKey(), "magnetSnapKey");
	}
}
