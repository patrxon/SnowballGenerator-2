import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel mainPanel;
    private JPanel drawArea;
    private JTextField input;
    private JButton genButton;
    private Painter painter1;
    private Manager man;
    private JFrame frame;

    Menu(){
        frame = new JFrame("Main");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        genButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                man.ReInit(input.getText(),100);
                painter1.setJoints(man.getArray());
                painter1.repaint();
            }
        });
    }

    private void createUIComponents(){
        man = new Manager(400,400,100000);

        drawArea = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        painter1 = new Painter(800,800, man.getArray());
    }

}
