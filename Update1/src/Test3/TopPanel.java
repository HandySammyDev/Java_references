package Test3;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public void createTextFields(){
        for(int i=0; i<1; i++){
            JTextField textField = new JTextField();
            //textField.setPreferredSize(new Dimension(100,0));
            textField.setMinimumSize(new Dimension(50,25));
            textField.setPreferredSize(new Dimension(50,25));
            textField.setMaximumSize(new Dimension(50,100));
            //textField.setAlignmentY(BOTTOM_ALIGNMENT);
            this.add(textField);
        }
    }

    TopPanel(){
        this.setBackground(Color.red);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,100)));
        //this.add(Box.createVerticalBox());

        createTextFields();
    }
}
