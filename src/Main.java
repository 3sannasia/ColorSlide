package src;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.Graphics.*;
import src.GameLogic.Direction;
// import src.GameLogic.Direction;
// import src.GameLogic.LevelBoard;


import src.GameLogic.LevelBoard;

public class Main {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                final int WIDTH = 800;
                final int HEIGHT = 800;

                GameBoard frame;
                Menu menu;
                try {
                    menu = new Menu(WIDTH, HEIGHT);
                //     // if (menu.getGameStarted()){
                //     //     level = new LevelBoard("src/Levels/LevelTest.txt", 50, 50);
                //     //     frame = new GameBoard(WIDTH, HEIGHT, level);
                //     //     frame.setSize(WIDTH, HEIGHT);
                //     //     frame.setResizable(false);
                //     //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //     //     frame.setVisible(true);
    
                //     // } else if (menu.getPreviousLevelPressed()) {
                //     //     level = new LevelBoard("src/Levels/LevelTest.txt", 50,50); // Replace with previous level .txt
                //     //     frame = new GameBoard(WIDTH, HEIGHT, level);
                //     //     frame.setSize(WIDTH, HEIGHT);
                //     //     frame.setResizable(false);
                //     //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //     //     frame.setVisible(true);

                //     // } else if (menu.getInstructionsPressed()) {
                //     //     Instructions instructionScreen = new Instructions(WIDTH, HEIGHT);
                //     // }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }




                
                //-------- Tests for Backend --------//

                // // Now the menu controls the screens when buttons are pressed (calls ScreenState.java)
                // Try reading in a Test Case
                
                LevelBoard level = new LevelBoard("course-project-vf-a/src/Levels/Level1.txt", 100, 50);
            
                // System.out.println(level.getLevelInfo());

                // int indexYellowBlock1 = level.BlockIndexAt(750, 750);

                // level.push(indexYellowBlock1, Direction.RIGHT);
                // int indexRedBlock1 = level.BlockIndexAt(650, 150);
                // level.push(indexRedBlock1, Direction.LEFT);

                for(int i = 0; i < 6; i++){
                    level.update();
                    System.out.println(level.getBoardGrid());
                    // System.out.println(level.getBlocks().get(indexYellowBlock1).getBlockInfo());
                    // System.out.println(level.isComplete());
                }
            }
        });
    }
}