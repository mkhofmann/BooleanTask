package demos;

import arms.Arm;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.STL;
import language.Translate;

public class BrettGrip extends Arm{

	public BrettGrip() {
		super(new Coordinate(45,45,65), new Coordinate());
		super.head = new STL("BrettGrip.stl");
		super.scaler = new language.Scale(super.head,1,1,1);
		super.translater = new Translate(super.scaler,0,0,0);
	}
	
	public static void main(String[] args){
		BrettGrip grip = new BrettGrip();
		SCADWriter.writeSCAD(grip.encodeSizeCheck(), "grip");
	}

}
