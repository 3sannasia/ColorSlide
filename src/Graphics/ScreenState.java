package src.Graphics;
import src.GameLogic.*;
import javax.swing.JFrame;
import javax.swing.*;
import src.Graphics.*;

/**
 * Manipulates which screen to display based on buttons clicks. 
 * Starts at the Menu screen
 */
public class ScreenState {
    private static int currentLevel = 0;
    private int width = 800;
    private int height = 800;

    /**
     * Returns current level int
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Resets JFrame screen after button pressed on Menu screen
     */
    public ScreenState(JFrame frame, int width_, int height_) {
        width = width_;
        height = height_;
        frame.dispose();
        LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100);
        GameBoard board = new GameBoard(width, height, level);
        board.setSize(width, height);
        board.setResizable(false);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
    }

    /**
     * Adds board and level components to screen
     */
    public void startGame(JFrame frame) {
        frame.dispose();
        
        // Graphics2D g2d = (Graphics2D) g;
        // Creates and shows the Game Board
        LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100);
        GameBoard board = new GameBoard(width, height, level);
        board.setSize(width, height);
        board.setResizable(false);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
      
        // Updates current level
        currentLevel++;;

        //Loading next level if won
        if (level.isComplete()){
            nextLevel(frame);
        }
    }

    /**
     * Loads the next level's level board and level components to screen
     */
    public void nextLevel(JFrame frame) {
        frame.dispose();
        LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100); // Replace with previous level .txt
        GameBoard board = new GameBoard(width, height, level);
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
        if (currentLevel > 1) {
            currentLevel--;
            
            // Creates the game board for the previous level
            LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100); // Replace with previous level .txt
            GameBoard board = new GameBoard(width, height, level);
            board.setSize(width, height);
            board.setResizable(false);
            board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            board.setVisible(true);
            
            
        } else {

            // Pop-up error message for the user
            // Could also just load in level 1 automatically
            JOptionPane.showMessageDialog(frame, "Invalid Level!",
            "Back to Level 1", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates the instruction screen components
     */
    public void displayInstructions(JFrame frame){
        frame.dispose();
        frame.setResizable(false);
        
        // Creates and instantiates the instruction screen
        Instructions instructions = new Instructions();
    }
}
