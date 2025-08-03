package Cloud;

import javax.swing.*;
import java.awt.*;

public class DrawingCanvasDrawCloud extends JComponent {
    private int width;
    private int height;
    private Cloud c1;
    private Cloud c2;
    private Cloud c3;
    private Cloud c4;
    private Cloud c5;
    private Cloud c6;

    public DrawingCanvasDrawCloud(int w, int h){
        width = w;
        height = h;
        c1 = new Cloud(10,50,20,Color.BLUE);
        c2 = new Cloud(60,230,22,Color.BLUE);
        c3 = new Cloud(90, 90, 90, Color.BLUE);
        c4 = new Cloud(150,150,20,Color.BLUE);
        c5 = new Cloud(200,290,122,Color.BLUE);
        c6 = new Cloud(250, 390, 200, Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        c1.drawCloud(g2d);
        c2.drawCloud(g2d);
        c3.drawCloud(g2d);
        c4.drawCloud(g2d);
        c5.drawCloud(g2d);
        //c6.drawCloud(g2d);
    }
    public static void main(String[] args) {
        int w = 640;
        int h = 480;

        JFrame frame = new JFrame();
        DrawingCanvasDrawCloud dc = new DrawingCanvasDrawCloud(w, h);

        frame.setSize(w,h);
        frame.setTitle("Drawing Canvas");

        frame.add(dc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
