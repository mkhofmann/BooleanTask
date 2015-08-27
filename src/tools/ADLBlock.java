package tools;

import java.util.ArrayList;

import language.Coordinate;
import language.Cube;
import language.Difference;
import language.Node;
import language.Translate;

public class ADLBlock extends Tool {

	public ADLBlock(Coordinate s) {
		super(s, new Coordinate());
		Difference u = new Difference(new ArrayList<Node>(2));
		u.addChild(new Cube(s));
		u.addChild(new Translate(new Cube(s.x-2*Node.MIN_THICKNESS, s.y-2*Node.MIN_THICKNESS, s.z),Node.MIN_THICKNESS, Node.MIN_THICKNESS,0));
		super.head = u;
		super.scaler = new language.Scale(super.head, 1,1,1);
		super.translater = new Translate(super.scaler, 0,0,0);
	}

}
