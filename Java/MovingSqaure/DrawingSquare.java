package MovingSqaure;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class DrawingSquare extends JComponent {
    private int width;
    private int height;

    public DrawingSquare(int w, int h) {
        this.width = w;
        this.height = h;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 400;

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        AffineTransform old = g2d.getTransform(); //Saves the current transform

        Rectangle2D.Double r = new Rectangle2D.Double(x,y,width, height);
        g2d.setColor(Color.BLUE);
        g2d.rotate(Math.toRadians(0));
        g2d.fill(r);

        int newX = x+width;
        int newY = y+height;
        int rounds = 1;
        while(rounds < 3){
            int i = 0;
            while(i<90){
                i += 10;

                Random rand = new Random();
                int r1 = rand.nextInt(256);
                int r2 = rand.nextInt(256);
                int r3 = rand.nextInt(256);

                if(rounds == 1){
                    g2d.setTransform(old);
                    g2d.translate(0,0);
                }
                g2d.rotate(Math.toRadians(i),newX,newY); // rotate around the bottom-right corner of the rectangle
                g2d.setColor(new Color(r1,r2,r3));
                g2d.fill(new Rectangle2D.Double(x, y, width, height));

                if(i==90){
                    g2d.translate(newX,newY);
                }
            }
            rounds++;
        }
    }
}
