package lockingMechanisms;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Set;
import language.Translate;
import language.TranslateSet;

public class MagnetBE extends BelowElbow{
	private static final float MAGD = 9;
	private static final float MAGR = MagnetBE.MAGD/2;
	private static final float MAGH = 10;

	public MagnetBE(float l, float nl, float nS,float sp) {
		super((nS+6*Node.MIN_THICKNESS+2*MagnetBE.MAGD+sp*2),l,nl,nS,MAGH+Node.MIN_THICKNESS, (nS+4*Node.MIN_THICKNESS+2*MagnetBE.MAGD),sp);
	}
	//TODO: other constructors by max Side, max Head
	
	private Node magnet(){
		return new Cylinder(MagnetBE.MAGR, MagnetBE.MAGH);
	}
	private Set magnets(){
		ArrayList<Node> mags = new ArrayList<Node>(4);
		float x = super.neckS/2+MagnetBE.MAGR+Node.MIN_THICKNESS;
		mags.add(new Translate(this.magnet(),-x,-x,0));
		mags.add(new Translate(this.magnet(),x,-x,0));
		mags.add(new Translate(this.magnet(),-x,x,0));
		mags.add(new Translate(this.magnet(),x,x,0));
		return new Set(mags,"");
	}
	@Override
	protected void makeLock(){
		super.makeLock();
		Node orig = super.lock;
		ArrayList<Node> newDif = new ArrayList<Node>(2);
		newDif.add(orig);
		newDif.add(new TranslateSet(this.magnets(),0,0,super.neckL-MagnetBE.MAGH));
		super.lock = new Difference(newDif);
	}
	@Override
	protected void makeKey(){
		super.makeKey();
		Node orig = super.key;
		ArrayList<Node> newDif = new ArrayList<Node>(2);
		newDif.add(orig);
		newDif.add(new TranslateSet(this.magnets(),0,0,super.neckL));
		super.key = new Difference(newDif);
	}

	public static void main(String[] args){;
		float length=100;
		float neckL=60;
		float neckS=20;
		float space=1;
		MagnetBE lockTest = new MagnetBE(length,neckL,neckS,space);
		SCADWriter.writeSCAD(lockTest.encodeMechanism(), "MagnetBETest");
	}
}
