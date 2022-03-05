package src;

import javax.swing.JFrame;

import src.GameLogic.Direction;
import src.GameLogic.LevelBoard;

public class Main {
    public static void main (String[] args) {

        final int WIDTH = 800;
        final int HEIGHT = 500;
        JFrame frame = new JFrame("Menu Screen");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        ScreenRenderer renderer = new ScreenRenderer(WIDTH, HEIGHT);
		frame.add(renderer);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Try reading in a Test Case
        LevelBoard level = new LevelBoard("src/Levels/LevelTest.txt", 100);
        System.out.println(level.getLevelInfo());

        int indexRedBlock1 = level.BlockIndexAt(650, 150);
        System.out.println(indexRedBlock1 + " ");

        level.push(indexRedBlock1, Direction.DOWN);


        for(int i = 0; i < 50; i++){
            level.update();
            System.out.println(level.getBlocks().get(indexRedBlock1).getBlockInfo());
        }
    }
}