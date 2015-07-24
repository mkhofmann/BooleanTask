package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Difference;
import language.Node;
import language.Set;
import language.Translate;
import language.TranslateSet;
import prostheticSystem.SCADModel;

public class MagnetBE extends BelowElbow{
	public MagnetBE(double l, double nl, double nS,double sp) {
		super((nS+6*Node.MIN_THICKNESS+2*LockingMechanism.MAGD+sp*2),l,nl,nS,LockingMechanism.MAGH+Node.MIN_THICKNESS, (nS+4*Node.MIN_THICKNESS+2*MagnetBE.MAGD),sp);
	}
	//TODO: other constructors by max Side, max Head
	private Set magnets(){
		ArrayList<Node> mags = new ArrayList<Node>(4);
		double x = super.neckS/2+LockingMechanism.MAGR+Node.MIN_THICKNESS;
		mags.add(new Translate(this.magnet(),-x,-x,0));
		mags.add(new Translate(this.magnet(),x,-x,0));
		mags.add(new Translate(this.magnet(),-x,x,0));
		mags.add(new Translate(this.magnet(),x,x,0));
		return new Set(mags,"");
	}
	@Override
	protected void makeLock(){
		super.makeLock();
		Node orig = lock.getHead();
		ArrayList<Node> newDif = new ArrayList<Node>(2);
		newDif.add(orig);
		newDif.add(new TranslateSet(this.magnets(),0,0,super.neckL-LockingMechanism.MAGH));
		super.lock = new SCADModel(new Difference(newDif), super.lock.getSize());
	}
	@Override
	protected void makeKey(){
		super.makeKey();
		Node orig = key.getHead();
		ArrayList<Node> newDif = new ArrayList<Node>(2);
		newDif.add(orig);
		newDif.add(new TranslateSet(this.magnets(),0,0,super.neckL));
		super.key = new SCADModel(new Difference(newDif), super.key.getSize());
	}

	public static void main(String[] args){;
		double length=100;
		double neckL=60;
		double neckS=20;
		double space=1;
		MagnetBE lockTest = new MagnetBE(length,neckL,neckS,space);
		SCADWriter.writeSCAD(lockTest.encodeMechanism(), "MagnetBETest");
	}
}