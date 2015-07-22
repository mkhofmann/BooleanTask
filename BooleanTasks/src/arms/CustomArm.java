package arms;

import language.STL;
import language.Translate;

public class CustomArm extends Arm{
	private double xdim;
	private double ydim;
	private double zdim;
	//Zero is distance from lower left back edge to 0 in modeling program
	//Essential where inside the model is the origin
	private double xZero;
	private double yZero;
	private double zZero;
	
	public CustomArm(String stl, double x, double y, double z, double xz, double yz, double zz){
		super();
		super.arm = new STL(stl);
	}
	
	public void translate(){//TODO: Block translation of this model without adjusting Zero values
		//TODO: add instanceof case to translate program.
	}
	
	public void Zero(){
		//TODO: Implement
		//Zero inside model
		
	}
	
	public void Center(){
		//TODO: implement
	}
	@Override
	public Translate lowerCenter() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
