import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File; 
import javax.imageio.ImageIO; 

public class Character {
  Random randy = new Random(); 
   //Variables for Character
  int health = 3;
  int presentsCollected = 0;
  final static int TOTAL_PRESENTS = 10;
  Image image; 
  // int jumpCooldown; 


  gamePanel panel; 
  int x;
  int y; 
  int width;
  int height;

  double xspeed;
  double yspeed;

  boolean left;
  boolean right;
  boolean up;
  boolean down; 

  java.awt.Rectangle hitbox; 
  public Character(int x, int y, gamePanel panel) {
    this.panel = panel;
    this.x = x; 
    this.y = y; 

    width = 50;
    height = 100; 
 
    hitbox = new java.awt.Rectangle(x, y, width, height);
   try {
    image = ImageIO.read(new File("snowhim.png"));
   } catch (Exception e) {
    e.printStackTrace(); 
   } 
    // jumpCooldown = 1700; 
  }

//Getter Methods
public int getHealth() {
    return health; 
}
public int getPresents() {
    return presentsCollected; 
}
public int getTotalPresents() {
    return TOTAL_PRESENTS;
}

//Changer Methods
  public void healthLost() {
    health--;
  }
  
  public void healthGain() {
    health++; 
  }

  public void gotPresent() {
    presentsCollected++; 
  }
  public void lostPresent() {
    presentsCollected--; 
  }

  public void set() {
    if (left && right || !left && !right) {
      xspeed *= 0.8;
    }
    else if (left & !right) {
      xspeed--; 
    }
    else if(right && !left) {
      xspeed++; 
    }
    
    if(xspeed> 0 && xspeed< 0.75) {
      xspeed = 0; 
    }
    if (xspeed<0 && xspeed > -0.75) {
      xspeed = 0;
    }

    if (xspeed> 7) {
      xspeed = 7; 
    }
    if (xspeed<-7) {
      xspeed = -7;
    }
    if (down) {
      yspeed -= -10;
    }
    if(up) {

      hitbox.y++;
      for(MapMaker wall: panel.walls) {
        if(wall.hitbox.intersects(hitbox)) {
          yspeed = -6; 
        }
      }
      hitbox.y--; 
      // jumpCooldown++; 
      // if (jumpCooldown >= 1700) {
        yspeed = -6; 
      // jumpCooldown = 0;
      // }
   
    }

    yspeed += 0.3;
    //Horizontal Collisions with walls
    hitbox.x += xspeed;
    for(MapMaker wall: panel.walls) {
      if (hitbox.intersects(wall.hitbox)) {
        hitbox.x -= xspeed;
        while(!wall.hitbox.intersects(hitbox)) {
          hitbox.x += Math.signum(xspeed);
        }
        hitbox.x -= Math.signum(xspeed);
        xspeed = 0;
        x = hitbox.x;
      }
    }

    for(Snowflakes snowy: panel.snow){ 
      for(MapMaker wally: panel.walls) {
        if (snowy.hitbox.intersects(wally.hitbox)) {
          snowy.y = 0; 
          snowy.x = randy.nextInt(1000);
          snowy.hitbox.y = snowy.y;
          snowy.hitbox.x = snowy.x; 
        }
      }
    }
 
    //Vertical Collisions with walls
    hitbox.y += yspeed;
    for(MapMaker wall: panel.walls) {
      if (hitbox.intersects(wall.hitbox)) {
        hitbox.y -= yspeed;
        while(!wall.hitbox.intersects(hitbox)) {
          hitbox.y += Math.signum(yspeed);
        }
        hitbox.y -= Math.signum(yspeed);
        yspeed = 0;
        y = hitbox.y;
      }

      for(PresentsAndFire p: panel.presents) {
        if(hitbox.intersects(p.hitbox)) {
          presentsCollected++; 
            p.x = randy.nextInt(1000); 
            p.y = 0; 
            p.hitbox.x = p.x;
            p.hitbox.y = p.y; 
        }
      }

      for(JustFire f: panel.fire) {
        if (hitbox.intersects(f.hitbox)) {
          health--; 
          f.x = randy.nextInt(1000); 
          f.y = 0;
          f.hitbox.x = f.x;
          f.hitbox.y = f.y; 
        }
      }
    }

    // Collisions with Snowflakes
      for(Snowflakes flake: panel.snow) {
        if (hitbox.intersects(flake.hitbox) || flake.hitbox.intersects(panel.t1.hitbox)) {
           flake.y = 0; 
           flake.x = randy.nextInt(1000);
           flake.hitbox.y = flake.y;
           flake.hitbox.x = flake.x; 
              }
             }

    //Horizontal Collisions with Tree
    hitbox.x += xspeed;
      if (hitbox.intersects(panel.t1.hitbox)) {
        hitbox.x -= xspeed;
        while(!panel.t1.hitbox.intersects(hitbox)) {
          hitbox.x += Math.signum(xspeed);
        }
        hitbox.x -= Math.signum(xspeed);
        xspeed = 0;
        x = hitbox.x;
      }

    //Vertical Collisions with Tree
    hitbox.y += yspeed;

      if (hitbox.intersects(panel.t1.hitbox)) {
        hitbox.y -= yspeed;
        while(!panel.t1.hitbox.intersects(hitbox)) {
          hitbox.y += Math.signum(yspeed);
        }
        hitbox.y -= Math.signum(yspeed);
        yspeed = 0;
        y = hitbox.y;
      }



    x += xspeed;
    y += yspeed;
    hitbox.x = x;
    hitbox.y = y; 
  }

  public void draw(Graphics2D my2D) {
    my2D.drawImage(image, x, y, null);
    // my2D.fillRect(x,y,width,height);
  }

  


}
