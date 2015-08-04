package tools;

import language.Coordinate;
import language.Cube;
import prostheticSystem.SCADModel;
import prostheticSystem.SizingBlock;

public abstract class Tool extends SCADModel{
	  
	  public Tool(Coordinate s, Coordinate l){
		  super(new Cube(0,0,0) , new SizingBlock(s,l));//place holder
		  //CUBE will always get reset in 
	  }

	  public String encode(){
		  return head.encode();
	  }
	  
}
