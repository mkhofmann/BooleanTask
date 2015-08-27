package language;

import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Model {

	Polygon(ArrayList<Point> points) {
		super("");
		super.model = "polygon(\npoints = [";
		for(int i=0; i<points.size()-1; i++){
			super.model+=points.get(i).encode()+",";
		}
		super.model+= points.get(points.size()-1).encode()+"])";

	}
	
	Polygon(Point[] points){
		this(new ArrayList<Point>(Arrays.asList(points)));
	}

}
