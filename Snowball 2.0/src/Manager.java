import java.util.ArrayList;

public class Manager {

	private int sizex;
	private int sizey;
	private int posx;
	private int posy;
	
	private int lastDir = 4;
	
	private Space grid;
	
	private ArrayList<Joint> joints = new ArrayList<Joint>();
	
	private CodeGenerator NGen = new CodeGenerator();
	
	private String code = NGen.getCode();
	
	Manager(int sizex, int sizey, int length) {
		this.sizex = sizex;
		this.sizey = sizey;
		grid = new Space(sizex,sizey);
		
		posx = sizex/2;
		posy = sizey/2;
		
		Startup();
		Generate(length);
		//test();
		
	}

	void ReInit(String newCode, int length){
		joints.clear();
		NGen = new CodeGenerator(newCode);
		code = NGen.getCode();
		grid = new Space(sizex,sizey);

		posx = sizex/2;
		posy = sizey/2;

		Startup();
		Generate(length);
	}


	void Startup() {
		
		joints.add(new Joint(posx,posy,posx,posy+1,-1));
		grid.get(posx, posy).take();
		posy++;
		grid.get(posx, posy).take();
		
	}
	
	void Generate(int length) {
		
		for(int i=1; i<length; i++) {
			
			if(code.charAt(i%code.length()) == '1') SearchR();
			else SearchL();
			
		}
	}
	
	
	void SearchR() {
		
		Pair best = getPos(-1,posx,posy);
		
		for(int i=lastDir+1; i<lastDir+8; i++) {
		
			Pair temp = getPos(i%8,posx,posy);
			
			//System.out.println(":" + i%8 + " " + posx + " " + posy + "|" + temp.x() + " " + temp.y());
				
			if( grid.get(temp.x(), temp.y()).isopen()){
					best = temp;		
			} 
				
		}
		
		
		grid.get(best.x(), best.y()).take();
		
		joints.add(new Joint(posx,posy,best.x(),best.y(),1));
		
		lastDir = (getDir(posx,posy,best.x(),best.y())+4)%8; 
		
		//System.out.println("B:" + lastDir + " " + posx + " " + posy + "|" + best.x() + " " + best.y() + "\n");
		
		posx = best.x(); 
		posy = best.y();	
	
	}
	 
	void SearchL() {
		
		Pair best = getPos(-1,posx,posy);
		
		for(int i=lastDir+7; i>lastDir; i--) {
		
			Pair temp = getPos(i%8,posx,posy);
			
			//System.out.println(":" + i%8 + " " + posx + " " + posy + "|" + temp.x() + " " + temp.y());
				
			if( grid.get(temp.x(), temp.y()).isopen()){
					best = temp;		
			} 
				
		}
		
		
		grid.get(best.x(), best.y()).take();
		
		joints.add(new Joint(posx,posy,best.x(),best.y(),0));
		
		lastDir = (getDir(posx,posy,best.x(),best.y())+4)%8; 
		
		//System.out.println("B:" + lastDir + " " + posx + " " + posy + "|" + best.x() + " " + best.y() + "\n");
		
		posx = best.x(); 
		posy = best.y();
	}
	
	void test() {
		
		for(int i=0; i<joints.size(); i++) {
			
			System.out.println(joints.get(i).getx1() + " " + joints.get(i).gety1());
			
		}
		
	}
	
	ArrayList<Joint> getArray() {
		return joints;
	}
	
	Pair getPos(int nr,int x, int y) {
		
		switch(nr) {
		
			case 0: return new Pair(x,y+1);
			case 1: return new Pair(x+1,y+1);
			case 2: return new Pair(x+1,y);
			case 3: return new Pair(x+1,y-1);
			case 4: return new Pair(x,y-1);
			case 5: return new Pair(x-1,y-1);
			case 6: return new Pair(x-1,y);
			case 7: return new Pair(x-1,y+1);
			default: return new Pair(x,y);
			
		}		
	}
	
	int getDir(int x1, int y1, int x2, int y2) {
		
		int value = x2-x1 + (y2-y1)*3;
		
		switch(value) {
		
			case 3: return 0;
			case 4: return 1;
			case 1: return 2;
			case -2: return 3;
			case -3: return 4;
			case -4: return 5;
			case -1: return 6;
			case 2: return 7;
			default: return 0;
		
		}	
		
	}
	
	
}
