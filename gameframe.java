import java.util.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

public class gameframe extends javax.swing.JFrame{
    public gameframe() {
    gamePanel panel = new gamePanel(this); 
    panel.setLocation(0,0);
    panel.setSize(new DimensionUIResource(1000,1000)); 
    panel.setBackground(Color.lightGray);
    panel.setVisible(true);
    this.add(panel);
    infoPanel inPanel = new infoPanel(panel);
    inPanel.setLocation(100,100);
    inPanel.setSize(new DimensionUIResource(100, 500));
    inPanel.setBounds(100,100,100,500);
    inPanel.setOpaque(false);
    inPanel.setVisible(true);
    this.add(inPanel, BorderLayout.WEST);

    addKeyListener(new KeyChecker(panel));
    }
}
