package main;

import mino.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
    Mino nextMino;
    final int NEXTMINO_X;
    final int NEXTMINO_Y;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

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

        NEXTMINO_X = right_x + 175;     // 820 + 175 = 995
        NEXTMINO_Y = top_y + 500;       // 50 + 500  = 550

        //Set the starting Mino
        currentMino = pickMino(); //picks a random mino
        currentMino.setXY(MINO_START_X, MINO_START_Y);
        nextMino = pickMino();
        nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
    }

    private Mino pickMino(){

        //Pick a random mino
        Mino mino = null;
        int i = new Random().nextInt(7);

        switch(i){
            case 0: mino = new Mino_L1();break;
            case 1: mino = new Mino_L2();break;
            case 2: mino = new Mino_Square();break;
            case 3: mino = new Mino_Bar();break;
            case 4: mino = new Mino_T();break;
            case 5: mino = new Mino_Z1();break;
            case 6: mino = new Mino_Z2();break;
        }
        return mino;
    }

    public void update(){
        // Check if the currentMino is active
        if(currentMino.active == false){
            // If the mino is not active, put it into the static Blocks
            staticBlocks.add(currentMino.b[0]);
            staticBlocks.add(currentMino.b[1]);
            staticBlocks.add(currentMino.b[2]);
            staticBlocks.add(currentMino.b[3]);

            // Replace the currentMino with the nextMino
            currentMino = nextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickMino();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);
        }
        else {
            currentMino.update();
        }
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
        // Draw the next
        nextMino.draw(g2);

        // Draw Static Blocks
        for(int i=0; i<staticBlocks.size(); i++){
            staticBlocks.get(i).draw(g2); // Draws the minos so that they stick to the bottom
        }                                 // The minos disappear at the bottom if this for-loop is removed

        // Draw pause
        g2.setColor(Color.YELLOW);
        g2.setFont(g2.getFont().deriveFont(50f));
        if(KeyHandler.pausedPressed){
            x = left_x + 70; // 460 + 70 = 530
            y = top_y + 320; // 50 + 320 = 370
            g2.drawString("PAUSED", x, y);
        }
    }
}
