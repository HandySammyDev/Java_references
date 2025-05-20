package Test3;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    TopPanel topPanel = new TopPanel();
    BottomPanel bottomPanel = new BottomPanel();

    Window(){
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,500);
        this.setLayout(new GridLayout(2,1));

        this.add(topPanel);
        this.add(bottomPanel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
