
public class Codes {

	public static String importSTL(String file){
		return "import(\""+file+"\",3)";
	}
	public static String cube(float x, float y, float z){
		return "cube(["+x+","+y+","+z+"])";		
	}
	public static String cylinder(float r, float h){
		return "cylinder(r="+r+",h="+h+")";
	}
	public static String scale(float x, float y, float z, String scaled){
		return "scale(["+x+","+y+","+z+"]) "+scaled;
	}
	public static String translate(float x, float y, float z, String translated){
		return "translate(["+x+","+y+","+z+"]) "+translated;
	}
	public static String rotate(float x, float y, float z, String rotated){
		return "rotate(["+x+","+y+","+z+"]) "+rotated;
	}
	public static String endLine(String line){
		return line+";";
	}
	public static String multiLine(String[] lines){
		String result="";
		for(String line: lines){
			result+=Codes.endLine(line)+"\n";
		}
		return result;
	}
	public static String union(String[] lines){
		return "union(){\n"+Codes.multiLine(lines)+"}";
	}
	public static String difference(String[] lines){
		return "difference(){\n"+Codes.multiLine(lines)+"}";
	}
	public static String intersection(String[] lines){
		return "intersection(){\n"+Codes.multiLine(lines)+"}";
	}
	public static String minkowski(String[] lines){
		return "minkowski(){\n"+Codes.multiLine(lines)+"}";
	}
	
	public static void main(String[] args){//0: input, 1: stl filename// all tests are succesfull
		String[] lines=null;
		String[] mlines=null;
		switch(Integer.parseInt(args[0])){
		case 0: //importStl//success
			lines = new String[1];
			lines[0] =Codes.importSTL(args[1]);			
			break;
		case 1://cube//success
			lines= new String[1];
			lines[0] =Codes.cube(10, 20, 30);
			break;
		case 2://cylinder
			lines= new String[1];
			lines[0] =Codes.cylinder(10, 20);
			break;
		case 3://scale
			lines= new String[1];
			lines[0]= Codes.scale(2, 3, 4, Codes.cylinder(10, 20));
			break;
		case 4://translate
			lines= new String[1];
			lines[0]= Codes.translate(2, 3, 4, Codes.cylinder(10, 20));
			break;
		case 5://rotate
			lines= new String[1];
			lines[0]= Codes.translate(2, 3, 4, Codes.cube(10, 20, 30));
			break;
		case 6://endline
			lines= new String[1];
			lines[0]= Codes.endLine(Codes.translate(2, 3, 4, Codes.cube(10, 20, 30)));
			break;
		case 7://multiline
			mlines= new String[3];
			mlines[0] =Codes.cube(10, 20, 30);
			mlines[1] =Codes.cylinder(10, 20);
			mlines[2]= Codes.scale(2, 3, 4, Codes.cylinder(10, 20));
			lines= new String[1];
			lines[0]= Codes.multiLine(mlines);
			break;
		case 8://union
			mlines= new String[2];
			mlines[0] =Codes.cube(10, 20, 30);
			mlines[1] =Codes.cylinder(10, 20);
			lines= new String[1];
			lines[0]= Codes.union(mlines);
			break;
		case 9://difference
			mlines= new String[2];
			mlines[0] =Codes.cube(10, 20, 30);
			mlines[1] =Codes.cylinder(10, 20);
			lines= new String[1];
			lines[0]= Codes.difference(mlines);
			break;
		case 10://intersection
			mlines= new String[2];
			mlines[0] =Codes.cube(10, 20, 30);
			mlines[1] =Codes.cylinder(10, 20);
			lines= new String[1];
			lines[0]= Codes.intersection(mlines);
			break;
		case 11: //minkowski
			mlines= new String[2];
			mlines[0] =Codes.cube(10, 20, 30);
			mlines[1] =Codes.cylinder(10, 20);
			lines= new String[1];
			lines[0]= Codes.minkowski(mlines);
			break;
		}
		SCADWriter.writeSCAD(lines, "CodesTest");
	}
	
	
}
