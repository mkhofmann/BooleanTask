
package language;

import java.util.ArrayList;

public class TranslateSet extends Set{

	public TranslateSet(ArrayList<Node> c, Coordinate s) {
		super(c, "translate(["+s.x+","+s.y+","+s.z+"]) ");
	}
	
	public TranslateSet(Coordinate s){
		super("translate(["+s.x+","+s.y+","+s.z+"]) ");
	}
	
	public TranslateSet(Set s, Coordinate sz){
		super(s.children,"translate(["+sz.x+","+sz.y+","+sz.
				z+"]) " );
	}
	
	public TranslateSet(ArrayList<Node> c, double x, double y, double z){
		this(c,new Coordinate(x,y,z));
	}
	public TranslateSet(double x, double y, double z){
		this(new Coordinate(x,y,z));
	}
	public TranslateSet(Set s, double x, double y, double z){
		this(s,new Coordinate(x,y,z));
	}

}