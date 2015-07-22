import inputOutput.SCADWriter;
import language.Cube;
import language.Cylinder;
import language.Difference;
import language.Intersection;
import language.Node;
import language.Rotate;
import language.Translate;
import language.Union;

public class Tasks {
	public static Node mold(Node model, float x, float y, float z){
		Difference diff = new Difference();
		diff.addChild(new Cube(x,y,z));
		diff.addChild(model);		
		return diff;
	}

	public static Node crop(Node model, float xZero, float yZero, float zZero, float x, float y, float z){
		Intersection inter = new Intersection();
		inter.addChild(new Translate(new Cube(x,y,z),xZero,yZero,zZero));
		inter.addChild(model);		
		return inter;
	}
	public static Node flatBottom(Node model, float x, float y, float z){
		Difference diff = new Difference();
		diff.addChild(model);	
		diff.addChild(new Translate(new Cube(x,y,z),0,0,-z));
		return diff;
	}
	public static Node platForm(Node model, float x, float y, float z){
		Union union = new Union();
		union.addChild(model);	
		union.addChild(new Translate(new Cube(x,y,z),0,0,-z));
		return union;
	}
	public static Node unionByPlatForm(Node model1, Node model2, float x, float y, float z){
		Union union = new Union();
		union.addChild(Tasks.platForm(model1, x, y, z));
		union.addChild(new Rotate(Tasks.platForm(model2, x, y, z), 180,0,0));
		return union;
	}
	
	public static void main(String args[]){//0: input, 1: stl filename// all tests are succesfull
		String code = "";
		switch(Integer.parseInt(args[0])){
		case 0://mold
			code = Tasks.mold(new Cylinder(2f,4f), 10, 5,10).encode();
			break;
		case 1://crop
			code = Tasks.crop(new Cylinder(2f,4f), 1,1,1,1,1,1).encode();
			break;
		case 2://flatBottom
			code = Tasks.flatBottom(new Cylinder(2f,4f), 10, 5,2).encode();
			break;
		case 3://platform
			code = Tasks.platForm(new Cylinder(2f,4f), 10, 5,2).encode();
			break;
		case 4://union by platform
			code = Tasks.unionByPlatForm(new Cylinder(2f,4f), new Cube(1,2,3), 10, 5,2).encode();
			break;
		default:
			break;
		}
		SCADWriter.writeSCAD(code, "TasksTest");
	}
}
