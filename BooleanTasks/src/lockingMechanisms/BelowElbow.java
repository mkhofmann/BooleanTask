package lockingMechanisms;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Cube;
import language.Difference;
import language.Node;
import language.Translate;
import language.Union;

public class BelowElbow extends LockingMechanism{
	float side;
	float length;
	float neckL;
	float neckS;
	float headL;
	float headS;
	float space;
	float twoSpace;
	
	
	public BelowElbow(float s, float l, float nl, float nS, float hl, float hS, float sp){
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
		super.lock = new Difference(lockDif);		
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
		super.key = new Union(keyUnion);
	}
	@Override
	public Translate LowerCenterLock() {
		return new Translate(super.lock,0,0,-length);
	}
	@Override
	public Translate LowerCenterKey() {
		return new Translate(super.key,0,0,-neckL-headL);
	}
	
	public static void main(String[] args){
		float side=50;
		float length=100;
		float neckL=60;
		float neckS=20;
		float headL=10;
		float headS=40;
		float space=1;
		BelowElbow lockTest = new BelowElbow(side,length,neckL,neckS,headL,headS,space);
		SCADWriter.writeSCAD(lockTest.LowerCenterKey().encode(), "BelowElbowTest");
	}
	
	

}
