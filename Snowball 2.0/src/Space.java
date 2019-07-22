
public class Space {

	private int maxx;
	private int maxy;
	
	private Cell tab[][]; 
	
	
	Space(int x,int y) {
		maxx = x;
		maxy = y;
		
		tab = new Cell[x][y];
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				tab[i][j] = new Cell();
			}
		}
			
	}
	
	public Cell get(int x, int y) {
		
		try{
			return tab[x][y];
		}
		catch (Exception e){
			return tab[0][0];
		}
	}
	
	
}
