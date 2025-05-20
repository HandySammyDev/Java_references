package Test1;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    GridBagConstraints constraints = new GridBagConstraints();
    public void createTextFields(){
        for(int i=0; i<1; i++){
            JTextField textField = new JTextField();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weighty = 1.0;
            constraints.weightx = 2.0;
            constraints.ipady = 30;
            constraints.anchor = GridBagConstraints.SOUTH;
            topPanel.add(textField, constraints);
        }
    }

    Window(){
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,500);
        this.setLocationRelativeTo(null);

        topPanel.setBackground(Color.red);
        topPanel.setLayout(new GridBagLayout());

        createTextFields();

        this.add(topPanel);
        this.add(bottomPanel);
        this.setVisible(true);
    }
}
