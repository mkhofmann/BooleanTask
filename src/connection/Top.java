package connection;
import java.util.ArrayList;
import language.Node;
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
	
	public Union connectCenter(Base o){
		super.dragModelTo(new Coordinate());
		super.dragModel(new Coordinate(-super.model.size.size.x/2, -super.model.size.size.y/2,0));
		o.dragModelTo(new Coordinate());
		o.dragModel(new Coordinate(-o.size.x/2, -o.size.y/2, super.size.z));
		Union u = super.blockModel();
		u.addChild(o.blockModel());
		return u;
	}
	
	public Union connectCenterNoBlock(Base o){
		super.dragModelTo(new Coordinate());
		super.dragModel(new Coordinate(-super.model.size.size.x/2, -super.model.size.size.y/2,0));
		o.dragModelTo(new Coordinate());
		o.dragModel(new Coordinate(-o.size.x/2, -o.size.y/2, super.size.z));
		Union u = new Union(new ArrayList<Node>(2)); 
		u.addChild(super.model.translater);
		u.addChild(o.model.translater);
		return u;
	}
}
