package language;

import inputOutput.SCADWriter;

public class RightTrianglePrism extends LinearExtrude{

	public RightTrianglePrism(double height, double base, double h) {
		super(new RightTriangle(height,base), h);
	}
	
	public static void main(String args[]){
		RightTrianglePrism t = new RightTrianglePrism(3,4,8);
		SCADWriter.writeSCAD(t.encode(), "triangle");
	}

}
