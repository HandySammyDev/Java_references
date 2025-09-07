package Java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PixelReader {
    public static void main(String[] args){
        try{
            File file = new File("Sketch.jpg");
            BufferedImage image = ImageIO.read(file);

            int width = image.getWidth();
            int height = image.getHeight();

            //Loop through every pixel
            for(int y=0; y<height; y++){
                for(int x=0; x<width; x++){
                    int pixel = image.getRGB(x,y); //Get pixel value

                    //Extract color components
                    Color color = new Color(pixel, true);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int alpha = color.getAlpha(); //transparency

                    //Print pixel info
                    System.out.printf("Pixel at (%d, %d): R=%d G=%d B=%d A=%d%n"
                            , x, y, red, green, blue, alpha);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
