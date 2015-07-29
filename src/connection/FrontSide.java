package connection;

import language.Coordinate;
import prostheticSystem.SCADModel;

public class FrontSide extends ConnectionBlock {

	public FrontSide(SCADModel m, double d) {
		super(m, new Coordinate(m.size.size.x,d, m.size.size.z), m.size.location);
	}
	
	public void extend(double e){
		super.extendY(e);
		super.addPosition(new Coordinate(0,-e,0));
	}

}
