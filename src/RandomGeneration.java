package src;

import src.GameLogic.Direction;
import src.GameLogic.LevelBoard;

public class RandomGeneration {
    public static void main (String[] args) {
        LevelBoard level = new LevelBoard(15, 5, 100, 100, 0);
        System.out.println(level.getBoardGrid());
    }
}