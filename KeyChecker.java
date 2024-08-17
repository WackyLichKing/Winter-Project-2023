import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyChecker extends KeyAdapter {
    gamePanel panel;

    public KeyChecker(gamePanel panel) {
        this.panel = panel; 
    }
    @Override
    public void keyPressed(KeyEvent e) {
        panel.keyPressed(e); 
    }

    @Override 
    public void keyReleased(KeyEvent e) {
        panel.keyReleased(e); 
    }



}