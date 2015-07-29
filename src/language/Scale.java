package language;
public class Scale extends Modifier {
	private Coordinate c;
	
	public Scale(Node n,Coordinate s) {
		super(n,"scale(["+s.x+","+s.y+","+s.z+"]) ");
		c=s;
	}
	
	public Scale(Node n, double x, double y, double z){
		this(n, new Coordinate(x,y,z));
	}
	
	public Scale(Node n){
		this(n,1,1,1);
	}
	
	public void setC(double x, double y, double z){
		setC(new Coordinate(x,y,z));
	}
	
	public void setC(Coordinate s){
		c=s;
	}
	
	@Override
	public String encode(){
		return "scale(["+c.x+","+c.y+","+c.z+"])"+super.child.encode();
		
	}
	
}