import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class infoPanel extends JPanel {
    JPanel panel; 
    JLabel healthBar;
    JLabel score; 
    java.util.Timer timer; 

    public infoPanel(gamePanel panel) {
        this.panel = panel; 
        healthBar = new JLabel(Integer.toString(panel.c1.health), new ImageIcon("heart.png"),  SwingConstants.LEFT);
        healthBar.setFont(new Font("Sans Serif",Font.BOLD, 24));
        healthBar.setBounds(100,150,100, 50);
        score = new JLabel(Integer.toString(panel.c1.presentsCollected), new ImageIcon("Red_Present.png"), SwingConstants.LEFT);
        score.setBounds(150,250,100, 50 );

        add(healthBar);
        add(score);
        
        timer = new java.util.Timer();
      timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                healthBar.setText(Integer.toString(panel.c1.health));
                score.setText(Integer.toString(panel.c1.presentsCollected));
            }
        }, 17, 10);
    }

}
