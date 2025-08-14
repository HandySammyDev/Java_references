package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 tile

    // Ratio is 4x3
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol;  // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();

    Thread gameThread; //Once this thread starts, it keeps the program running
                       //Threading does not do anything special but if you want the game
                       //to keep running in the background, you use Thread.

    // Set player's default positions
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

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

//    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS; // 0.01666 seconds
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null){
//
//            // 1 UPDATE: update information such as character positions
//            update(); //Key components(the method below this one)
//
//            // 2 DRAW: draw the screen with the updated information
//            repaint(); //Once the keys are updated, it updates the screen using paintComponent
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime / 1000000;
//
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long)remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

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

        // Update character from key inputs
        if(keyH.upPressed == true){
            playerY -= playerSpeed;         // playerY - 4 pixels
        }
        else if(keyH.downPressed == true){
            playerY += playerSpeed;         // playerY + 4 pixels
        }
        else if(keyH.leftPressed == true){
            playerX -= playerSpeed;         // playerX - 4 pixels
        }
        else if(keyH.rightPressed == true) {
            playerX += playerSpeed;         // playerX + 4 pixels
        }
    }
    public void paintComponent(Graphics g){
        //super - the parent class of this class. In this case the parent is JPanel and subclass is GamePanel
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();
    }
}
