package TicTakToe;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TikTakToe");

        frame.setSize(1200,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new GamePanel());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}