package prostheticSystem;

import language.Coordinate;
import language.Intersection;
import language.Node;
import language.Scale;
import language.Translate;

public class SCADModel {
	private Node head;
	
	public SizingBlock size;
	
	private Translate translater;
	private Scale scaler;
	
	public SCADModel(Node model, SizingBlock s){
		size = s;
		head = model;
		scaler = new Scale(head);
		translater = new Translate(scaler);
		
	}
	
	public SizingBlock getSize() {
		return size;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Intersection checkSizing(){
		Intersection  chk = size.check();
		chk.addChild(head);
		return chk;
	}
	
	public String encodeSizeCheck(){
		return this.checkSizing().encode();
	}
	
	public void translate(Coordinate t){
		size.Translate(t);
		translater.setC(t);
	}
	
	public void Scale(Coordinate s){
		size.Scale(s);
		scaler.setC(s);
	}
	
	public String encode(){
		return translater.encode();
	}
	
	public void centerX(){
		this.zeroX();
		this.translate(new Coordinate(-this.size.size.x/2,0,0));
	}
	public void centerY(){
		this.zeroY();
		this.translate(new Coordinate(0,-this.size.size.y/2,0));
	}
	public void centerZ(){
		this.zeroZ();
		this.translate(new Coordinate(0,0,-this.size.size.z/2));
	}
	public void zeroX(){
		this.translate(new Coordinate(-this.size.location.x,0,0));
	}
	public void zeroY(){
		this.translate(new Coordinate(0,-this.size.location.y,0));
	}
	public void zeroZ(){
		this.translate(new Coordinate(0,0,-this.size.location.z));
	}
}
