package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Difference;
import language.Face;
import language.Intersection;
import language.Node;
import language.Polyhedron;
import language.Rotate;
import language.Coordinate;
import language.Cube;
import language.Cylinder;
import language.Translate;
import language.Union;
import prostheticSystem.SizingBlock;
import prostheticSystem.SCADModel;

public class MagnetSnap extends LockingMechanism {

	private double radius;
	private double height;
	private double indent;
	private double radius2;
	
	public MagnetSnap(double r, double h, double i, double r2){
		super();
		radius =r;
		height =h;
		indent =i;
		radius2=r2;
		makeLock();
		makeKey();
	}
	
	@Override
	protected void makeLock() {
//		Difference diff = new Difference(new ArrayList<Node>());
//		double diagonal = Math.sqrt(2)*this.radius;
//		diff.addChild(new Translate(new Rotate(new Cube(diagonal,diagonal,height,true),0,0, -45),0,0,this.height/2));
//		double slices = height/(2*this.sliceH);
//		double xs= medium*sliceH/height;
//		double j= slices;
//		for(int i=0; i<=slices; i++){
//			j = (slices-i);
//			diff.addChild(new Translate(new Cube(xs*i+radius,xs*i+radius,sliceH),-i*xs,-i*xs,i*sliceH));
//			diff.addChild(new Translate(new Cube(xs*j+radius,xs*j+radius,sliceH),-j*xs,-j*xs,i*sliceH+height/2));
//		}
//		diff.addChild(new Translate(new Rotate(super.magnet(),-90,0,-45),-this.medium+1.5,-this.medium+1.5,this.height/2));
//		super.lock=new SCADModel(diff, new SizingBlock(radius, height));
		
	}
	
	
	private Polyhedron prism(){
		ArrayList<Coordinate> points = new ArrayList<Coordinate>(8);
		points.add(new Coordinate());//0
		points.add(new Coordinate(this.radius,0,0));//1
		points.add(new Coordinate(0,this.radius,0));//2
		points.add(new Coordinate(-indent, -indent,height/2));//3
		points.add(new Coordinate(-indent+radius2, -indent,height/2));//4
		points.add(new Coordinate(0,0,height));//5
		points.add(new Coordinate(radius,0,height));//6
		points.add(new Coordinate(0,radius,height));//7
		points.add(new Coordinate(-indent, -indent+radius2,height/2));
		
		ArrayList<Face> faces = new ArrayList<Face>(9);
		faces.add(new Face(0,1,2));//bottom
		faces.add(new Face(0,3,4,1));//left lower
		faces.add(new Face(3,5,6,4));//left upper
		faces.add(new Face(5,7,6));//top
		faces.add(new Face(7,5,3,8));//right upper
		faces.add(new Face(8,3,0,2));//right lower
		faces.add(new Face(4,6,1));//left
		faces.add(new Face(7,8,2));//right
		faces.add(new Face(7,6,1,2));//back
		return new Polyhedron(points,faces);
	}
	private Intersection quarterCyl(double r, double h){
		Intersection qc = new Intersection(new ArrayList<Node>(2));
		qc.addChild(new Cylinder(r,h));
		qc.addChild(new Cube(r,r,h));
		return qc;
	}
	@Override
	protected void makeKey() {
		Union k = new Union(new ArrayList<Node>(2));
		k.addChild(quarterCyl(radius,height));
		k.addChild(this.prism());
		Difference diff = new Difference(new ArrayList<Node>(2));
		diff.addChild(k);
		diff.addChild(new Translate(new Rotate(super.magnet(),-90,0,-45),-indent,-indent,this.height/2));//TODO: Magnet hole not clean
		super.key=new SCADModel(diff,new SizingBlock(new Coordinate(radius2,radius2,height), new Coordinate(-indent, -indent, 0)));
	}

	public static void main(String[] arg){
		double r=20;
		double h=40;
		double i=5;
		double r2=25;
		MagnetSnap snap = new MagnetSnap(r,h,i,r2);
		SCADWriter.writeSCAD(snap.encodeKey(), "magnetSnapKey");
	}
}
