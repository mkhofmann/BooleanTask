package prostheticSystem;

import java.util.ArrayList;

import language.Coordinate;
import language.Cube;
import language.Intersection;
import language.Node;
import language.Translate;

public class SizingBlock {
	public Coordinate size;
	public Coordinate location;//bottom left front corner 
	
	public SizingBlock(double x, double y, double z, double xl, double yl, double zl){
		this(new Coordinate(x,y,z), new Coordinate(xl,yl,zl));
	}
	
	public SizingBlock(double r, double h){
		this(r*2,r*2,h,-r,-r,h);
	}
	
	public SizingBlock(Coordinate s, Coordinate l){
		size=s;
		location =l;
	}
	
	public void Scale(Coordinate s){
		size = new Coordinate(size.x*s.x, size.y*s.y, size.z*s.z);
	}
	public void addTranslate(Coordinate t){
		location = new Coordinate(location.x+t.x, location.y+t.y, location.z+t.z);
	}
	public void setTranslate(Coordinate t){
		location = t;
	}
	
	public Intersection check(){
		Intersection chck = new Intersection(new ArrayList<Node>(2));
		chck.addChild(new Translate(new Cube(size),location));
		return chck;
	}
}
