package language;

import java.util.ArrayList;

public class TranslateSet extends Set{

	public TranslateSet(ArrayList<Node> c, float x, float y, float z) {
		super(c, "translate(["+x+","+y+","+z+"]) ");
	}
	
	public TranslateSet(float x, float y, float z){
		super("translate(["+x+","+y+","+z+"]) ");
	}
	
	public TranslateSet(Set s, float x, float y, float z){
		super(s.children,"translate(["+x+","+y+","+z+"]) " );
	}

}
