package connection;
import inputOutput.SCADWriter;
import language.Coordinate;
import language.Union;
import prostheticSystem.SCADModel;
import prostheticSystem.TestCylinder;

public class Top extends ConnectionBlock{

	public Top(SCADModel m, double h) {
		super(m, new Coordinate(m.size.size.x, m.size.size.y, h), new Coordinate(m.size.location.x, m.size.location.y, m.size.location.z + m.size.size.z-h));
	}
	
	public void extend(double e){
		super.extendZ(e);
	}
	
	public static void main(String args[]){
		TestCylinder model = new TestCylinder();
		Top test = new Top(model,4);
		TestCylinder model2 = new TestCylinder();
		model2.addTranslate(new Coordinate(10,10,10));
		Base testB = new Base(model2,4);
		testB.extend(2);
		Union u = test.attach(testB);
		SCADWriter.writeSCAD(u.encode(), "TestConnection");
	}
}
