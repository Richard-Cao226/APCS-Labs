import java.awt.*;
import javax.swing.*;

/**
    Write a one-sentence summary of your class here.
    Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  Richard Cao
   @version 9/19

   Period - 3
   Assignment - A12.6 - ParallelLines

   Sources - Richard Cao
 */
public class ParallelLines extends JPanel
{
  
    
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    
    int width = getWidth();
    int height = getHeight();
    
    drawIllusion(g, width, height);
  }

  /**
     TODO Write your method description here.
     @param g
     @param width
     @param height
     @param size
   */
  public void drawIllusion(Graphics g, int width, int height)
  {
	  int x = 0, y = 0, xOff, yOff;
	  for(int row = 0; row < 8; row++) {
		  for(int col = 0; col < 7; col++) {
			  g.fillRect(x,y,width/14,height/8);
			  x += width/7;
		  }
		  y += height/8;
		  x = 0;
		  if(row % 2 == 0) {
			  x += 15;
		  }
		  g.drawLine(0, y, getWidth(), y);
	  }
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("ParallelLines");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ParallelLines panel = new ParallelLines();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
