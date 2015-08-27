package demos;

import arms.Gauntlet;
import inputOutput.SCADWriter;

public class ElaineGauntlet extends Gauntlet {

	public ElaineGauntlet() {
		super(3, 30, 40, new Double[]{262.0,240.0,225.0,200.0,165.0,155.0}, 5);
	}
	
	public static void main(String[] args){
		ElaineGauntlet elaine = new ElaineGauntlet();
		SCADWriter.writeSCAD(elaine.encode(), "ElaineGauntlet");
	}

}
