import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Painter extends JComponent{
	
	
	    
 	private ArrayList<Joint> joints;

 	Painter(int width, int height, ArrayList<Joint> joints){
        super();
        setPreferredSize(new Dimension(width,height));
        this.joints = joints;
    }
	
 	
 	
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
           
        for(int i=0; i<joints.size(); i++) {
        
        	if(joints.get(i).getColor() == 0)g.setColor(Color.blue);
        	else if(joints.get(i).getColor() == 1)g.setColor(Color.red);
        	else g.setColor(Color.black);
        	
            g.drawLine(
            	(int)400+(joints.get(i).getx1()-200)*5,
            	(int)400-(joints.get(i).gety1()-200)*5,
            	(int)400+(joints.get(i).getx2()-200)*5,
            	(int)400-(joints.get(i).gety2()-200)*5
                );
        }
        
        
    }
	
}
