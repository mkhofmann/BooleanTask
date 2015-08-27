package demos;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.Node;
import language.Cube;
import language.RightTrianglePrism;
import language.Rotate;
import language.Translate;
import language.Union;
import tools.Tool;

public class HandCycle extends Tool {
	private double width;
	private double thickness;
	private double tHeight=26;
	private double tBase=54;
	private double base=2*tBase;
	private double extend=2*Math.sqrt(tHeight*tHeight+ tBase*tBase);
	
	public HandCycle(double w, double th) {
		super(new Coordinate(), new Coordinate());
		super.size.size =new Coordinate(w, base+tBase, 2*tHeight+th);
		width = w;
		thickness =th;
		Union union = new Union(new ArrayList<Node>(3));
		union.addChild(this.forwardBlock());
		union.addChild(new Translate(new Rotate(this.triangle(),90,0,270),width,base,thickness));
		union.addChild(new Translate(this.rotateBlock(),0,tBase,0));
		super.head = union;
		super.scaler = new language.Scale(super.head,1,1,1);
		super.translater = new Translate(super.scaler,0,0,0);
	}
	
	private Cube forwardBlock(){
		return new Cube(width, base, thickness);
	}
	private Rotate rotateBlock(){
		double tan = Math.toDegrees(Math.atan(tHeight/tBase));
		return new Rotate(new Cube(width, extend, thickness),tan,0,0);
	}
	private RightTrianglePrism triangle(){
		return new RightTrianglePrism(tHeight, tBase,width);
	}
	
	public static void main(String[] args){
		HandCycle mount = new HandCycle(40,10);
		SCADWriter.writeSCAD(mount.encodeSizeCheck(), "Handcycle");
	}


}
