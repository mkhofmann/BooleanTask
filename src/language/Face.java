package language;

import java.util.ArrayList;

public class Face {
	public ArrayList<Integer> points;
	
	public Face(ArrayList<Integer> p){
		points =p;
	}
	public Face(int x, int y, int z){
		ArrayList<Integer> p = new ArrayList<Integer>(3);
		p.add(x);
		p.add(y);
		p.add(z);
		points=p;
	}
	public Face(int w, int x, int y, int z){
		ArrayList<Integer> p = new ArrayList<Integer>(4);
		p.add(w);
		p.add(x);
		p.add(y);
		p.add(z);
		points=p;
	}
	
	public String encode(){
		String r = "[";
		for(int i=0; i<points.size()-1; i++){
			r+=points.get(i)+",";
		}
		r+=points.get(points.size()-1)+"]";
		return r;
	}
}
