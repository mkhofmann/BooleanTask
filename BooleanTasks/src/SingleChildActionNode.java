public abstract class SingleChildActionNode extends ActionNode {
	private Node child;
	public SingleChildActionNode(Node n,String a) {
		super(a);
		child = n;
	}

	@Override
	public String encode() {
		return action+" "+child.encode();
	}
}