package main;

import mino.Block;
import mino.Mino;
import mino.Mino_L1;

import java.awt.*;

public class PlayManager {

    //Main Play Area
    final int  WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    //Others
    public static int dropInterval = 60; //mino drops in every 60 frames (or 1 second)


    public PlayManager(){

        //Main Play Area frame
        left_x = (GamePanel.WIDTH/2) - (WIDTH/2);   // 1280/2 - 360/2 = 460
        right_x = left_x + WIDTH;                   // 460 + 360     = 820
        top_y = 50;                                 //               = 50
        bottom_y = top_y + HEIGHT;                  // 50 + 600      = 650

        // Start X will be around the center of the play area
        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE; // 460 + (360/2) - 30 = 610
        MINO_START_Y = top_y + Block.SIZE;              // 50 + 30            = 80

        //Set the starting Mino
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }
    public void update(){
        currentMino.update();
    }
    public void draw(Graphics2D g2){

        // Draw Play Area Frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4,top_y-4,WIDTH+8,HEIGHT+8); //Big Rectangle

        // Draw Next Mino Frame
        int x = right_x + 100;  // 820 + 100 = 920
        int y = bottom_y - 200; // 650 - 200 = 450
        g2.drawRect(x,y,200,200); //Small Rectangle
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x+60, y+40);

        // Draw current Mino
        if(currentMino != null){
            currentMino.draw(g2); //Mino(parent) draw method
        }
    }
}
