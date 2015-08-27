package demos;

import arms.WidthArm;
import inputOutput.SCADWriter;

public class KharanGauntlet extends WidthArm{

	public KharanGauntlet() {
		super(3, 10, 40, new Double[]{75.0,72.0,73.0,71.0,68.0,65.0,63.0,61.0,55.0,50.0,46.0,46.0,44.0,44.0}, 5);
	}
	
	public static void main(String[] args){
		KharanGauntlet kharan = new KharanGauntlet();
		SCADWriter.writeSCAD(kharan.encode(), "KharanGauntlet");
	}

}
