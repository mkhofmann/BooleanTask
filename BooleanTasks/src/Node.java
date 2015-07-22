public abstract class Node {
	Node(){
	}
	public abstract String encode();
	public String toString(){
		return this.encode();
	}
	
}
