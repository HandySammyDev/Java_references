package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);  //Since the x & y start in the top-left corner of a tile, it will not be centered
        screenY = gp.screenHeight/2 - (gp.tileSize/2); //So subtract half the tile to adjust to correct center position

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        worldX = gp.tileSize * 25;
        worldY = gp.tileSize * 20;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){

        try{
            up1 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png"))));
            up2 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png"))));
            down1 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png"))));
            down2 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png"))));
            left1 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png"))));
            left2 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png"))));
            right1 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png"))));
            right2 = ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png"))));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //This update method gets called 60 times per second
    public void update(){

        // Stops the character from walking in a single tile
        if(keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed ==true){

            // Update character from key inputs
            if(keyH.upPressed == true){
                direction = "up";
                worldY -= speed;         // playerY - 4 pixels
            }
            else if(keyH.downPressed == true){
                direction = "down";
                worldY += speed;         // playerY + 4 pixels
            }
            else if(keyH.leftPressed == true){
                direction = "left";
                worldX -= speed;         // playerX - 4 pixels
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;         // playerX + 4 pixels
            }

            spriteCounter++;
            if(spriteCounter > 12){ //Sprite switches walking position every 12 frames
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        //Switches the direction the character is facing and boolean walk animation
        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}