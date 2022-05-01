package src.Graphics;
import src.GameLogic.*;
import javax.swing.JFrame;
import javax.swing.*;
import src.Graphics.*;
import java.util.Random;

/**
 * Manipulates which screen to display based on buttons clicks. 
 * Starts at the Menu screen
 */
public class ScreenState {
    private static int currentLevel = 1;
    private int width = 800;
    private int height = 800;
    private boolean nextLevel = false;



    /**
     * Checks if level is complete
     */ 
    public void levelComplete(boolean toChange) {
        nextLevel = toChange;
    }

    /**
     * Returns whether level is complete
     */
    public boolean getLevelComplete() {
        return nextLevel;
    }

    /**
     * Default constructor
     */
    public ScreenState() {
        height = 800; 
        width = 800;
    }

  
    /**
     * Resets JFrame screen after button pressed on Menu screen
     */
    public ScreenState(JFrame frame, int width_, int height_) {
        width = width_;
        height = height_;
        // frame.dispose();
        
        
        // LevelBoard level = new LevelBoard(getCurrentLevelFile(), 50, 50);
        // GameBoard board = new GameBoard(width_, height_, level);
        // board.setSize(width_, height_);
        // board.setResizable(false);
        // board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // board.setVisible(true);
    }

    /**
     * Adds board and level components to screen
     */
    public void startGame(JFrame frame) {
        frame.dispose();
        
        // Graphics2D g2d = (Graphics2D) g;
        // Creates and shows the Game Board
        LevelBoard level;
        
        if(currentLevel < 9){
            level = new LevelBoard(getNextLevelFile(), 50,50); // Returns current level file
        }else{
            // 8-12, 200-215, 30-35, 50, 10-25
            int randomness = (int)Math.random() * 4 + 8;
            int crowdedness = (int)Math.random() * 15 + 20;
            int complexity = (int)Math.random() * 5 + 30;
            int scale = 50;
            int allowedMoves = (int)Math.random() * 15 + 10;
            level = new LevelBoard(randomness, crowdedness, complexity, scale, allowedMoves);
        }
        GameBoard board = new GameBoard(width, height, level, currentLevel);
        // updateLevelFiles(currLevelFile);

        board.setSize(width, height);
        board.setResizable(false);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
      
        // Updates current level
        currentLevel++;
    }

    /**
     * Loads the next level's level board and level components to screen
     */
    public void nextLevel(JFrame frame) {
        //Add game end screen
        frame.dispose();
        LevelBoard level;
        if(currentLevel < 9){
            level = new LevelBoard(getNextLevelFile(), 50,25); // Returns current level file
        }else{
            // 8-12, 200-215, 30-35, 50, 10-25
            int randomness = (int)Math.random() * 4 + 8;
            int crowdedness = (int)Math.random() * 15 + 20;
            int complexity = (int)Math.random() * 5 + 30;
            int scale = 50;
            int allowedMoves = (int)Math.random() * 15 + 10;
            level = new LevelBoard(randomness, crowdedness, complexity, scale, allowedMoves);
        }
        currentLevel++;
        GameBoard board = new GameBoard(width, height, level, currentLevel);
        // updateLevelFiles(nextLevelFile);
        
        board.setSize(width, height);
        board.setResizable(false);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);

    }
    
    /**
     * Adds previous level board and level components to screen
     */
    public void previousLevel(JFrame frame) {
        frame.dispose();

        // Checks if previous level is valid
        if (currentLevel > 1 && currentLevel < 9) {
            
            // Creates the game board for the previous level
            LevelBoard level = new LevelBoard(getPrevLevelFile(), 50,50); // Replace with previous level .txt
            currentLevel--;
            currentLevel--;
            GameBoard board = new GameBoard(width, height, level, currentLevel);
     

            
            board.setSize(width, height);
            board.setResizable(false);
            board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board.setVisible(true);
            
        }else if(currentLevel >= 9){ // random time!!
            // boiiiiiiiiii
        } else {

            // Pop-up error message for the user
            // Could also just load in level 1 automatically
            JOptionPane.showMessageDialog(frame, "Invalid Level!",
            "Back to Level 1", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Returns current level number
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Returns previous level file as a String
     */
    public String getPrevLevelFile(){
        if (currentLevel - 1 == 0) {
            return "src/Levels/Level1.txt";
        }
        return "src/Levels/Level" + (currentLevel - 2) + ".txt";
    }

    /**
     * Returns next level file as a String
     */
    public String getNextLevelFile() {
        return "src/Levels/Level" + (currentLevel + 1) + ".txt";
    }

    /**
     * Returns current level file as a String
     */
    public String getCurrentLevelFile() {
        return "src/Levels/Level" + currentLevel + ".txt";
    }

    /**
     * Resets level screen and game board
     */
    public void resetLevel(JFrame frame) {
        frame.dispose();
        startGame(frame);
    }

    /**
     * Creates the instruction screen components
     */
    public void displayInstructions(JFrame frame){
        // frame.dispose();
        frame.setResizable(false);
        
        // Creates and instantiates the instruction screen
        Instructions instructions = new Instructions();
    }
}
