package arms;

import java.util.ArrayList;
import java.util.Collections;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.Cube;
import language.Cylinder;
import language.Difference;
import language.Node;
import language.Translate;
import language.Union;
import prostheticSystem.SizingBlock;

public class Gauntlet extends Arm{
	private double t;
	private double interval;
	private double width;
	private double velcroWidth;
	private ArrayList<Double> circs;
	private double maxCirc;
	private double maxR;
	
	Gauntlet(double t,double interval, double width, ArrayList<Double> circs) {
		super(new Coordinate(0,0,0),new Coordinate(0,0,0));//place holder
		this.t=t;
		this.interval= interval;
		this.velcroWidth = interval -2*t;
		this.circs = circs;
		this.maxCirc = Collections.max(circs);
		this.maxR = maxCirc/(2*Math.PI);
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
		super.arm = new Difference(set);
		Coordinate s = new Coordinate(maxR*2,maxR,interval*circs.size());
		Coordinate l = new Coordinate(-maxR,0,0);
		super.size = new SizingBlock(s,l);
	}
	
	private Difference shell(double circ1, double circ2){
		Difference shell = new Difference(new ArrayList<Node>());
		shell.addChild(this.rectCyl(circ1, circ2));//outer
		shell.addChild(new Cylinder(circ1,circ2,interval, true));//inner
		shell.addChild(new Translate(new Cube(maxR*2+2*t,2*t, this.velcroWidth),-maxR-t, t, t));//velcroslot
		return shell;
	}
	private Union rectCyl(double circ1, double circ2){
		Union rectCyl = new Union(new ArrayList<Node>());
		rectCyl.addChild(new Cylinder(circ1+2*Math.PI*t,circ2+2*Math.PI*t,interval,true));//cyl
		rectCyl.addChild(new Translate(new Cube(width, maxR+t,interval), -width/2, 0,0));//rect
		return rectCyl;
	}
	
	@Override
	public Translate lowerCenter() {
		return new Translate(super.arm,0,0,-(this.circs.size()-1)*this.interval);
	}
	
	public static void main(String[] args){
		double t= 3;
		double intv =30;
		double width = 40;
		switch(Integer.parseInt(args[0])){
			case 0:
				ArrayList<Double> elaineCircs = new ArrayList<Double>(8);
				//elaineCircs.add(280.0);
				//elaineCircs.add(270.0);
				elaineCircs.add(262.0);
				elaineCircs.add(240.0);
				elaineCircs.add(225.0);
				elaineCircs.add(200.0);
				elaineCircs.add(165.0);
				elaineCircs.add(155.0);
				Gauntlet elaine = new Gauntlet(t,intv, width, elaineCircs);
				SCADWriter.writeSCAD(elaine.encode(), "ElaineGauntlet");
				break;
			case 1:
				ArrayList<Double> megCircs = new ArrayList<Double>(8);
				megCircs.add(220.0);
				megCircs.add(230.0);
				megCircs.add(230.0);
				megCircs.add(220.0);
				megCircs.add(200.0);
				megCircs.add(170.0);
				megCircs.add(160.0);
				megCircs.add(150.0);
				Gauntlet megan = new Gauntlet(t,intv, width, megCircs);
				SCADWriter.writeSCAD(megan.lowerCenter().encode(), "MeganGauntlet");
				break;
			default:
				break;
		}
		
		
	}


	
}