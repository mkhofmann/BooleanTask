package language;

public class Cylinder extends Model {

	public Cylinder(float r, float h) {
		super("cylinder(r="+r+",h="+h+")");
	}
	
	Cylinder(float r1, float r2, float h){
		super("cylinder(r1="+r1+",r2="+r2+",h="+h+")");
	}
	
	Cylinder(double circ, float h){
		this((float)(circ/2*Math.PI), h);
	}
	public Cylinder(double circ1, double circ2, float h){
		this((float)(circ1/(2*Math.PI)),(float)(circ2/(2*Math.PI)), h);
	}

}
