package MovingSqaure;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class DrawingSquare extends JComponent {
    private int width; //100
    private int height; //100

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

        int X = x+width;
        int Y = y+height;
        int rounds = 1;

        int i = 0;
        while(rounds<3){
            while(i<90){
                Random rand = new Random();
                int r1 = rand.nextInt(256);
                int r2 = rand.nextInt(256);
                int r3 = rand.nextInt(256);

                g2d.setTransform(old);
                g2d.translate(0,0);

                g2d.rotate(Math.toRadians(i), X, Y); // rotate around the bottom-right corner of the rectangle
                g2d.setColor(new Color(r1,r2,r3));
                
                if(rounds==2){
                    g2d.fill(new Rectangle2D.Double(x, y, width, height));
                    System.out.println(rounds);
                }
                else if (rounds == 1) {
                    g2d.fill(new Rectangle2D.Double(x+width, y, width, height));
                    System.out.println(rounds);
                }

                i += 10;
            }
            rounds++;
            System.out.println(rounds);
        }

//        g2d.setTransform(old);
//        g2d.translate(0, 0);
//
//        g2d.rotate(Math.toRadians(i), X, Y); // rotate around the bottom-right corner of the rectangle
//        g2d.setColor(Color.GREEN);
//        g2d.fill(new Rectangle2D.Double(100, y, width, height));
    }
}
