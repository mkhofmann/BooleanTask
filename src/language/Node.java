package language;
public abstract class Node {
	public final static double MIN_THICKNESS =3;
	
	//TODO: add error checking to model thickness, minimum priority
	protected Node(){
	}
	public abstract String encode();
	public String toString(){
		return this.encode();
	}
	
}