package connection;

import language.Coordinate;
import prostheticSystem.SCADModel;

public class RightSide extends ConnectionBlock {

	public RightSide(SCADModel m, double d) {
		super(m, new Coordinate(d, m.size.size.y, m.size.size.z), new Coordinate(m.size.location.x + m.size.size.x-d, m.size.location.y, m.size.location.z));
	}
	
	public void extend(double e){
		super.extendX(e);
	}

}
