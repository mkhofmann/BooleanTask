package language;
import java.util.ArrayList;

public class Set extends Action{
	protected ArrayList<Node> children;
	public Set(ArrayList<Node> c, String a) {
		super(a);
		children = c;
	}
	public Set(String a){
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