package prostheticSystem;

import arms.Arm;
import connection.Base;
import connection.ConnectionBlock;
import connection.LeftSide;
import connection.Top;
import language.Union;
import locking.LockingMechanism;
import tools.Tool;

public class System {
	//TODO: Don't assume correct rotation
	private Arm arm;
	private LockingMechanism lm;
	private Tool tool;
	
	public System(Arm a, LockingMechanism l, Tool t){
		arm =a;
		lm=l;
		tool=t;
	}
	
	public Union ArmTopToKeyBottom(double h){
		Top armT = new Top(arm,h);
		Base keyB = new Base(lm.key,h);
		return armT.attach(keyB);
	}
	//TODO:add connections as we need them basic face to face union
	
	
	
}
