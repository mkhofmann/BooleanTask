import java.util.ArrayList;

public class DifferenceNode extends MultiChildActionNode {

	public DifferenceNode(ArrayList<Node> c) {
		super(c, "difference() ");
		//NOTE: ASSUMES 0 index is priority model
	}
	public DifferenceNode(){
		super("difference() ");
	}


}