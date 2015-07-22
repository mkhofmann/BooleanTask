

public class TranslateNode extends SingleChildActionNode {

	public TranslateNode(Node n,float x, float y, float z) {
		super(n,Codes.translate(x, y, z, ""));
	}
	
}

