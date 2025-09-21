
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 720;
    private final int FPS = 60;
    private Thread gameThread;
    private PlayAreaPanel pa = new PlayAreaPanel();
    private ButtonsPanel bp = new ButtonsPanel();

    public GamePanel(){

        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        this.add(pa);
        this.add(bp);
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    private void update(){
        pa.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        pa.draw(g2);
    }
}
