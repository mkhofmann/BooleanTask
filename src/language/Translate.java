
package language;

public class Translate extends Modifier {
	
	public Translate(Node n){
		this(n,0,0,0);
	}
	
	public Translate(Node n,Coordinate s) {
		super(n,"translate(["+s.x+","+s.y+","+s.z+"]) ");
	}
	
	public Translate(Node n, double x, double y, double z){
		this(n,new Coordinate(x,y,z));
	}
	
}