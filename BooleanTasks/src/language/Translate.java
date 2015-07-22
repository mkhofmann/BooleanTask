package language;
public class Translate extends Modifier {

	public Translate(Node n,float x, float y, float z) {
		super(n,"translate(["+x+","+y+","+z+"]) ");
	}
	
}

