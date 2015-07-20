import java.util.List;

public abstract class Model {
	private String code ="";
	private float xLoc =0;
	private float yLoc =0;
	private float zLoc=0;
	private float xAngle =0;
	private float yAngle =0;
	private float zAngle =0;
	private float xScale =0;
	private float yScale =0;
	private float zScale =0;
	private List<Model> models;
	
	public void translate(float x, float y, float z){
		xLoc+=x;
		yLoc+=y;
		zLoc+=z;
	}
	public void rotate(float x, float y, float z){
		xAngle+=x;
		yAngle+=y;
		zAngle+=z;
	}
	public void scaleUp(float x, float y, float z){
		xScale+=x;
		yScale+=y;
		zScale+=z;
	}
	public void scaleDown(float x, float y, float z){
		xScale-=x;
		yScale-=y;
		zScale-=z;
	}
	public void enCode(){
	
	}
	
	public String toString(){
		return code;
	}
	
}
