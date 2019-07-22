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
