package language;

import java.util.ArrayList;

public class TranslateSet extends Set{

	public TranslateSet(ArrayList<Node> c, double x, double y, double z) {
		super(c, "translate(["+x+","+y+","+z+"]) ");
	}
	
	public TranslateSet(double x, double y, double z){
		super("translate(["+x+","+y+","+z+"]) ");
	}
	
	public TranslateSet(Set s, double x, double y, double z){
		super(s.children,"translate(["+x+","+y+","+z+"]) " );
	}

}
