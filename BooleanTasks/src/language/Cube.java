package language;

public class Cube extends Model{
	private float x;
	private float y;
	private float z;
	public Cube(float x, float y, float z) {
		super("cube(["+x+","+y+","+z+"])");
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public Cube(float x, float y, float z, boolean center){
		super("cube(["+x+","+y+","+z+"], center="+center+");");
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public Translate center(boolean xC, boolean yC, boolean zC){
		float halfX = x/2;
		float halfY= y/2;
		float halfZ= z/2;
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
