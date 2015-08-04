package connection;
import language.Coordinate;
import language.Union;
import prostheticSystem.SCADModel;

public class Top extends ConnectionBlock{

	public Top(SCADModel m, double h) {
		super(m, new Coordinate(m.size.size.x, m.size.size.y, h), new Coordinate(m.size.location.x, m.size.location.y, m.size.location.z + m.size.size.z-h));
	}
	
	public void extend(double e){
		super.extendZ(e);
	}
	
	@Override
	public Union connectOpposite(ConnectionBlock o) throws Exception {
		if(o instanceof Base)
			return super.attach(o);
		else throw new Exception("Invalid Side");
	}
}
