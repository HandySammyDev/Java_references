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
    boolean gameOver;

    //Effects
    boolean effectCounterOn;
    int effectCounter;
    ArrayList<Integer> effectY = new ArrayList<>();

    //Score
    int level = 1;
    int lines;
    int score;

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

            // Check if the game is over
            if(currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y){
                // This means the currentMino immediately collided a block and couldn't move at all
                // So it's xy are the same with the nextMino's
                gameOver = true;
            }

            currentMino.deactivating = false;

            // Replace the currentMino with the nextMino
            currentMino = nextMino;
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickMino();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

            // When a mino becomes inactive, check if line(s) can be deleted
            checkDelete();
        }
        else {
            currentMino.update();
        }
    }
    private void checkDelete(){

        int x = left_x; // 460
        int y = top_y;  // 50
        int blockCount = 0;
        int lineCount = 0;

        while(x < right_x && y < bottom_y){ //820 //650
            for(int i = 0; i < staticBlocks.size(); i++){
                if(staticBlocks.get(i).x == x && staticBlocks.get(i).y == y){
                    // Increase the count if there is a static block
                    blockCount++;
                }
            }

            x += Block.SIZE;

            if(x == right_x){

                // If the blockCount hits 12, that means the current y line is all filled with blocks
                // so we can delete them
                if(blockCount == 12){

                    effectCounterOn = true;
                    effectY.add(y);

                    for(int i = staticBlocks.size()-1; i > -1; i--){
                        // Remove all the blocks in the current y line
                        if(staticBlocks.get(i).y == y){ // Remove all the blocks that have the same y-axis line
                            staticBlocks.remove(i);
                        }
                    }

                    // When we remove a line, increase lineCount
                    lineCount++;
                    lines++;

                    // Drop speed
                    // If the line score hits a certain number, increase the drop speed
                    // 1 is the fastest
                    if(lines % 10 == 0 && dropInterval > 1){ //Every 10 lines, the level increases
                       level++;
                       if(dropInterval > 10){
                           dropInterval -= 10;
                       }
                       else{
                           dropInterval -= 1;
                       }
                    }

                    // A line has been deleted so need to slide down blocks that are above it
                    for(int i = 0; i < staticBlocks.size(); i++){
                        // If a block is above the current y, move it down by the block size
                        if(staticBlocks.get(i).y < y){
                            staticBlocks.get(i).y += Block.SIZE;
                        }
                    }
                }

                blockCount = 0; //Reset
                x = left_x;
                y += Block.SIZE;
            }
        }

        // Add score
        if(lineCount > 0){
            int singleLineScore = 10 * level;
            score += singleLineScore * lineCount;
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

        // Draw score frame
        g2.drawRect(x, top_y, 250, 300); // x = 920; y = 50
        x += 40;
        y = top_y + 90; // 50 + 90 = 140
        g2.drawString("LEVEL: " + level, x, y); y += 70;
        g2.drawString("LINES: " + lines, x, y);  y += 70;
        g2.drawString("SCORE: " + score, x, y);

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

        // Draw effect
        if(effectCounterOn){
            effectCounter++;

            g2.setColor(Color.red);
            for(int i = 0; i < effectY.size(); i++){
                g2.fillRect(left_x, effectY.get(i), WIDTH, Block.SIZE);
            }

            if(effectCounter == 10){ // When counter reaches 10 we reset everything for effects (every 10 frames)
                effectCounterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
        }

        // Draw pause or game over
        g2.setColor(Color.YELLOW);
        g2.setFont(g2.getFont().deriveFont(50f));
        if(gameOver){
            x = left_x + 2;  // 460 + 2  = 462
            y = top_y + 320; // 50 + 320 = 370
            g2.drawString("GAME OVER", x, y);
        }
        if(KeyHandler.pausedPressed){
            x = left_x + 70; // 460 + 70 = 530
            y = top_y + 320; // 50 + 320 = 370
            g2.drawString("PAUSED", x, y);
        }

        // Draw the Game Title
        x = 55;
        y = top_y + 320; // 50 + 320 = 370
        g2.setColor(Color.white);
        g2.setFont(new Font("Times New Roman", Font.ITALIC, 60));
        g2.drawString("Simple Tetris", x, y);
    }
}
