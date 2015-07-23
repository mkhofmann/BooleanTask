package arms;

import language.Node;
import language.Translate;

public abstract class Arm  {
  public Node arm;
  
  public Arm(){
	  
  }
  
  public abstract Translate lowerCenter();
  public String encode(){
	  return arm.encode();
  }
  
}