package MovingSqaure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launch extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Click");

    launch(){
        int w = 1000;
        int h = 800;
        DrawingSquare ds = new DrawingSquare(100, 100);

        frame.setSize(w,h);
        frame.setTitle("Moving Square");

        button.setFocusPainted(false);
        button.addActionListener(this);
        button.setBounds(w/3, h/3, 100,50);

        frame.add(button);
        frame.add(ds);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void isButtonPresses(boolean confirm){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            isButtonPresses(true);
        }
    }
}
