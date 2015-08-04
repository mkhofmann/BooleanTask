package connection;

import language.Coordinate;
import language.Union;
import prostheticSystem.SCADModel;

public class FrontSide extends ConnectionBlock {

	public FrontSide(SCADModel m, double d) {
		super(m, new Coordinate(m.size.size.x,d, m.size.size.z), m.size.location);
	}
	
	public void extend(double e){
		super.extendY(e);
		super.addPosition(new Coordinate(0,-e,0));
	}
	
	@Override
	public Union connectOpposite(ConnectionBlock o) throws Exception {
		if(o instanceof BackSide)
			return super.attach(o);
		else throw new Exception("Invalid Side");
	}

}
