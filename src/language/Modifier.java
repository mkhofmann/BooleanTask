package language;
public abstract class Modifier extends Action {
	protected Node child;
	public Modifier(Node n,String a) {
		super(a);
		child = n;
	}

	@Override
	public String encode() {
		return action+" "+child.encode();
	}
}