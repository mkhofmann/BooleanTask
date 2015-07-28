
package language;

public class Translate extends Modifier {
	private Coordinate c;
	public Translate(Node n){
		this(n,0,0,0);
	}
	
	public Translate(Node n,Coordinate s) {
		super(n,"translate(["+s.x+","+s.y+","+s.z+"]) ");
		c=s;
	}
	
	public Translate(Node n, double x, double y, double z){
		this(n,new Coordinate(x,y,z));
	}
	
	public void setC(double x, double y, double z){
		setC(new Coordinate(x,y,z));
	}
	
	public void setC(Coordinate s){
		c=s;
	}
	
	@Override
	public String encode(){
		return "translate(["+c.x+","+c.y+","+c.z+"])+"+super.child.encode();
		
	}
}