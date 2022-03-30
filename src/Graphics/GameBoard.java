package src.Graphics;
 
import java.awt.*;
import java.awt.Container;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;
// import javax.swing.JComponent;

import src.GameLogic.ColorType;
import src.GameLogic.Direction;
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

   private JLabel title;
   private JLabel score;
 

   private BoardGrid grid;
   private JLabel level_label;
 
   // generic declarations for testing
   private LevelBoard currentBoard;
 
 
   //-------- Construct with basic Board --------//
 
   public GameBoard(int width, int height, LevelBoard level) {
      
       super("Game Board");

       //backend logic
       currentBoard = level;
      
        Container c = getContentPane();
        c.setBackground(Color.BLACK);
        c.setLayout(new BorderLayout(100, 100));

        // GridBoard
        grid = new BoardGrid(level);

        
        // buttons
        int move_btn_y = 200;
        int move_btn_x = 20;
        up_button = new JButton("^");
        up_button.setBounds(50 + move_btn_x, 10 + move_btn_y, 30, 30);
       down_button = new JButton("v");
       down_button.setBounds(50+ move_btn_x, 90+ move_btn_y, 30, 30);
       left_button = new JButton("<");
       left_button.setBounds(10+ move_btn_x, 50+ move_btn_y, 30, 30);
       right_button = new JButton(">");
       right_button.setBounds(90+ move_btn_x, 50+ move_btn_y, 30, 30);
       


      //labels
      title = new JLabel("Color Logic Game");
      title.setBounds(250,100, 500, 50);
      title.setFont(new Font("Book Antiqua", Font.PLAIN, 40));
      title.setForeground(Color.LIGHT_GRAY);

      score = new JLabel("Score: 0");
      score.setBounds(600,2, 150, 50);
      score.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
      score.setForeground(Color.LIGHT_GRAY);
      

       // location of all buttons
       c.setLayout(null);
       c.add( up_button);
       c.add( down_button);
       c.add( left_button);
       c.add( right_button);
       grid.setBounds(200, 200, 1000, 1000);
       c.add(title);
       c.add(score);

       c.add( grid);

 
       // button onclick
       up_button.addActionListener(this);
       down_button.addActionListener(this);
       left_button.addActionListener(this);
       right_button.addActionListener(this);
 
 
 
 
      
   }
 
  
   @Override
   public void actionPerformed(ActionEvent e) {
       // TODO Auto-generated method stub
       if(e.getActionCommand().equals("^")){
 
           System.out.println("up");
           currentBoard.getBlocks().get(4).setColor(ColorType.ORANGE);
           currentBoard.push(0, Direction.UP);
           repaint();
           
 
       }else if(e.getActionCommand().equals("v")){
 
           System.out.println("down");
           currentBoard.getBlocks().get(4).setColor(ColorType.PURPLE);
           currentBoard.push(0, Direction.DOWN);
           repaint();
          
 
       }else if(e.getActionCommand().equals("<")){
 
           System.out.println("left");
           currentBoard.getBlocks().get(4).setColor(ColorType.GREEN);
           currentBoard.push(0, Direction.LEFT);
           repaint();
           
 
       }else if(e.getActionCommand().equals(">")){
 
           System.out.println("right");
           currentBoard.getBlocks().get(4).setColor(ColorType.GRAY_OBS);
           repaint();

 
       }
      
   }
 
}
 

