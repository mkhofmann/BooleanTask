import java.util.ArrayList;

public class MultiChildActionNode extends ActionNode{
	private ArrayList<Node> children;
	public MultiChildActionNode(ArrayList<Node> c, String a) {
		super(a);
		children = c;
	}
	public MultiChildActionNode(String a){
		this(new ArrayList<Node>(), a);
	}
	public void addChild(Node c){
		children.add(c);
	}
	
	@Override
	public String encode() {
		String code =action+" {\n";
		for(int i=0; i<children.size(); i++){
			code+=children.get(i).encode()+"\n";
		}
		code+="}";
		return code;
	}

}
