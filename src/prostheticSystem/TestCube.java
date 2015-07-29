package prostheticSystem;

import language.Cube;

public class TestCube extends SCADModel {

	public TestCube() {
		super(new Cube(20,30,40), new SizingBlock(20,30,40,0,0,0));
	}

}
