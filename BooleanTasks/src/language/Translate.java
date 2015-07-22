package language;

import arms.CustomArm;

public class Translate extends Modifier {

	public Translate(Node n,double x, double y, double z) {
		super(n,"translate(["+x+","+y+","+z+"]) ");
	}
	
	public Translate(CustomArm arm, double x, double y, double z){
		super(arm.arm, "translate(["+x+","+y+","+z+"]) ");
		//TODO adjust customArm location
	}
	
}

