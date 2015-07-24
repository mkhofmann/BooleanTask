package locking;
import language.Coordinate;
import language.Cylinder;
import language.Node;
import prostheticSystem.SCADModel;

public abstract class LockingMechanism{
	protected SCADModel lock;
	protected SCADModel key;
	
	
	public static final double MAGD = 9;
	public static final double MAGR = MAGD/2;
	public static final double MAGH = 10;
	
	public LockingMechanism(){
	}
	
	protected abstract void makeLock();
	protected abstract void makeKey();
	
	public void LowerCenterLock(){
		lock.centerX();
		lock.centerY();
		lock.zeroZ();
		lock.translate(new Coordinate(0,0,-lock.getSize().size.z));
	}
	public void LowerCenterKey(){
		key.centerX();
		key.centerY();
		key.zeroZ();
		key.translate(new Coordinate(0,0,-lock.getSize().size.z));
	}
	
	public String encodeLock(){
		return lock.encode();
	}
	public String encodeKey(){
		return key.encode();
	}
	
	public String encodeMechanism(){
		return encodeLock() +"\n"+encodeKey();
	}
	
	public Node magnet(){
		return new Cylinder(MAGR, MAGH);
	}
	
}