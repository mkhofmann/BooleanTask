
public class Tasks {
	public static String mold(String model, float x, float y, float z){
		String[] lines ={
				Codes.cube(x, y, z),
				model
		};
		return Codes.difference(lines);
	}
	public static String SliceModelXY(String model, float xBound, float yBound, float z){
		String[] intersectLower ={Codes.cube(xBound, yBound, z), model};

		String[] intersectUpper ={Codes.translate(0, 0, z, Codes.cube(xBound, yBound, z)),model};
		String[] lines ={
				Codes.translate(0, 0, -10, Codes.intersection(intersectLower)),
				Codes.translate(0, 0, 10, Codes.intersection(intersectUpper))
		};
		return Codes.multiLine(lines);
	}
	public static String SliceModelYZ(String model, float yBound, float zBound, float x){
		String[] intersectLower ={Codes.cube(x, yBound, zBound), model};

		String[] intersectUpper ={Codes.translate(x, 0, 0, Codes.cube(x, yBound, zBound)),model};
		String[] lines ={
				Codes.translate(-10, 0, 0, Codes.intersection(intersectLower)),
				Codes.translate(10, 0, 0, Codes.intersection(intersectUpper))
		};
		return Codes.multiLine(lines);
	}
	public static String SliceModelXZ(String model, float xBound, float zBound, float y){
		String[] intersectLower ={Codes.cube(xBound, y, zBound), model};

		String[] intersectUpper ={Codes.translate(0, y, 0, Codes.cube(xBound, y, zBound)),model};
		String[] lines ={
				Codes.translate(0, -10, 0, Codes.intersection(intersectLower)),
				Codes.translate(0, 10, 0, Codes.intersection(intersectUpper))
		};
		return Codes.multiLine(lines);
	}
	
	public static String crop(String model, float xZero, float yZero, float zZero, float x, float y, float z){
		String  result="";
		String[] lines ={
				Codes.translate(xZero,yZero,zZero, Codes.cube(x, y, z)), 
				model/*assume positioning*/
				};
		result+= Codes.intersection(lines);		
		return result;
	}
	public static String flatBottom(String model, float x, float y, float z){
		String result ="";
		String[] lines ={
				model/*assume positioning*/,
				Codes.translate(0,0,-z, Codes.cube(x, y, z))
				};
		result+= Codes.difference(lines);		
		return result;
	}
	public static String platForm(String model, float x, float y, float z){
		String result ="";
		String[] lines ={
				model/*assume positioning*/, 
				Codes.translate(0,0,-z, Codes.cube(x, y, z))
				};
		result+= Codes.union(lines);		
		return result;
	}
	public static String unionByPlatForm(String model1, String model2, float x, float y, float z){
		String result="";
		String[] lines ={
				Tasks.platForm(model1, x, y, z),
				Codes.rotate(180, 0, 0, Tasks.platForm(model2, x, y, z))
				};
		result+= Codes.union(lines);
		return result;
	}
	public static String platFormMinkowski(String model, float x, float y, float z, float zUp){
		String result ="";
		String[] minkowski ={
				Codes.translate(0,0,-z, Codes.cube(x, y, z)),
				Tasks.crop(model, 0, 0, 0, x, y, zUp)
				};
		String[] union ={
				model/*assume positioning*/,
				Codes.minkowski(minkowski)
				};
		result+= Codes.union(union);		
		return result;
	}
	public static String unionByPlatFormMinkowski(String model1, String model2, float x, float y, float z, float zUp){
		String result="";
		String[] lines ={
				Tasks.platFormMinkowski(model1, x, y, z, zUp),
				Codes.rotate(180, 0, 0, Tasks.platFormMinkowski(model2, x, y, z, zUp))
				};
		result+= Codes.union(lines);
		return result;
	}
	
	public static void main(String args[]){//0: input, 1: stl filename// all tests are succesfull
		String[] lines=null;
		switch(Integer.parseInt(args[0])){
		case 0://mold
			lines= new String[1];
			lines[0] = Tasks.mold(Codes.importSTL(args[1]),100,100,100);
			break;
		case 1://slice
			lines = new String[3];
			lines[0] = Tasks.SliceModelXY(Codes.importSTL(args[1]), 40, 40, 4);
			lines[1] = Tasks.SliceModelYZ(Codes.importSTL(args[1]), 40, 40, 4);
			lines[2] = Tasks.SliceModelXZ(Codes.importSTL(args[1]), 40, 40, 4);
			break;
		case 2://crop
			lines = new String[1];
			lines[0] = Tasks.crop(Codes.importSTL(args[1]), 0,0,0, 3, 6, 9);
			break;
		case 3://flatBottom
			lines = new String[1];
			lines[0] = Tasks.flatBottom(Codes.translate(0, 0, -3,Codes.importSTL(args[1])), 100, 100, 3);
			break;
		case 4://platform
			lines = new String[1];
			lines[0] = Tasks.platForm(Codes.importSTL(args[1]), 100, 100, 3);
			break;
		case 5://minkowski//concept not working, adapt in SCAD
			//TODO: Fix concept
			lines = new String[1];
			lines[0] = Tasks.platFormMinkowski(Codes.cylinder(10, 30), 100, 100, 3, 6);
			break;
		case 6://union platform
			lines = new String[1];
			lines[0] = Tasks.unionByPlatForm(Codes.importSTL(args[1]), Codes.cylinder(5, 10), 40, 40, 3);
			break;
		case 7: //union minkowski
			break;
		default:
			break;
		}
		SCADWriter.writeSCAD(lines, "TasksTest");
	}
}
