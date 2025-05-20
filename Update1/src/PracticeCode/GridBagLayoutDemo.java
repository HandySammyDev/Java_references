package PracticeCode;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo extends JFrame {
    public GridBagLayoutDemo(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        final boolean shouldfill = true;
        final boolean shouldweightX = true;
        final boolean RIGHT_TO_LEFT = false;

        //Fills the button to the frame horizontally but this doesn't change the height
        if(shouldfill){
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }

        JButton button = new JButton("Button1");

        if(shouldweightX){
            constraints.weightx = 0.5;
        }

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        pane.add(button, constraints);

        JButton button2 = new JButton("Button 2");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx =0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        pane.add(button2, constraints);

        JButton button3 = new JButton("Button 3");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx =0.5;
        constraints.gridx = 2;
        constraints.gridy = 0;
        pane.add(button3, constraints);

        JButton button4 = new JButton("Button 4");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx =0.0;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.ipady = 40;
        pane.add(button4, constraints);

        JButton button5 = new JButton("Button 5");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipady = 0;
        constraints.weighty = 1.0;
        //constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.insets = new Insets(10,0,0,0);
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.gridy = 2;
        pane.add(button5, constraints);

        this.setVisible(true);
    }
}
