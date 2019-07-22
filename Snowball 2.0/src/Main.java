import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		final Manager man = new Manager(400,400,100000);
		
		
		Runnable r = new Runnable() {
            public void run() {
            	
            	Painter board = new Painter(800,800, man.getArray());
                
                for (int ii=0; ii<30; ii++) {
                 
                }
                
                JOptionPane.showMessageDialog(null, board);
            }
        };
        
        SwingUtilities.invokeLater(r);
        
	}

}
