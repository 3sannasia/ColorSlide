package src.Graphics;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * Manipulates which screen to display based on buttons clicks. 
 * Starts at the Menu screen
 */
public class ScreenState {
    private static int currentLevel = 0;

    public int getCurrentLevel() {
        return currentLevel;
    }
    // resets JFrame screen after button pressed on Menu screen
    public ScreenState(JFrame frame) {
        frame.dispose();
    }

    // Adds board and level components to screen
    public void startGame(JFrame frame) {
        frame.dispose();
        //Remember to take into account continueing a level from before
        currentLevel++;
    }

    // Adds previous level board and level components to screen
    public void previousLevel(JFrame frame) {
        frame.dispose();
        if (currentLevel > 1) {
            currentLevel--;
        } else {
            // JFrame popup invalid screen
        }
    }

    // Creates the instruction screen components
    public void displayInstructions(JFrame frame){

    }
}
