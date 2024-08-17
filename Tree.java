import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File; 
import javax.imageio.ImageIO; 
public class Tree { 
    int x;
    int y;
    int width;
    int height; 
    gamePanel panel; 
  Image image; 
  java.awt.Rectangle hitbox;
    public Tree(int x, int y, gamePanel panel) {
        this.x = x;
        this.y = y; 
        width = 100;
        height = 300;  
        hitbox = new Rectangle(x, y,width, height );

    try {
        image = ImageIO.read(new File("tree.png"));
       } catch (Exception e) {
        e.printStackTrace(); 
       } 
    }


    public void draw(Graphics2D my2D) {
        my2D.drawImage(image, x, y, null);
    }
}

