package language;
public class Scale extends Modifier {

	public Scale(Node n,Coordinate s) {
		super(n,"scale(["+s.x+","+s.y+","+s.z+"]) ");
	}
	
	public Scale(Node n, double x, double y, double z){
		this(n, new Coordinate(x,y,z));
	}
	
	public Scale(Node n){
		this(n,1,1,1);
	}
	
}