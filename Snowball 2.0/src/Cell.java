
public class Cell {

	private boolean open=true; 
	
	public boolean isopen() {
		return open;
	}
	
	public void take() {
		
		if(open) open = false;
	}
	
	
}
