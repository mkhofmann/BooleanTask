package connection;

import java.util.ArrayList;

import inputOutput.SCADWriter;
import language.Coordinate;
import language.Cube;
import language.Union;
import prostheticSystem.SCADModel;
import prostheticSystem.TestCube;
import language.Node;
import language.Translate;
public class ConnectionBlock {
	
	private SCADModel model;
	private Translate block;
	private Coordinate size;
	private Coordinate Origin;
	
	public ConnectionBlock(SCADModel m, Coordinate s, Coordinate o){
		model =m;
		Origin = o;
		size =s;
		block = new Translate(new Cube(size),o);
	}
	
	public Union blockModel(){
		Union u = new Union(new ArrayList<Node>(2));
		u.addChild(block);
		u.addChild(model.translater);
		return u;
	}
	
	public void addPosition(Coordinate c){
		block.addToC(c);
	}
	public void setPosition(Coordinate c){
		block.setC(c);
	}
	public void reSize(Coordinate s){
		block.setChild(new Cube(s));
		size =s;
	}
	public void extendZ(double e){
		this.reSize(new Coordinate(size.x, size.y, size.z+e));
	}
	public void extendY(double e){
		this.reSize(new Coordinate(size.x, size.y+e, size.z));
	}
	public void extendX(double e){
		this.reSize(new Coordinate(size.x+e, size.y, size.z));
	}
	
	public void dragModel(Coordinate t){
		model.addTranslate(t);
		block.addToC(t);
	}
	
	public void dragModelTo(Coordinate l){
		Coordinate start = block.c;
		this.setPosition(l);
		Coordinate diff = new Coordinate(l.x-start.x, l.y-start.y, l.z-start.z);
		model.addTranslate(diff);
	}
	
	public Union attach(ConnectionBlock other){
		Union u = blockModel();
		other.dragModelTo(Origin);
		u.addChild(other.blockModel());
		return u;		
	}
	
	public String encodeBlockModel(){
		return blockModel().encode();
	}
	
	public static void main(String[] args){
		TestCube model = new TestCube();
		Coordinate size = new Coordinate(5,20,30);
		Coordinate l = new Coordinate(20,5,5);
		ConnectionBlock test = new ConnectionBlock(model,size,l);
		SCADWriter.writeSCAD(test.encodeBlockModel(), "TestConnection");
	}
	
}
