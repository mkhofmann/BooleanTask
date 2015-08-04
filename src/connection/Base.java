package connection;
import language.Coordinate;
import language.Union;
import prostheticSystem.SCADModel;

public class Base extends ConnectionBlock{

	public Base(SCADModel m, double h) {
		super(m, new Coordinate(m.size.size.x, m.size.size.y, h), m.size.location);
	}
	

	public void extend(double e){
		super.extendZ(e);
		super.addPosition(new Coordinate(0,0,-e));
	}

	@Override
	public Union connectOpposite(ConnectionBlock o) throws Exception {
		if(o instanceof Top)
			return super.attach(o);
		else throw new Exception("Invalid Side");
	}
}
