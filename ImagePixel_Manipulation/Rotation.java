import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Rotation extends JComponent {

    public Rotation(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double r1 = new Rectangle2D.Double(150,200,100,100);

        g2d.setColor(Color.GREEN);
        g2d.rotate(Math.toRadians(15),150,200);
        g2d.fill(r1);

        g2d.setTransform(reset);

        g2d.setColor(Color.BLUE);
        g2d.rotate(Math.toRadians(20),150,200);
        g2d.fill(r1);
    }

    public static void main(String[] args){
        int w = 640;
        int h = 480;

        JFrame frame = new JFrame();
        Rotation dc = new Rotation();

        frame.setSize(w,h);
        frame.setTitle("Drawing Canvas");

        frame.add(dc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
