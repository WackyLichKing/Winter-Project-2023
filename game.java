import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class game {
  //Frame
  public static void main(String args[]) {
  gameframe test = new gameframe();
  test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  test.setSize(new Dimension(1250, 1000));
  
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  test.setLocation((int) (screenSize.getWidth()/2 - test.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - test.getSize().getHeight()/2));
  test.setResizable(false);
  test.setTitle("Present Collecting Simulator"); 
  test.setVisible(true);

  }

  





}