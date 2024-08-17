import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File; 
import javax.imageio.ImageIO; 

public class PresentsAndFire {
    int x;
    int y;
    int width;
    int height;
    int index; 
    Image Red_Present;
    Image White_Present;
    Image Green_Present;
    Image Blue_Present;
    Random randy = new Random(); 

    Rectangle hitbox; 

    public PresentsAndFire() {
        this.x = randy.nextInt(1000);
        this.y = 0; 
        this.width = 50;
        this.height = 50; 

        hitbox = new java.awt.Rectangle(x,y, width, height);
        index = randy.nextInt(4);
        try {
          Red_Present =  ImageIO.read(new File("Red_Present.png"));
          White_Present =  ImageIO.read(new File("White_Present.png"));
          Green_Present =  ImageIO.read(new File("Green_Present.png"));
          Blue_Present =  ImageIO.read(new File("Blue_Present.png"));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D gtd) {

        if (index == 0) {
            gtd.drawImage(Red_Present,x,y, null); 
            y++; 
            hitbox.y = y;
            if(y>900) {
                y = randy.nextInt(50);
                x = randy.nextInt(1000);
                hitbox.x = x; 
                hitbox.y = y; 
            }
        }
        if (index == 1) {
            gtd.drawImage(Green_Present,x,y, null); 
            y++; 
            hitbox.y = y;
            if(y>950) {
                y = 0;
                x = randy.nextInt(1000);
                hitbox.x = x; 
                hitbox.y = y; 
            }
        }
        if (index == 2) {
            gtd.drawImage(White_Present,x,y, null); 
            y++; 
            hitbox.y = y;
            if(y>950) {
                y = 0;
                x = randy.nextInt(1000);
                hitbox.x = x; 
                hitbox.y = y; 
            }
        }
        if (index == 3) {
            gtd.drawImage(Blue_Present,x,y, null); 
            y++; 
            hitbox.y = y;
            if(y>950) {
                y = 0;
                x = randy.nextInt(1000);
                hitbox.x = x; 
                hitbox.y = y; 
            }
        }

    }
}
