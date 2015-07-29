package connection;

import language.Coordinate;
import prostheticSystem.SCADModel;

public class LeftSide extends ConnectionBlock{

	public LeftSide(SCADModel m, double d) {
		super(m, new Coordinate(d, m.size.size.y, m.size.size.z), m.size.location);
	}
	
	public void extend(double e){
		super.extendX(e);
		super.addPosition(new Coordinate(-e,0,0));
	}

}
