package tools;

import java.util.ArrayList;

import language.Coordinate;
import language.Cube;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Translate;

public class Mount extends Tool{

	public Mount(double w, double d, double h, ArrayList<Coordinate> bolts) {//bolts Z is the radius
		super(new Coordinate(w,d,h), new Coordinate());
		Difference diff = new Difference(new ArrayList<Node>(bolts.size()+1));
		diff.addChild(new Cube(w,d,h));
		for(Coordinate c: bolts)
			diff.addChild(new Translate(new Cylinder(c.z,h),c.x, c.y, 0));
		super.tool = diff;		
	}

}
