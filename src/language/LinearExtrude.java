package language;

public class LinearExtrude extends Modifier{

	public LinearExtrude(Node n, double h) {
		super(n, "linear_extrude(height ="+h+") ");
	}

}
