package demos;

import inputOutput.SCADWriter;
import language.Union;
import  prostheticSystem.System;

public class GripKnife extends System{

	public GripKnife() {
		super(new BrettGrip(), new KnifeAssist());
	}	

	public static void main(String[] args){
		GripKnife system = new GripKnife();
		Union lockTool = system.ArmToToolCenter(5);
		SCADWriter.writeSCAD(lockTool.encode(), "BrettGripKnife");//grip is upside down
	}
}
