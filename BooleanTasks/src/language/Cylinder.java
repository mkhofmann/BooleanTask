package language;

public class Cylinder extends Model {

	public Cylinder(double r, double h) {
		super("cylinder(r="+r+",h="+h+")");
	}
	
	public Cylinder(double r1, double r2, double h){
		super("cylinder(r1="+r1+",r2="+r2+",h="+h+")");
	}
	
	public Cylinder(float circ, double h){
		this((double)(circ/2*Math.PI), h);
	}
	public Cylinder(float circ1, double circ2, double h){
		this((double)(circ1/(2*Math.PI)),(double)(circ2/(2*Math.PI)), h);
	}

}
