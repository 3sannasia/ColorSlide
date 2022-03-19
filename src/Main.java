package src;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.Graphics.*;

// import src.GameLogic.Direction;
// import src.GameLogic.LevelBoard;

public class Main {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                final int WIDTH = 800;
                final int HEIGHT = 800;
                Menu menu = new Menu(WIDTH, HEIGHT);

                //Now the menu controls the screens when buttons are pressed (calls ScreenState.java)


                // if (menu.getGameStarted()) {
                //     LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100);
                //     GameBoard frame = new GameBoard(WIDTH, HEIGHT, level);
                //     frame.setSize(WIDTH, HEIGHT);
                //     frame.setResizable(false);
                //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //     frame.setVisible(true);
                // } else if (menu.getPreviousLevelPressed()) {
                //     LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100); // Replace with previous level .txt
                //     GameBoard frame = new GameBoard(WIDTH, HEIGHT, level);
                //     frame.setSize(WIDTH, HEIGHT);
                //     frame.setResizable(false);
                //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //     frame.setVisible(true);
                // } else if (menu.getInstructionsPressed()) {
                //     Instructions instructionScreen = new Instructions(WIDTH, HEIGHT);
                // }
                

               

                // Try reading in a Test Case
            
                // Try reading in and working Test Case
                // LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100, 100);
                // System.out.println(level.getLevelInfo());

                // int indexRedBlock1 = level.BlockIndexAt(650, 150);

                // level.push(indexRedBlock1, Direction.LEFT);

                // for(int i = 0; i < 6; i++){
                //     level.update();
                //     System.out.println(level.getBoardGrid());
                //     System.out.println(level.getBlocks().get(indexRedBlock1).getBlockInfo());
                //     System.out.println(level.isComplete());
                // }
            }
        });
    }
}