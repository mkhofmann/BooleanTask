
public class ModelNode extends Node {
	public String model;
	ModelNode(String m) {
		super();
		model =m;
	}
	//TODO: Extend to basic Geometries and stls
	
	
	public String encode(){
		return Codes.endLine(model);
	}

}