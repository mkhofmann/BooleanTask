package demos;

import inputOutput.SCADWriter;
import locking.MagnetBE;

public class KharanLock extends MagnetBE{

	public KharanLock() {
		super(100, 75, 20, 1);
	}
	
	public static void main(String[] args){
		KharanLock lock = new KharanLock();
		SCADWriter.writeSCAD(lock.encodeMechanism(), "kharanLock");
	}

}
