public class RotateNode extends SingleChildActionNode {

	public RotateNode(Node n,float x, float y, float z) {
		super(n,Codes.rotate(x, y, z, ""));
	}
	
}