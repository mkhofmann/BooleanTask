package demos;

import inputOutput.SCADWriter;
import language.Union;
import prostheticSystem.System;

public class LockKnife extends System{

	public LockKnife(double r, double pr, double h, double sr, double sh) {
		super(new BrettLock(r,pr,h,sr,sh), new KnifeAssist());
	}	

	public static void main(String[] args){
		double r=10;
		double pr=2;
		double h=30;
		double sr=5; 
		double sh=40;
		LockKnife system = new LockKnife(r,pr,h,sr,sh);
		Union lockTool = system.LockToToolCenter(5);
		SCADWriter.writeSCAD(lockTool.encode(), "BrettLockKnife");
		//TODO:success! Print
	}
}
