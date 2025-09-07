package Java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageDisplay extends JPanel {
    BufferedImage image;
    double zoomLevel = 1.0;

    public ImageDisplay(){
        try{
            image = ImageIO.read(new File("sun.jpg"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        addMouseWheelListener(e ->{
            if(e.getPreciseWheelRotation() < 0){
                zoomLevel *= 1.1; //zoom in
            }
            else{
                zoomLevel /= 1.1; //zoom out
            }
            revalidate();
            repaint();
        });

        //Return the size of panel depending on zoom
        @Override
        public Dimension getPreferredSize(){
            if(image != null){
                return new Dimension((int)(image.getWidth() * zoomLevel), (int)(image.getHeight() * zoomLevel));
            }
            return super.getPreferredSize();
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_EQUALS){
                    zoomLevel *= 1.1;
                }
                else if(e.getKeyCode() == KeyEvent.VK_MINUS){
                    zoomLevel /= 1.1;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(image != null){
            int width = image.getWidth();
            int height = image.getHeight();

            int pixelSize = 1; //You can increase to zoom in on pixels

            for(int y=0; y<height; y++){
                for(int x=0; x<width; x++){
                    int rgb = image.getRGB(x,y);
                    Color color = new Color(rgb, true);

                    int r = color.getRed();
                    int gVal = color.getGreen();
                    int b = color.getBlue();

                    //Simple red filter: show only red-dominant pixels
                    if(r > 150 && gVal < 100 && b < 100){
                        g.setColor(color); //Keep original
                    }
                    else{
                        g.setColor(Color.WHITE); //or new Color(255, 255, 255, 0) for transparent
                    }

                    g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                }
            }
        }
    }

    public static void filterForRed(){

    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Pixel-by-Pixel Display");
        ImageDisplay panel = new ImageDisplay();

        JScrollPane scrollPane = new JScrollPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.add(panel);
        frame.setVisible(true);
        panel.requestFocusInWindow(); //enable key listener
    }
}
