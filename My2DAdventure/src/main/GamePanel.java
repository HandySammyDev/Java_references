package main;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 tile

    // Ratio is 4x3
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;  // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //Once this thread starts, it keeps the program running
                       //Threading does not do anything special but if you want the game
                       //to keep running in the background, you use Thread.
    public Player player = new Player(this, keyH);


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);

        // All drawings from this component will be done off-screen painting buffer
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true); //GamePanel can be "focused" to receive key input
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }


    // 1 UPDATE: update information such as character positions
    //update(); //Key components(the method below this one)

    // 2 DRAW: draw the screen with the updated information
    //repaint(); //Once the keys are updated, it updates the screen using paintComponent

    @Override
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        //super - the parent class of this class. In this case the parent is JPanel and subclass is GamePanel
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //Draws players and tiles
        tileM.draw(g2); // <-- Draw this first or tiles will hide the player
        player.draw(g2);

        g2.dispose();
    }
}
