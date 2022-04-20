package src;

import src.GameLogic.Direction;
import src.GameLogic.LevelBoard;

public class RandomGeneration {
    public static void main (String[] args) {
        // Size, crowdedness, complexity
        LevelBoard level = new LevelBoard(20, 200, 30, 100, 100);
        System.out.println(level.getBoardGrid());
    }
}