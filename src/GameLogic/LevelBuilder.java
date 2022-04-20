package src.GameLogic;

import java.io.PrintWriter;

public class LevelBuilder {

    private String fileName; 
    private LevelBoard level;

    public LevelBuilder(String fileNameSet)
    {
        setFileName(fileNameSet);
        //Default scale 100, can change this later
        level = new LevelBoard(fileName, 100);
    }

    public String writeState()
    {
        PrintWriter pw = new PrintWriter(fileName);
        // Change this so that it prints in the file for the .txt format
        // pw.println(level.getBoardGrid());
        return level.getBoardGrid();
    }

    public void changeBlockColor(int xCoord, int yCoord, ColorType color)
    {
        Block b = findBlock(xCoord, yCoord);
        b.setColor(color);
    }

    public void moveBlock(int xCoordFrom, int yCoordFrom, int xCoordDest, int yCoordDest)
    {
        Block b = findBlock(xCoordFrom, yCoordFrom);
        b = new Block(b.getColor(), xCoordDest, yCoordDest, b.getWidth(), b.getHeight());
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileNameSet) {
        fileName = fileNameSet;
    }

    private Block findBlock(int xCoord, int yCoord)
    {
        for(Block b: level.getBlocks())
        {
            if(xCoord >= b.getX() && xCoord < b.getX()+b.getWidth() && yCoord >= b.getY() && yCoord < b.getY()+b.getHeight())
            {
                return b;
            }
        }
    }

}
