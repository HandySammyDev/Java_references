package Test2;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    GridBagConstraints constraints = new GridBagConstraints();
    public void createTextFields(){
        for(int i=0; i<1; i++){
            JTextField textField = new JTextField();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1.0;
            constraints.ipady = 30;
            constraints.ipadx = 50;
            constraints.gridy = 100;
            this.add(textField,constraints);
        }
    }

    TopPanel(){
        this.setBackground(Color.red);
        this.setLayout(new GridBagLayout());

        createTextFields();
    }
}
