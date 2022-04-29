package src.Graphics;
 
import java.awt.*;
import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 
import javax.swing.*;


// import org.w3c.dom.events.MouseEvent;

import src.GameLogic.ColorType;
import src.GameLogic.Direction;
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

   static JMenu settings;
    static JMenuItem instructions;
    static JMenuItem previousLevel;
    static JMenuItem quit;
    static JMenuItem reset;
    static JFrame frame;
    static JMenuBar menu_bar;
 
 
   int block_idx;
 
 
   //-------- Construct with basic Board --------//
 
   public GameBoard(int width, int height, LevelBoard level, int level_num) {
      
        super("Game Board");
        

          //ADDED BY AKASH
       JFrame frame = new JFrame("Game Board");

       menu_bar = new JMenuBar();
       settings = new JMenu("Settings");
       instructions = new JMenuItem("Instructions");
       previousLevel = new JMenuItem("Previous Level");
       reset = new JMenuItem("Reset");
       quit = new JMenuItem("Quit");

       instructions.setForeground(Color.BLACK);
       previousLevel.setForeground(Color.BLACK);
       previousLevel.setBackground(Color.GREEN);
       quit.setBackground(Color.red);

       menu_bar.add(settings);
       settings.add(instructions);
       settings.add(reset);
       settings.add(previousLevel);
       settings.add(quit);

       instructions.addActionListener(this);
       previousLevel.addActionListener(this);
       quit.addActionListener(this);
       frame.setJMenuBar(menu_bar);
       frame.setSize(width, height);
       // frame.setResizable(false);
       frame.setVisible(true);

      //END OF ADDED BY AKASH

        //backend logic initialization
        currentBoard = level;
      
        Container c = getContentPane();
        c.setBackground(Color.BLACK);
        c.setLayout(new BorderLayout(100, 100));

        // GridBoard
        grid = new BoardGrid(level);

        // adding mouselistener just on the game board grid:
        grid.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
              int drawScale = 40;
              block_idx = level.BlockIndexAt(arg0.getX() * level.getScale() / drawScale, arg0.getY() * level.getScale() / drawScale);
              // block_idx = level.BlockIndexAt(arg0.getX(), arg0.getY());
              System.out.println(arg0.getX() * level.getScale() / drawScale + " " + arg0.getX());
              super.mousePressed(arg0);
            }
          });
        

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

        score = new JLabel("Moves Left: " + (level.getAllowedMoves() - level.getMoves()));
        score.setBounds(600,2, 150, 50);
        score.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        score.setForeground(Color.LIGHT_GRAY);
        
        level_label = new JLabel("Level: " + level_num );
        level_label.setBounds(75,2, 150, 50);
        level_label.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        level_label.setForeground(Color.white);

        // location of all buttons, grid, and labels
        c.setLayout(null);
        c.add( up_button);
        c.add( down_button);
        c.add( left_button);
        c.add( right_button);
        grid.setBounds(200, 200, 1000, 1000);
        c.add(title);
        c.add(score);
        c.add(level_label);
        c.add( grid);


        // button onclick
        up_button.addActionListener(this);
        down_button.addActionListener(this);
        left_button.addActionListener(this);
        right_button.addActionListener(this);
  
   }

 
   //-------- Button Click Action Event Listener --------//  
  
   @Override
   public void actionPerformed(ActionEvent e) {
    Menu menu = new Menu();
    ScreenState state = new ScreenState();
       // TODO Auto-generated method stub
       if(block_idx > 3 && (currentBoard.getAllowedMoves() - currentBoard.getMoves()) > 0){
        if(e.getActionCommand().equals("^")){ // if the user clicks up
             currentBoard.push(block_idx, Direction.UP);
             boolean tt = false;
             while(currentBoard.isMoving()){
                 tt = true;
                 currentBoard.update();
                 repaint();
             }
             block_idx = 0; // resets block_idx so user has to click on new block in order to move it

             // update num moves left
             if(tt){
                score.setText("Moves Left: " + (currentBoard.getAllowedMoves() - currentBoard.getMoves()));
             }
             
            
            
  
        }else if(e.getActionCommand().equals("v")){ // if the user clicks down
             currentBoard.push(block_idx, Direction.DOWN);
             boolean tt = false;
             while(currentBoard.isMoving()){
                tt = true;
                 currentBoard.update();
                 repaint();
             }
             block_idx = 0; // resets block_idx so user has to click on new block in order to move it

              // update num moves left
              if(tt){
                score.setText("Moves Left: " + (currentBoard.getAllowedMoves() - currentBoard.getMoves()));
             }  

             
        }else if(e.getActionCommand().equals("<")){ // if the user clicks left
             currentBoard.push(block_idx, Direction.LEFT);
             boolean tt = false;
             while(currentBoard.isMoving()){
                tt = true;
                 currentBoard.update();
                 repaint();
             }
             block_idx = 0; // resets block_idx so user has to click on new block in order to move it

              // update num moves left
              if(tt){
                score.setText("Moves Left: " + (currentBoard.getAllowedMoves() - currentBoard.getMoves()));
             }  
        }else if(e.getActionCommand().equals(">")){ // if the user clicks right
            currentBoard.push(block_idx, Direction.RIGHT);
            boolean tt = false;
            while(currentBoard.isMoving()){
                tt = true;
                currentBoard.update();
                repaint();
            }
            block_idx = 0; // resets block_idx so user has to click on new block in order to move it
             // update num moves left
             if(tt){
                score.setText("Moves Left: " + (currentBoard.getAllowedMoves() - currentBoard.getMoves()));
             }          
        }
        //Loading next level if won
        if (currentBoard.isComplete()){
            JOptionPane.showMessageDialog(frame, "Onto the next!",
            "Level Completed", JOptionPane.ERROR_MESSAGE);
            state.levelComplete(true);
        }

        else if((currentBoard.getAllowedMoves() - currentBoard.getMoves())<=0){ // if all moves are used, then reset the level
            currentBoard.reset();
            repaint();
        }



        if (state.getLevelComplete() == true) {
            dispose();
            state.startGame(new JFrame());
        }
    }

        if(e.getSource() == instructions){     
            menu.Instructions();
        }else if (e.getSource() == previousLevel){
            menu.PreviousLevel();
        } else if (e.getSource() == quit) {
            dispose();
        } else if (e.getSource() == reset){
            state.resetLevel(this);
        } else {
        }
    }
}



 
 

