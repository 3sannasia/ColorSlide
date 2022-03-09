package src;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import src.Graphics.*;

// import src.GameLogic.Direction;
import src.GameLogic.LevelBoard;

public class Main {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                final int WIDTH = 800;
                final int HEIGHT = 800;
                LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100);
                GameBoard frame = new GameBoard(WIDTH, HEIGHT, level);
                frame.setSize(WIDTH, HEIGHT);
                frame.setResizable(false);


                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


                // Try reading in a Test Case
            
                // System.out.println(level.getLevelInfo());

                // int indexRedBlock1 = level.BlockIndexAt(650, 150);
                // System.out.println(indexRedBlock1 + " ");

                // level.push(indexRedBlock1, Direction.DOWN);


                // for(int i = 0; i < 50; i++){
                //     level.update();
                //     System.out.println(level.getBlocks().get(indexRedBlock1).getBlockInfo());
                // }
            }
        });

        
    }
}