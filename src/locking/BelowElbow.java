package locking;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Cube;
import language.Difference;
import language.Node;
import language.Translate;
import language.Union;
import prostheticSystem.SCADModel;
import prostheticSystem.SizingBlock;

public class BelowElbow extends LockingMechanism{
	double side;
	double length;
	double neckL;
	double neckS;
	double headL;
	double headS;
	double space;
	double twoSpace;
	
	
	public BelowElbow(double s, double l, double nl, double nS, double hl, double hS, double sp){
		super();
		this.side = s;
		this.length =l;
		this.neckL = nl;
		this.neckS = nS;
		this.headL = hl;
		this.headS = hS;
		this.space = sp;	
		this.twoSpace=sp*2;
		this.makeLock();
		this.makeKey();
	}
	@Override
	protected void makeLock() {
		ArrayList<Node> lockDif = new ArrayList<Node>();
		lockDif.add(this.block());
		lockDif.add(this.LockInterior());
		super.lock = new SCADModel(new Difference(lockDif),new SizingBlock(this.side, this.side,this.length,-this.side/2,-this.side/2,0));		
	}
	private Node block(){
		return new Cube(this.side, this.side, this.length).center(true, true, false);
	}
	private Node LockInterior(){
		Union interior = new Union(new ArrayList<Node>());
		interior.addChild(new Cube(this.neckS+this.twoSpace, this.neckS+this.twoSpace, this.neckL).center(true, true, false));//neck
		interior.addChild(new Translate(new Cube(this.headS+this.twoSpace,this.headS+this.twoSpace,2*this.headL+this.twoSpace).center(true, true, false),0,0,this.neckL));//head
		interior.addChild(new Cube(this.neckS+this.twoSpace,this.side/2,this.neckL+this.headL+this.space).center(true, false, false));//neckSlot
		interior.addChild(new Translate(new Cube(this.headS+this.twoSpace,this.side/2,this.headL+this.space),
								-this.headS/2-this.space, 0,this.neckL+this.headL+this.space));
		return interior;
	}
	@Override
	protected void makeKey() {
		ArrayList<Node> keyUnion = new ArrayList<Node>();
		keyUnion.add(new Translate(new Cube(this.headS,this.headS,this.headL).center(true, true, false),0,0,this.neckL));//head
		keyUnion.add(new Translate(new Cube(this.neckS, this.neckS, this.neckL+2*this.headL).center(true, true, false),0,0,-2*this.headL));//neck
		super.key = new SCADModel(new Union(keyUnion),new SizingBlock(this.headS, this.headS,this.neckL+3*this.headL,-this.headS/2, -this.headS/2,-2*this.headL));
	}

	
	public static void main(String[] args){
		double side=50;
		double length=100;
		double neckL=60;
		double neckS=20;
		double headL=10;
		double headS=40;
		double space=1;
		BelowElbow lockTest = new BelowElbow(side,length,neckL,neckS,headL,headS,space);
		SCADWriter.writeSCAD(lockTest.key.encodeSizeCheck(), "BelowElbowTest");
	}
	
	

}