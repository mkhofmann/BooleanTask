package connection;

import language.Coordinate;
import prostheticSystem.SCADModel;

public class BackSide extends ConnectionBlock {

	public BackSide(SCADModel m, double d) {
		super(m, new Coordinate(m.size.size.x, d, m.size.size.z), new Coordinate( m.size.location.x,m.size.location.y + m.size.size.y-d, m.size.location.z));
	}
	
	public void extend(double e){
		super.extendY(e);
	}

}
