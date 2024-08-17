import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapMaker {
    int x;
    int y;
    int width;
    int height;
    
    Rectangle hitbox; 

    public MapMaker(int x, int y, int width, int height) {
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height; 

        hitbox = new Rectangle(x, y , width, height);

    }

    public void draw(Graphics2D my2d) {
        my2d.setColor(Color.WHITE); 
        my2d.fillRect(x, y, width, height);
    }
}
