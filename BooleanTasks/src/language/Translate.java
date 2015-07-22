package language;
public class Translate extends Modifier {

	public Translate(Node n,double x, double y, double z) {
		super(n,"translate(["+x+","+y+","+z+"]) ");
	}
	
}

