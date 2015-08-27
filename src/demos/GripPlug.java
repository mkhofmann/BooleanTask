package demos;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.Union;
import prostheticSystem.System;
import tools.ADLBlock;

public class GripPlug extends System{

	public GripPlug(Coordinate s) {
		super(new BrettGrip(), new ADLBlock(s));
		
	}
	
	public static void main(String[] args){
		GripPlug system = new GripPlug(new Coordinate(20,20,80));
		Union lockTool = system.ArmToToolCenter(5);
		SCADWriter.writeSCAD(lockTool.encode(), "GripPlug");
	}

}
