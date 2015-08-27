package demos;

import connection.Base;
import connection.Top;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.Cube;
import language.STL;
import language.Translate;
import tools.Tool;

public class KnifeAssist extends Tool{
	private boolean debug = false;
	public KnifeAssist() {
		super(new Coordinate(41,44,25), new Coordinate(0,0,0));
		super.head = new STL("KNIFEGUARD.stl");
		if(debug)
			super.head = new Cube(41,44,25);
		super.scaler = new language.Scale(super.head,1,1,1);
		super.translater = new Translate(super.scaler,0,0,0);
	}
	
	@Override
	public Top top(double h){
		Top t = super.top(h);
		t.extendY(-20);
		return t;
	}
	@Override
	public Base base(double h){
		Base t = super.base(h);
		t.extendY(-20);
		return t;
	}
	
	
	public static void main(String[] args){
		KnifeAssist knife = new KnifeAssist();
		Top top = knife.top(5);
		top.dragModelTo(new Coordinate(10,20,30));
		SCADWriter.writeSCAD(top.encodeBlockModel(), "knife");
	}

}
