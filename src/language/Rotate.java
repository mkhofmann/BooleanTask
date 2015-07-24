package language;

public class Rotate extends Modifier {

	public Rotate(Node n,Coordinate s) {
		super(n,"rotate(["+s.x+","+s.y+","+s.z+"]) ");
	}
	
	public Rotate(Node n, double x, double y, double z){
		this(n,new Coordinate(x,y,z));
	}
	
}