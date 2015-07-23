package language;
import java.util.ArrayList;

public class Difference extends Set {

	public Difference(ArrayList<Node> c) {
		super(c, "difference() ");
		//NOTE: ASSUMES 0 index is priority model
	}
	public Difference(){
		super("difference() ");
	}


}