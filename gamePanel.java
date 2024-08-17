import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;

public class gamePanel extends JPanel implements ActionListener{


    Character c1;
    Tree t1; 
    LinkedList<MapMaker> walls = new LinkedList<>(); 
    LinkedList<Snowflakes> snow = new LinkedList<>();
    ArrayList<PresentsAndFire> presents = new ArrayList<>(); 
    ArrayList<JustFire> fire = new ArrayList<>(); 
    java.util.Timer timer; 
    Random randy = new Random();
    JPopupMenu leaderboard; 
    JFrame frame; 

    public gamePanel(JFrame frame) {
        this.frame = frame; 
        this.setLayout(new GridLayout()); 
        c1 = new Character(400, 300, this);
        t1 = new Tree(50, 710, this); 
         makeFloor(); 
         makeSnow(); 
        makePresents(); 
        makeFire(); 
        timer = new java.util.Timer(); 
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                c1.set();
                repaint(); 
            }
        
    }, 0, 17);

}
    public void makeFire() {
        for(int i = 0; i < 10; i++ ) {
            fire.add(new JustFire()); 
        }
    }
    public void makeFloor() {
    for (int i = 0; i<1100; i+= 50) {
        walls.add(new MapMaker(i, 950, 50, 50));
    }
        // walls.add(new MapMaker(50, 850, 50, 50));
        walls.add(new MapMaker(700, 500, 50, 50));
    }

    public void makeSnow() {
        for (int i = 0; i<300; i++) {
            snow.add(new Snowflakes());
        }
    }

    public void makePresents() {
        for (int i = 0; i<3; i++) {
            presents.add(new PresentsAndFire()); 
        }
    }
    public void paint(Graphics g) {
        super.paint(g); 

        Graphics2D snowman = (Graphics2D) g;
        c1.draw(snowman); 


        t1.draw(snowman); 


        for(int i =0; i < walls.size(); i++) {
            walls.get(i).draw(snowman);
        }

        for(int j = -30; j<1000; j+= 130) {
        snowman.fillArc(j,-30,150,70,0,360);
        }

        for(Snowflakes flake: snow) {
            flake.draw(snowman);
        }

        for(PresentsAndFire p: presents) {
            p.draw(snowman); 
        }

        for(JustFire f: fire) {
            f.draw(snowman); 
        }

    }

    void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) {
            c1.left = true; 
        }
        if (e.getKeyChar() == 'w'|| e.getKeyCode() == KeyEvent.VK_UP) {
            c1.up = true; 
        }
        if (e.getKeyChar() == 's'|| e.getKeyCode() == KeyEvent.VK_DOWN) {
            c1.down = true; 
        }
        if (e.getKeyChar() == 'd'|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
            c1.right = true; 
        }

    }

    void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'a'|| e.getKeyCode() == KeyEvent.VK_LEFT) {
            c1.left = false; 
        }
        if (e.getKeyChar() == 'w'|| e.getKeyCode() == KeyEvent.VK_UP) {
            c1.up = false; 
        }
        if (e.getKeyChar() == 's'|| e.getKeyCode() == KeyEvent.VK_DOWN) {
            c1.down = false; 
        }
        if (e.getKeyChar() == 'd'|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
            c1.right = false; 
        }
        if (c1.health <= 0) {
            endGame(); 
            }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void endGame() {
     String name = JOptionPane.showInputDialog(this, "What is your name?");
     System.out.println(name +" "+ c1.getPresents());
   
        frame.dispose(); 
    }
}
