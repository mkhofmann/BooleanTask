package language;

public class Rotate extends Modifier {

	public Rotate(Node n,double x, double y, double z) {
		super(n,"rotate(["+x+","+y+","+z+"]) ");
	}
	
}