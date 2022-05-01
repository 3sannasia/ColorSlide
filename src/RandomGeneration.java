package src;

import src.GameLogic.Direction;
import src.GameLogic.LevelBoard;

public class RandomGeneration {
    public static void main (String[] args) {
        // Size, crowdedness, complexity
        int randomness = (int)Math.random() * 4 + 8;
        int crowdedness = (int)Math.random() * 15 + 20;
        int complexity = (int)Math.random() * 5 + 30;
        int scale = 50;
        int allowedMoves = (int)Math.random() * 15 + 10;
        LevelBoard level = new LevelBoard(randomness, crowdedness, complexity, scale, allowedMoves);
        System.out.println(level.getBoardGrid());
    }
}