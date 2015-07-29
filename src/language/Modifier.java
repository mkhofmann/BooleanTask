package language;
public abstract class Modifier extends Action {
	protected Node child;
	public Modifier(Node n,String a) {
		super(a);
		child = n;
	}
	
	public void setChild(Node c){
		child=c;
	}

	@Override
	public String encode() {
		return action+" "+child.encode();
	}
}