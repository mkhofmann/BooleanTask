package language;
public class Scale extends Modifier {

	public Scale(Node n,double x, double y, double z) {
		super(n,"scale(["+x+","+y+","+z+"]) ");
	}
	
}