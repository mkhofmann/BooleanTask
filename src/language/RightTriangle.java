package language;

public class RightTriangle extends Polygon{

	RightTriangle(double height, double base) {
		super(new Point[]{new Point(), new Point(base,0), new Point(0,height)});
	}

}
