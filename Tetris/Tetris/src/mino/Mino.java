package mino;

import main.GamePanel;
import main.KeyHandler;
import main.PlayManager;

import java.awt.*;

public class Mino {

    public Block[] b = new Block[4];
    public Block[] tempB = new Block[4];
    int autoDropCounter = 0;
    public int direction = 1; // There are 4 directions (1/2/3/4)
    boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;
    public boolean deactivating;
    int deactivateCounter = 0;

    public void create(Color c){
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }
    public void setXY(int x, int y){}
    public void updateXY(int direction){

        checkRotationCollision();

        if(leftCollision == false && rightCollision == false && bottomCollision == false){

            this.direction = direction;
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;
        }
    }
    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}
    public void checkMovementCollision(){

        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkStaticBlockCollision();

        // Check frame collision
        // Left wall
        for(int i=0; i<b.length; i++){
            if(b[i].x == PlayManager.left_x){ //if the x position of i equals to the left wall position
                leftCollision = true;
            }
        }

        // Right floor
        for(int i=0; i<b.length; i++){
            if(b[i].x + Block.SIZE == PlayManager.right_x){ // x position + 30(Block.SIZE) equals to the bottom of the white box
                rightCollision = true;
            }
        }

        // Bottom floor
        for(int i=0; i<b.length; i++){
            if(b[i].y + Block.SIZE == PlayManager.bottom_y){ // y position + 30(Block.SIZE) equals to the bottom of the white box
                bottomCollision = true;
            }
        }
    }
    public void checkRotationCollision(){

        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        checkStaticBlockCollision();

        // Check frame collision
        // Left wall
        for(int i=0; i<b.length; i++){
            if(tempB[i].x < PlayManager.left_x){ //if the x position of i > to the left wall position
                leftCollision = true;
            }
        }

        // Right floor
        for(int i=0; i<b.length; i++){
            if(tempB[i].x + Block.SIZE > PlayManager.right_x){ // x position + 30(Block.SIZE) > to the bottom of the white box
                rightCollision = true;
            }
        }

        // Bottom floor
        for(int i=0; i<b.length; i++){
            if(tempB[i].y + Block.SIZE > PlayManager.bottom_y){ // y position + 30(Block.SIZE) > to the bottom of the white box
                bottomCollision = true;
            }
        }
    }
    private void checkStaticBlockCollision(){
        for(int i=0; i<PlayManager.staticBlocks.size(); i++){
            int targetX = PlayManager.staticBlocks.get(i).x;
            int targetY = PlayManager.staticBlocks.get(i).y;

            // Check if a block is below the Mino
            for(int ii=0; ii < b.length; ii++){
                if(b[ii].y + Block.SIZE == targetY && b[ii].x == targetX){
                    bottomCollision = true;
                }
            }

            // Check if a block is at the left or right of the Mino
            for(int ii=0; ii < b.length; ii++){
                if(b[ii].x - Block.SIZE == targetX && b[ii].y == targetY){
                    leftCollision = true;
                }
            }
            for(int ii=0; ii < b.length; ii++){
                if(b[ii].x + Block.SIZE == targetX && b[ii].y == targetY){
                    rightCollision = true;
                }
            }
        }
    }
    public void update(){

        if(deactivating){
            deactivating();
        }

        // Move the mino
        if(KeyHandler.upPressed){
            switch(direction){
                case 1: getDirection2();break;
                case 2: getDirection3();break;
                case 3: getDirection4();break;
                case 4: getDirection1();break;
            }
            KeyHandler.upPressed = false;
            GamePanel.se.play(1, false);
        }

        checkMovementCollision(); //Note: if one of these collision happens,
                                  //the mino cannot move unless specified in the if statements below.

        if(KeyHandler.downPressed){
            // If the mino's bottom is not hitting, it can go down
            if(bottomCollision == false){
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;

                // When moved down, reset the autoDropCounter
                autoDropCounter = 0;
            }

            KeyHandler.downPressed = false;
        }

        if(KeyHandler.leftPressed){

            if(leftCollision == false){
                b[0].x -= Block.SIZE;
                b[1].x -= Block.SIZE;
                b[2].x -= Block.SIZE;
                b[3].x -= Block.SIZE;
            }

            KeyHandler.leftPressed = false;
        }
        if(KeyHandler.rightPressed){

            if(rightCollision == false){
                b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;
            }

            KeyHandler.rightPressed = false;
        }

        if(bottomCollision){
            // without this if-Stat. we will continue to hear the sound until bottomCollision is false
            if(deactivating == false){
                GamePanel.se.play(4, false);
            }

            deactivating = true;
            //active = false; //deactivate the mino and by pass the old autoDropCounter
        }
        else {
            autoDropCounter++; // The counter increases in every frame
            if(autoDropCounter == PlayManager.dropInterval){
                // The mino goes down
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;
                autoDropCounter = 0; //Reset the counter
            }
        }
    }
    private void deactivating(){

        deactivateCounter++;

        // Wait 45 frames until deactivate
        if(deactivateCounter == 45){

            deactivateCounter = 0; // Reset counter
            checkMovementCollision(); // Check if the block is still hitting

            // If the bottom is still hitting after 45 frames, deactivate
            if(bottomCollision){
                active = false;
            }
        }
    }
    public void draw(Graphics2D g2){
        // This draws the Mino so you can actually see it on the screen
        int margin = 2; //This is for the black gaps between each sqr, it's just the color from the background bc the sqr just got smaller
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x+margin, b[0].y+margin, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[1].x+margin, b[1].y+margin, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[2].x+margin, b[2].y+margin, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[3].x+margin, b[3].y+margin, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
    }
}
