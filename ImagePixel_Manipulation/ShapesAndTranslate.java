import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class ShapesAndTranslate extends JComponent {

    public ShapesAndTranslate(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        Rectangle2D.Double r1 = new Rectangle2D.Double(0,0,100,100);
        Rectangle2D.Double r2 = new Rectangle2D.Double(100,100,100,100);

        AffineTransform reset = g2d.getTransform();

        g2d.setColor(Color.BLUE);
        g2d.translate(150,100); //This relocates the origin(0,0) so (150,100) is the new (0,0)
        g2d.fill(r1);
        g2d.fill(r2);

        g2d.translate(300,200); //New origin
        g2d.fill(r1);                 //Only this is effected

        //g2d.translate(-450,-300); //Reseted translate
        g2d.setTransform(reset);
        g2d.fill(r1);


        //For drawing curves
//        Path2D.Double curve = new Path2D.Double();
//        curve.moveTo(250,400);
//        curve.curveTo(350,300,500,300,233,300);
//        g2d.draw(curve);

        //For drawing triangles
//        Path2D.Double p = new Path2D.Double();
//        p.moveTo(100,300);
//        p.lineTo(150,200);
//        p.lineTo(200,300);
//        p.closePath();
//        g2d.draw(p);
    }

    public static void main(String[] args){
        int w = 640;
        int h = 480;

        JFrame frame = new JFrame();
        ShapesAndTranslate dc = new ShapesAndTranslate();

        frame.setSize(w,h);
        frame.setTitle("Drawing Canvas");

        frame.add(dc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
