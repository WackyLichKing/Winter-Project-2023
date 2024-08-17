import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Snowflakes {
    Random randy = new Random(); 
    int x;
    int y; 
    int width;
    int height;
    
    double yspeed; 

    Rectangle hitbox;

    public Snowflakes() {
     this.x = randy.nextInt(1000);
     this.y = randy.nextInt( 800);
     this.width = 15;
     this.height = 15;
     hitbox = new java.awt.Rectangle(x,y,width, height);
    }


    public void draw(Graphics2D my2D) {
         my2D.fillOval(x, y, width,height);
        y++;
        hitbox.y=y;
        if (y>950) {
            y=0;
            x=randy.nextInt(1000);
            hitbox.x = x;
            hitbox.y =y; 
        }
        }
    }


