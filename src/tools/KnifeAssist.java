package tools;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.STL;

public class KnifeAssist extends Tool{
	
	public KnifeAssist() {
		super(new Coordinate(50,50,25), new Coordinate(-25,-25,0));
		super.head = new STL("KNIFEGUARD.stl");
	}
	
	public static void main(String[] args){
		KnifeAssist knife = new KnifeAssist();
		SCADWriter.writeSCAD(knife.checkSizing().encode(), "SizeKnife");
	}

}
