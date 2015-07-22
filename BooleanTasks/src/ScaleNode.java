public class ScaleNode extends SingleChildActionNode {

	public ScaleNode(Node n,float x, float y, float z) {
		super(n,Codes.scale(x, y, z, ""));
	}
	
}

