import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		//final Manager man = new Manager(400,400,100000);
		Runnable r = new Runnable() {
            public void run() {
            	new Menu();
                //JOptionPane.showMessageDialog(null, board);
            }
        };
        
        SwingUtilities.invokeLater(r);
        
	}

}
