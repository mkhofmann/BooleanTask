package arms;

import java.util.ArrayList;
import java.util.Collections;

import inputOutput.SCADWriter;
import language.Cube;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Translate;
import language.Union;

public class Gauntlet extends Node{
	private Difference halfCut;
	private float t;
	private float interval;
	private float width;
	private float velcroWidth;
	private ArrayList<Float> circs;
	private float maxCirc;
	private float maxR;
	
	Gauntlet(float t,float interval, float width, ArrayList<Float> circs) {
		super();
		this.t=t;
		this.interval= interval;
		this.velcroWidth = interval -2*t;
		this.circs = circs;
		this.maxCirc = Collections.max(circs);
		this.maxR = maxCirc/((float) (2*Math.PI));
		this.width = width;
		
		ArrayList<Node> shells = new ArrayList<Node>(circs.size());
		for(int i=0; i<circs.size()-1; i++){//build shells
			Translate translateShell = new Translate(this.shell(circs.get(i),circs.get(i+1)), 0,0,i*interval);
			shells.add(translateShell);
		}
		Union shell = new Union(shells);//union shells
		Cube cut = new Cube(2*maxR+2*t,maxR+t, circs.size()*interval);
		Translate translateCut = new Translate(cut, -1*(maxR+t), -1*(maxR+t), 0);
		ArrayList<Node> set = new ArrayList<Node>(2);
		set.add(shell);
		set.add(translateCut);
		halfCut = new Difference(set);
	}
	
	private Difference shell(float circ1, float circ2){
		Difference shell = new Difference(new ArrayList<Node>());
		shell.addChild(this.rectCyl(circ1, circ2));//outer
		shell.addChild(new Cylinder((double)circ1,(double)circ2,interval));//inner
		shell.addChild(new Translate(new Cube(maxR*2+2*t,2*t, this.velcroWidth),-maxR-t, t, t));//velcroslot
		return shell;
	}
	private Union rectCyl(float circ1, float circ2){
		Union rectCyl = new Union(new ArrayList<Node>());
		rectCyl.addChild(new Cylinder((double)circ1+2*Math.PI*t,(double)circ2+2*Math.PI*t,interval));//cyl
		rectCyl.addChild(new Translate(new Cube(width, maxR+t,interval), -width/2, 0,0));//rect
		return rectCyl;
	}
	
	@Override
	public String encode() {
		return halfCut.encode();
	}
	
	public static void main(String[] args){
		float t= 3;
		float intv =30;
		float width = 40;
		switch(Integer.parseInt(args[0])){
			case 0:
				ArrayList<Float> elaineCircs = new ArrayList<Float>(8);
				elaineCircs.add(280f);
				elaineCircs.add(270f);
				elaineCircs.add(262f);
				elaineCircs.add(240f);
				elaineCircs.add(225f);
				elaineCircs.add(200f);
				elaineCircs.add(165f);
				elaineCircs.add(155f);
				Gauntlet elaine = new Gauntlet(t,intv, width, elaineCircs);
				SCADWriter.writeSCAD(elaine.encode(), "ElaineGauntlet");
				break;
			case 1:
				ArrayList<Float> megCircs = new ArrayList<Float>(8);
//				megCircs.add(220f);
//				megCircs.add(230f);
//				megCircs.add(230f);
//				megCircs.add(220f);
				megCircs.add(200f);
				megCircs.add(170f);
				megCircs.add(160f);
				megCircs.add(150f);
				Gauntlet megan = new Gauntlet(t,intv, width, megCircs);
				SCADWriter.writeSCAD(megan.encode(), "MeganGauntlet");
				break;
			default:
				break;
		}
		
		
	}
	
}
