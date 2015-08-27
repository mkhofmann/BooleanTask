package connection;

import java.util.ArrayList;

import language.Node;
import language.Coordinate;
import language.Cube;
import language.Union;
import prostheticSystem.SCADModel;
import language.Translate;
public abstract class ConnectionBlock {
	
	public SCADModel model;
	private Translate block;
	public Coordinate size;
	public Coordinate Origin;
	
	public ConnectionBlock(SCADModel m, Coordinate s, Coordinate o){
		model =m;
		Origin = o;
		size =s;
		block = new Translate(new Cube(size),o);
	}
	
	public abstract Union connectOpposite(ConnectionBlock o) throws Exception;
	
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
	public Union attachNoBlock(ConnectionBlock other){
		Union u = new Union(new ArrayList<Node>(2));
		other.dragModelTo(Origin);
		this.dragModel(new Coordinate(0,0,this.size.z));
		u.addChild(this.model.translater);
		u.addChild(other.model.translater);
		return u;
	}
	
	public String encodeBlockModel(){
		return blockModel().encode();
	}
	
	
}
