package language;

import java.util.ArrayList;

public class Polyhedron extends Model {

	public Polyhedron(ArrayList<Coordinate> points, ArrayList<Face> faces) {
		super("");
		super.model = "polyhedron(\npoints = [";
		for(int i=0; i<points.size()-1; i++){
			super.model+=points.get(i).encode()+",";
		}
		super.model+= points.get(points.size()-1).encode()+"],\nfaces = [";
		for(int i=0; i<faces.size()-1; i++){
			super.model+=faces.get(i).encode()+",";
		}
		super.model+=faces.get(faces.size()-1).encode()+"]\n)";
	}
	
}
