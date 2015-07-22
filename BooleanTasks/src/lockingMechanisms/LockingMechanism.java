package lockingMechanisms;
import language.Node;
import language.Translate;

public abstract class LockingMechanism {
	protected Node lock;
	protected Node key;
	
	public LockingMechanism(){
		
	}
	
	protected abstract void makeLock();
	protected abstract void makeKey();
	public abstract Translate LowerCenterLock();
	public abstract Translate LowerCenterKey();
	
	public String encodeLock(){
		return lock.encode();
	}
	public String encodeKey(){
		return key.encode();
	}
	
	public String encodeMechanism(){
		return encodeLock() +"\n"+encodeKey();
	}
	
}
