package src.Graphics;
 
import java.awt.*;
import java.awt.Container;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;
// import javax.swing.JComponent;
 
// import src.GameLogic.Block;
// import src.GameLogic.ColorType;
import src.GameLogic.LevelBoard;
 
public class GameBoard extends JFrame implements ActionListener{
 
//    private final int WINDOW_WIDTH;
//    private final int WINDOW_HEIGHT;
 
   // buttons
   private JButton up_button;
   private JButton down_button;
   private JButton left_button;
   private JButton right_button;
 

   private JPanel grid;
   private JLabel level_label;
 
   // generic declarations for testing
//    private LevelBoard currentBoard;
 
 
   //-------- Construct with basic Board --------//
 
   public GameBoard(int width, int height, LevelBoard l) {
      
       super("Game Board");
 
    //    WINDOW_WIDTH = width;
    //    WINDOW_HEIGHT = height;
 
      
       Container c = getContentPane();
       c.setBackground(Color.BLACK);

        c.setLayout(new BorderLayout(100, 100));
        grid = new BoardGrid();
       up_button = new JButton("^");
       up_button.setBackground(Color.DARK_GRAY);

       down_button = new JButton("v");
       down_button.setBackground(Color.DARK_GRAY);

       left_button = new JButton("<");
       left_button.setBackground(Color.DARK_GRAY);

       right_button = new JButton(">");
       right_button.setBackground(Color.DARK_GRAY);

 
    //    level_label = new JLabel("Level : 0");

       // location of all buttons
       c.add(BorderLayout.PAGE_START, up_button);
       c.add(BorderLayout.SOUTH, down_button);
       c.add(BorderLayout.WEST, left_button);
       c.add(BorderLayout.EAST, right_button);

       c.add(BorderLayout.CENTER, grid);

       
 
    //    add(level_label, BorderLayout.CENTER);
 
       // button onclick
       up_button.addActionListener(this);
       down_button.addActionListener(this);
       left_button.addActionListener(this);
       right_button.addActionListener(this);
 
 
 
 
      
   }
 
  
   @Override
   public void actionPerformed(ActionEvent e) {
       // TODO Auto-generated method stub
       if(e.getActionCommand().equals("Up")){
 
           System.out.println("up");
 
       }else if(e.getActionCommand().equals("Down")){
 
           System.out.println("down");
 
       }else if(e.getActionCommand().equals("Left")){
 
           System.out.println("left");
 
       }else if(e.getActionCommand().equals("Right")){
 
           System.out.println("right");
 
       }
      
   }
 
}
 

