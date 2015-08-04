package prostheticSystem;

import java.util.ArrayList;

import arms.Arm;
import arms.Gauntlet;
import connection.BackSide;
import connection.Base;
import connection.ConnectionBlock;
import connection.FrontSide;
import connection.LeftSide;
import connection.RightSide;
import connection.Top;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.Union;
import locking.BrettLock;
import locking.LockingMechanism;
import locking.MagnetBE;
import tools.KnifeAssist;
import tools.RotationNub;
import tools.Tool;

public class System {
	// TODO: Don't assume correct rotation
	public Arm arm;
	public LockingMechanism lm;
	public Tool tool;
	public ConnectionBlock armC;
	public ConnectionBlock lockC;
	public ConnectionBlock keyC;
	public ConnectionBlock toolC;
	public System(Arm a, LockingMechanism l, Tool t, int armSide, int lockSide, double height) {
		arm = a;
		lm = l;
		tool = t;
		armtToKey(armSide,height);
		lockToTool(lockSide,height);
	}
	public System(LockingMechanism l, Tool t, int lockSide, double height){
		arm=null;
		lm =l;
		tool = t;
		lockToTool(lockSide,height);
	}

	public Union armtToKey(int armSide, double height) {
		switch (armSide) {
		case 0:// base
			armC = new Base(arm, height);
			keyC = new Top(lm.key, height);
			break;
		case 1:// left
			armC = new LeftSide(arm, height);
			keyC = new RightSide(lm.key, height);
			break;
		case 2:// top
			armC = new Top(arm, height);
			keyC = new Base(lm.key, height);
			break;
		case 3:// right
			armC = new RightSide(arm, height);
			keyC = new LeftSide(lm.key, height);
			break;
		case 4:// back
			armC = new BackSide(arm, height);
			keyC = new FrontSide(lm.key, height);
			break;
		case 5:// front
			armC = new FrontSide(arm, height);
			keyC = new BackSide(lm.key, height);
			break;
		}
		try {
			return armC.connectOpposite(keyC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Union lockToTool(int lockSide, double height) {
		switch (lockSide) {
		case 0:// base
			lockC = new Base(lm.lock, height);
			toolC = new Top(tool, height);
			break;
		case 1:// left
			lockC = new LeftSide(lm.lock, height);
			toolC = new RightSide(tool, height);
			break;
		case 2:// top
			lockC = new Top(lm.lock, height);
			toolC = new Base(tool, height);
			break;
		case 3:// right
			lockC = new RightSide(lm.lock, height);
			toolC = new LeftSide(tool, height);
			break;
		case 4:// back
			lockC = new BackSide(lm.lock, height);
			toolC = new FrontSide(tool, height);
			break;
		case 5:// front
			lockC = new FrontSide(lm.lock, height);
			toolC = new BackSide(tool, height);
			break;
		}
		try {
			return toolC.connectOpposite(lockC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		KnifeAssist knifeA = new KnifeAssist();
		double r=10;
		double pr=2;
		double h=30;
		double sr=5; 
		double sh=40;
		BrettLock lock = new BrettLock(r,pr,h,sr,sh);
		System system = new System(lock, knifeA, 0, 5);
		Union lockTool = system.lockToTool(0, 5);
		SCADWriter.writeSCAD(lockTool.encode(), "BrettLockKnife");
		
		
	}

}
