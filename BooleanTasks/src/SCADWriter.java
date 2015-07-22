import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SCADWriter {
	public static void writeSCAD(String[] lines, String filename){
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename+".scad");
			for(String line: lines){
				writer.println(line);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeSCAD(String code, String filename){
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename+".scad");
			writer.println(code);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
