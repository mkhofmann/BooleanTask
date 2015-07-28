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

public class WidthArm extends Arm{
	private Difference halfCut;
	private double t;
	private double interval;
	private double width;
	private double velcroWidth;
	private double maxR;
	private ArrayList<Double> widths;

	public WidthArm(double t,double interval, double width, ArrayList<Double> widths) {
		super(new Coordinate(0,0,0), new Coordinate(0,0,0));
		this.t=t;
		this.interval= interval;
		this.velcroWidth = interval -2*t;
		this.maxR = Collections.max(widths)/2;
		this.width = width;
		this.widths=widths;
		
		ArrayList<Node> shells = new ArrayList<Node>(widths.size());
		for(int i=0; i<widths.size()-1; i++){//build shells
			Translate translateShell = new Translate(this.shell(widths.get(i),widths.get(i+1)), 0,0,i*interval);
			shells.add(translateShell);
		}
		Union shell = new Union(shells);//union shells
		Cube cut = new Cube(2*maxR+2*t,maxR+t, widths.size()*interval);
		Translate translateCut = new Translate(cut, -1*(maxR+t), -1*(maxR+t), 0);
		ArrayList<Node> set = new ArrayList<Node>(2);
		set.add(shell);
		set.add(translateCut);
		halfCut = new Difference(set);
		Coordinate s = new Coordinate(maxR*2,maxR,interval*widths.size());
		Coordinate l = new Coordinate(-maxR,0,0);
		super.size = new SizingBlock(s,l);
	}
	
	private Difference shell(double width1, double width2){
		double r1 = width1/2;
		double r2= width2/2;
		Difference shell = new Difference(new ArrayList<Node>());
		shell.addChild(this.rectCyl(width1, width2));//outer
		shell.addChild(new Cylinder(r1,r2,interval));//inner
		shell.addChild(new Translate(new Cube(maxR*2+2*t,2*t, this.velcroWidth),-maxR-t, t, t));//velcroslot
		return shell;
	}
	private Union rectCyl(double width1, double width2){
		double r1 = width1/2;
		double r2= width2/2;
		Union rectCyl = new Union(new ArrayList<Node>());
		rectCyl.addChild(new Cylinder(r1+t,r2+t,interval));//cyl
		rectCyl.addChild(new Translate(new Cube(width, maxR+t,interval), -width/2, 0,0));//rect
		return rectCyl;
	}

	@Override
	public String encode() {
		return halfCut.encode();
	}
	
	public static void main(String[] args){
		double t= 3;
		double intv =30;
		double width = 40;
		ArrayList<Double> megCircs = new ArrayList<Double>(8);
		megCircs.add(63.61);
		megCircs.add(63.60);
		megCircs.add(60.42);
		megCircs.add(54.43);
		megCircs.add(47.90);
		megCircs.add(43.55);
		megCircs.add(46.76);
		megCircs.add(50.80);
		WidthArm megan = new WidthArm(t,intv, width, megCircs);
		SCADWriter.writeSCAD(megan.encode(), "MeganGauntlet");
	}
	
}