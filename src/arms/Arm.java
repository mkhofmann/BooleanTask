package arms;

import language.Coordinate;
import language.Cube;
import language.Node;
import prostheticSystem.SCADModel;
import prostheticSystem.SizingBlock;

public abstract class Arm extends SCADModel  {
  public Node arm;
  
  public Arm(Coordinate s, Coordinate l){
	  super(new Cube(0,0,0) , new SizingBlock(s,l));//place holder
	  //CUBE will always get reset in 
  }

  public String encode(){
	  return arm.encode();
  }
  
  
  
}