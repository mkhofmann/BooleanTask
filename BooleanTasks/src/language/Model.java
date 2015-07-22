package language;

public class Model extends Node {
	public String model;
	Model(String m) {
		super();
		model =m;
	}
	
	
	public String encode(){
		return model +";";
	}

}
