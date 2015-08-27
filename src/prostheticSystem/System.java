package prostheticSystem;

import arms.Arm;
import connection.Base;
import connection.ConnectionBlock;
import connection.Top;
import language.Union;
import locking.LockingMechanism;
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
	public System(Arm a, LockingMechanism l, Tool t, int armSide) {
		arm = a;
		lm = l;
		tool = t;
	}
	public System(LockingMechanism l, Tool t){
		arm=null;
		lm =l;
		tool = t;
	}
	public System(Arm a, Tool t){
		arm =a;
		lm =null;
		tool =t;
	}

	public Union armtToKey(int armSide, double height) {
		switch (armSide) {
		case 0:// base
			armC = arm.base(height);
			keyC = lm.key.top(height);
			break;
		case 1:// left
			armC = arm.left(height);
			keyC = lm.key.right(height);
			break;
		case 2:// top
			armC = arm.top(height);
			keyC = lm.key.base(height);
			break;
		case 3:// right
			armC = arm.right(height);
			keyC = lm.key.left(height);
			break;
		case 4:// back
			armC = arm.back(height);
			keyC = lm.key.front(height);
			break;
		case 5:// front
			armC = arm.front(height);
			keyC = lm.key.back(height);
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
			lockC = lm.lock.base(height);
			toolC = tool.top(height);
			break;
		case 1:// left
			lockC = lm.lock.left(height);
			toolC = tool.right(height);
			break;
		case 2:// top
			lockC = lm.lock.top(height);
			toolC = tool.base(height);
			break;
		case 3:// right
			lockC = lm.lock.right(height);
			toolC = tool.left(height);
			break;
		case 4:// back
			lockC = lm.lock.back(height);
			toolC = tool.front(height);
			break;
		case 5:// front
			lockC = lm.lock.front(height);
			toolC = tool.back(height);
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
	
	public Union LockToToolCenter(double height) {
		Top topLock = lm.lock.top(height);
		Base baseKnife = tool.base(height);
		return topLock.connectCenter(baseKnife);
	}
	
	public Union ArmToToolCenter(double height) {
		Top topArm = arm.top(height);
		Base baseTool = tool.base(height);
		return topArm.connectCenter(baseTool);
	}


}
