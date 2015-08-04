package connection;

import language.Coordinate;
import language.Union;
import prostheticSystem.SCADModel;

public class RightSide extends ConnectionBlock {

	public RightSide(SCADModel m, double d) {
		super(m, new Coordinate(d, m.size.size.y, m.size.size.z), new Coordinate(m.size.location.x + m.size.size.x-d, m.size.location.y, m.size.location.z));
	}
	
	public void extend(double e){
		super.extendX(e);
	}
	
	@Override
	public Union connectOpposite(ConnectionBlock o) throws Exception {
		if(o instanceof LeftSide)
			return super.attach(o);
		else throw new Exception("Invalid Side");
	}

}
