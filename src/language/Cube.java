package language;

public class Cube extends Model{
	private Coordinate size;
	public Cube(Coordinate s) {
		super("cube(["+s.x+","+s.y+","+s.z+"])");
		this.size=s;
	}
	public Cube(Coordinate s, boolean center){
		super("cube(["+s.x+","+s.y+","+s.z+"], center="+center+");");
		this.size=s;
	}
	public Cube(double x,double y, double z, boolean center){
		this(new Coordinate(x,y,z),center);
	}
	public Cube(double x, double y, double z){
		this(new Coordinate(x,y,z));
	}
	
	public Translate center(boolean xC, boolean yC, boolean zC){
		double halfX = size.x/2;
		double halfY= size.y/2;
		double halfZ= size.z/2;
		if(xC){
			if(yC){
				if(zC)//xyz
					return new Translate(this, -halfX,-halfY,-halfZ);
				return new Translate(this, -halfX, -halfY, 0);//XY
			}
			if(zC)//exclude Y
				return new Translate(this, -halfX, 0, -halfZ);
			return new Translate(this, -halfX,0,0);//X
		}
		if(yC){//exclude X
			if(zC)//YZ
				return new Translate(this,0,-halfY, -halfZ);
			return new Translate(this,0,-halfY,0);//Y
		}
		if(zC)
			return new Translate(this,0,0,-halfZ);
		return new Translate(this,0,0,0);
	}

}