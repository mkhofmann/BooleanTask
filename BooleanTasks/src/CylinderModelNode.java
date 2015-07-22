
public class CylinderModelNode extends ModelNode {

	CylinderModelNode(float r, float h) {
		super(Codes.cylinder(r, h));
	}
	
	CylinderModelNode(float r1, float r2, float h){
		super(Codes.cylinder(r1,r2, h));
	}
	
	CylinderModelNode(double circ, float h){
		this((float)(circ/2*Math.PI), h);
	}
	CylinderModelNode(double circ1, double circ2, float h){
		this((float)(circ1/(2*Math.PI)),(float)(circ2/(2*Math.PI)), h);
	}

}