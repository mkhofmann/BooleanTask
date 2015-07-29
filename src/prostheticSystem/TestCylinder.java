package prostheticSystem;

import language.Cylinder;

public class TestCylinder extends SCADModel {
	public TestCylinder() {
		super(new Cylinder(10,20), new SizingBlock(20,20,20,-10,-10,0));
	}

}
