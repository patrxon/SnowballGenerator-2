import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

class Painter extends JPanel {
	    
 	private ArrayList<Joint> joints;

 	Painter(int width, int height, ArrayList<Joint> joints){
        super();
        setPreferredSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));

        this.joints = joints;
    }

    public void setJoints(ArrayList<Joint> joints){
 	    this.joints = joints;
    }


    public void paintComponent(Graphics g) {
 	    super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
           
        for(int i=0; i<joints.size(); i++) {
        
        	if(joints.get(i).getColor() == 0)g2d.setColor(Color.blue);
        	else if(joints.get(i).getColor() == 1)g2d.setColor(Color.red);
        	else g2d.setColor(Color.black);

            g2d.drawLine(
            	(int)400+(joints.get(i).getx1()-200)*5,
            	(int)400-(joints.get(i).gety1()-200)*5,
            	(int)400+(joints.get(i).getx2()-200)*5,
            	(int)400-(joints.get(i).gety2()-200)*5
                );
        }
        g2d.dispose();
        
    }
	
}
