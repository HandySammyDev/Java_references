import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ZoomPanPanel extends JPanel {
    private BufferedImage image;
    private double zoomLevel = 1.0;
    private final double MIN_ZOOM = 0.1;
    private final double MAX_ZOOM = 10.0;

    //translation in device coordinates
    private double translateX = 0;
    private double translateY = 0;

    //for dragging
    private Point lastDragPoint;

    public ZoomPanPanel(String imagePath){
        try{
            image = ImageIO.read(new File("sun.jpg"));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        MouseAdapter ma = new MouseAdapter() {
        }
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
        ZoomPanPanel panel = new ZoomPanPanel();

        JScrollPane scrollPane = new JScrollPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.add(panel);
        frame.setVisible(true);
        panel.requestFocusInWindow(); //enable key listener
    }
}
