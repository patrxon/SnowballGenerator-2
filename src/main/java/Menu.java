import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel mainPanel;
    private JPanel drawArea;
    private JTextField input;
    private JButton genButton;
    private Painter painter1;
    private JSpinner length;
    private JCheckBox auto;
    private Manager man;
    private JFrame frame;

    Menu() {
        frame = new JFrame("Main");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        input.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                if(auto.isSelected()){
                    man.ReInit(input.getText(), (Integer) length.getValue());
                    painter1.setJoints(man.getArray());
                    painter1.repaint();
                }
            }

            public void removeUpdate(DocumentEvent e) {
                if(auto.isSelected()){
                    man.ReInit(input.getText(), (Integer) length.getValue());
                    painter1.setJoints(man.getArray());
                    painter1.repaint();
                }
            }

            public void changedUpdate(DocumentEvent e) {
                if(auto.isSelected()){
                    man.ReInit(input.getText(), (Integer) length.getValue());
                    painter1.setJoints(man.getArray());
                    painter1.repaint();
                }
            }
        });

        length.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if(auto.isSelected()){
                    man.ReInit(input.getText(), (Integer) length.getValue());
                    painter1.setJoints(man.getArray());
                    painter1.repaint();
                }
            }
        });

        genButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                man.ReInit(input.getText(), (Integer) length.getValue());
                painter1.setJoints(man.getArray());               
                painter1.repaint();
            }
        });
    }

    private void createUIComponents() {
        man = new Manager(400, 400, 100000);

        drawArea = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        painter1 = new Painter(800, 800, man.getArray());
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
}
