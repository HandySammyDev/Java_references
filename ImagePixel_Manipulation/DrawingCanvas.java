import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;

    public DrawingCanvas(int w, int h){
        width = w;
        height = h;
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(new Color(100,149,237));
        g2d.fill(r);

        Ellipse2D.Double e = new Ellipse2D.Double(200,75,100,100);
        g2d.setColor(Color.BLUE);
        g2d.fill(e);

        Line2D.Double line = new Line2D.Double(100,250,300,75);
        g2d.setColor(Color.BLACK);
        g2d.draw(line);
    }

    public static void main(String[] args) {
        int w = 640;
        int h = 480;

        JFrame frame = new JFrame();
        DrawingCanvas dc = new DrawingCanvas(w, h);

        frame.setSize(w,h);
        frame.setTitle("Drawing Canvas");

        frame.add(dc);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
