package MovingSqaure;

import javax.swing.*;

public class launch extends JFrame {
    JFrame frame = new JFrame();

    launch(){
        int w = 1000;
        int h = 800;
        DrawingSquare ds = new DrawingSquare(100, 100);

        frame.setSize(w,h);
        frame.setTitle("Moving Square");

        button(w,h);
        frame.add(ds);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void button(int x, int y){
        JButton button = new JButton("Click");
        button.setFocusPainted(false);
        button.setBounds(x/3, y/3, 100,50);

        frame.add(button);
    }
}
