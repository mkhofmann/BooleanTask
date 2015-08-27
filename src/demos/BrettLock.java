package demos;

import java.util.ArrayList;

import connection.Base;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Rotate;
import language.Sphere;
import language.Translate;
import language.Union;
import locking.LockingMechanism;
import prostheticSystem.SCADModel;
import prostheticSystem.SizingBlock;

public class BrettLock extends LockingMechanism{
	
	private double radius;
	private double pinRadius;
	private double height;
	private double stemRadius;
	private double stemHeight;
	
	public BrettLock(double r, double pr, double h, double sr, double sh){
		super();
		radius =r;
		pinRadius = pr;
		this.height=h;
		this.stemRadius=sr;
		this.stemHeight=sh;
		makeLock();
	}
	
	@Override
	protected void makeLock() {
		Difference lockCyl = new Difference( new ArrayList<Node>());
		lockCyl.addChild(new Cylinder(radius, height));
		for(int i=0; i<4; i++){
			lockCyl.addChild(new Rotate(new Translate(new Sphere(pinRadius),0,radius,height/2),0,radius,i*90));
		}
		Union stemmed = new Union(new ArrayList<Node>(2));
		stemmed.addChild(lockCyl);
		stemmed.addChild(new Cylinder(stemRadius, stemHeight+height));
		
		super.lock = new SCADModel(stemmed, new SizingBlock(2*radius,2*radius, height+stemHeight, -radius, -radius, 0));
		
	}

	@Override
	protected void makeKey() {
		super.key= new SCADModel(null, new SizingBlock(0,0,0,0,0,0));	
	}
	
	public static void main(String[] args){
		double r=10;
		double pr=2;
		double h=30;
		double sr=5; 
		double sh=40;
		BrettLock lock = new BrettLock(r,pr,h,sr,sh);
		lock.lock.zeroX();
		lock.lock.zeroY();
		lock.lock.centerX();
		lock.lock.centerY();
		
		Base lockBase = new Base(lock.lock, 5);
		lockBase.dragModelTo(new Coordinate(3,4,5));
		SCADWriter.writeSCAD(lockBase.encodeBlockModel(), "BrettLock");
	}

}
