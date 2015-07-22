import java.util.ArrayList;

public class Gauntlet extends Node{
	private DifferenceNode halfCut;
	
	Gauntlet(float t,float interval, int numIntervals, ArrayList<Float> circs) {
		super();
		
		ArrayList<Node> shells = new ArrayList<Node>(numIntervals);
		float maxCirc = circs.get(0);
		for(int i=0; i<numIntervals-1; i++){//build shells
			//Find max Circ
			if(maxCirc<circs.get(i+1))
				maxCirc = circs.get(i+1);
			//set Cylinders
			DifferenceNode shell = new DifferenceNode(new ArrayList<Node>());
			shell.addChild(new CylinderModelNode((double)circs.get(i)+2*Math.PI*t,(double)circs.get(i+1)+2*Math.PI*t,interval));//outer
			shell.addChild(new CylinderModelNode((double)circs.get(i),(double)circs.get(i+1),interval));//inner
			TranslateNode translateShell = new TranslateNode(shell, 0,0,i*interval);
			//add to Shells
			shells.add(translateShell);
		}
		UnionNode shell = new UnionNode(shells);//hull shells
		float maxR = maxCirc/((float) (2*Math.PI));
		CubeModelNode cut = new CubeModelNode(2*maxR+2*t,maxR+t, numIntervals*interval);
		TranslateNode translateCut = new TranslateNode(cut, -1*(maxR+t), -1*(maxR+t), 0);
		ArrayList<Node> set = new ArrayList<Node>(2);
		set.add(shell);
		set.add(translateCut);
		halfCut = new DifferenceNode(set);
	}
	@Override
	public String encode() {
		return halfCut.encode();
	}
	
	public static void main(String[] args){
		float t= 3;
		float intv =30;
		int numIntervals = 7;
		ArrayList<Float> elaineCircs = new ArrayList<Float>(8);
		elaineCircs.add(280f);
		elaineCircs.add(270f);
		elaineCircs.add(262f);
		elaineCircs.add(240f);
		elaineCircs.add(225f);
		elaineCircs.add(200f);
		elaineCircs.add(165f);
		elaineCircs.add(155f);
		Gauntlet elaine = new Gauntlet(t,intv, numIntervals, elaineCircs);
		SCADWriter.writeSCAD(elaine.encode(), "ElaineGauntlet");
		
	}
	
}