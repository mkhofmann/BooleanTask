package language;
public abstract class Node {
	public final static float MIN_THICKNESS =3;
	
	//TODO: add error checkignt to model thickness, minimum priority
	protected Node(){
	}
	public abstract String encode();
	public String toString(){
		return this.encode();
	}
	
}