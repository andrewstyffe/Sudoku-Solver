import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest {

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("GridLayout Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(9, 9));
    
    for(int i = 0; i < 81; i ++) {
        frame.add(new JButton("Button " + i));
    }
    frame.pack();
    frame.setVisible(true);
  }
}