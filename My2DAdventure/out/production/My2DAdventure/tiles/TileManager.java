package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[10]; //10 tiles
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldMap.txt");
    }

    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/grass.png")));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/wall.png")));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/water.png")));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/earth.png")));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/tree.png")));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(
                    "/tiles/sand.png")));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine(); //Read a single line and put it into the String line

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(" "); //Splits this string around matches of the given regular expression

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch(Exception e){

        }
    }
    //Draws the tiles
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize; //48
            int worldY = worldRow * gp.tileSize; //48
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //We create a boundary from the player(center) to the edges of the screen
            //Optimise code for rendering performance
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
//            System.out.println("worldX: " + worldX);
//            System.out.println("worldY: " + worldY);
//            System.out.println("screenX: " + screenX);
//            System.out.println("screenY: " + screenY );
//            System.out.println("-----------------------\n");
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }

//        g2.drawImage(tile[1].image, 0,0 , gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48, 0,gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 96,0 ,gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 144, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192,0, gp.tileSize, gp.tileSize, null);
//
//        g2.drawImage(tile[1].image, 0, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 96, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 144, 48, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 48, gp.tileSize, gp.tileSize, null);
//
//        g2.drawImage(tile[1].image, 0, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 48, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 144, 96, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 96, gp.tileSize, gp.tileSize, null);
//
//        g2.drawImage(tile[1].image, 0, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 48, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[0].image, 144, 144, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 144, gp.tileSize, gp.tileSize, null);
//
//        g2.drawImage(tile[1].image, 0, 192, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 48, 192, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 96, 192, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 144, 192, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 192, gp.tileSize, gp.tileSize, null);
    }
}

//1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0