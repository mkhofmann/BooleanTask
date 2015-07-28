package prostheticSystem;

import language.Coordinate;

public class ConnectionBlock {
	
	private SCADModel model;
	private SizingBlock size;
	private Coordinate freeOrigin;
	
	public ConnectionBlock(SCADModel m, Coordinate origin, Coordinate free, Coordinate s){
		model =m;
		freeOrigin = free;
		this.size = new SizingBlock(s, origin);
	}
	
	public SCADModel unionToBlock(ConnectionBlock other){
		return model;
		
	}
	
	public SCADModel unionModels(ConnectionBlock other){
		return model;
		
	}
	
	public void dragTo(Coordinate c){
		
	}
	
	public String encode(){
		return null;
		
	}
	
	
}
