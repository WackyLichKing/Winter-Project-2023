import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File; 
import javax.imageio.ImageIO; 

public class JustFire {
    int x;
    int y;
    int height;
    int width; 
Random randy = new Random();
    Rectangle hitbox; 
    Image fire; 
    public JustFire() {
        this.x = randy.nextInt(1000);
        this.y = randy.nextInt(100); 
        this.width = 50; 
        this.height = 50;
        
        try {
            fire = ImageIO.read(new File("fire.png"));
        } catch(Exception E) {
            E.printStackTrace() ;
        }

        hitbox = new Rectangle(x, y, width, height); 
    }    

    public void draw(Graphics2D my2D) {
        my2D.drawImage(fire, x, y, null); 
        y++; 
        hitbox.y = y;
        if(y>900) {
            y=0; 
            x = randy.nextInt(1000); 
            hitbox.x = x;
            hitbox.y = y;  
        }
    }
}
