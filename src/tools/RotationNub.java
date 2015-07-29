package tools;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.Node;
import language.Sphere;
import language.Translate;
import language.Union;
import language.Cylinder;

public class RotationNub extends Tool {

	public RotationNub() {
		super(new Coordinate(7,7,20), new Coordinate(-3.5,-3.5,0));
		Union u= new Union(new ArrayList<Node>(3));
		u.addChild(new Cylinder(3.5,10));
		u.addChild(new Translate(new Cylinder(2.2,3),0,0,10));
		u.addChild(new Translate(new Sphere(4),0,0,16.5));	
		super.tool=u;
	}
	
	public static void main(String args[]){
		RotationNub nub = new RotationNub();
		SCADWriter.writeSCAD(nub.encode(), "Nub");
	}

}
