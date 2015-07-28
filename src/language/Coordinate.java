package language;
//TODO: integrate into Language Nodes

public class Coordinate {
	public double x;
	public double y;
	public double z;
	
	public Coordinate(){
		x=0;
		y=0;
		z=0;		
	}
	
	public Coordinate(double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public String encode(){
		return "["+x+","+y+","+z+"]";
	}
}
