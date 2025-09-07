import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class ZoomPanPanel extends JPanel {
    private BufferedImage image;
    private double zoom = 1.0;
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
            @Override
            public void mousePressed(MouseEvent e) {
                lastDragPoint = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                //delta in screen coords
                double dx = p.getX() - lastDragPoint.getX();
                double dy = p.getY() - lastDragPoint.getY();
                translateX += dx;
                translateY += dy;
                lastDragPoint = p;
                repaint();
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Zoom factor per wheel notch
                double delta = e.getPreciseWheelRotation(); //positive = scroll down (zoom out)
                double scale = Math.pow(1.1, -delta); //inverted so wheel-up zooms in

                //Clamp new zoom
                double newZoom = zoom * scale;
                newZoom = Math.max(MIN_ZOOM, Math.min(MAX_ZOOM, newZoom));
                scale = newZoom / zoom; // adjust scale if clamped
                zoom = newZoom;

                // To keep the mouse position stationary, adjust translation
                Point p = e.getPoint();
                double px = p.getX();
                double py = p.getY();

                // transform origin so that after scaling the point under cursor stays
                translateX = px - scale * (px - translateX);
                translateY = py - scale * (py - translateY);

                repaint();
            }
        };

        addMouseListener(ma);
        addMouseMotionListener(ma);
        addMouseListener(ma);

        setBackground(Color.DARK_GRAY);
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image == null) return;

        Graphics2D g2 = (Graphics2D) g;

        //high quality if like (optional)
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        AffineTransform at = new AffineTransform();
        at.translate(translateX, translateY);
        at.scale(zoom, zoom);
        g2.setTransform(at);

        g2.drawImage(image, 0, 0,null);
    }

    public void resetView(){
        zoom = 1.0;
        translateX = 0;
        translateY = 0;
        repaint();
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Zoom & Pan Demo");
        ZoomPanPanel panel = new ZoomPanPanel("sun.jpg"); // <-- put actual path
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
