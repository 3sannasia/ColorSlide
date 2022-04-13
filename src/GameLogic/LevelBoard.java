package src.GameLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

public class LevelBoard {

    private int width;
    private int height;
    private int moves;

    private final int SCALE;

    private ArrayList<Block> blocks;

    private Goal goal;

    // Speed at which blocks move: must be a divisor of SCALE: default to SCALE
    private int speed;

    // Maximum number of moves allowed to complete the level
    private int allowedMoves;

    //-------- Construction Functions --------//

    public LevelBoard(int widthSet, int heightSet, int scale, int allowedMovesSet) {

        width = widthSet;
        height = heightSet;
        allowedMoves = allowedMovesSet;

        blocks = new ArrayList<Block>();
        moves = 0;

        SCALE = scale;
        speed = SCALE;
    }

    public LevelBoard(String fileName, int scale, int speed){
        this(fileName, scale);
        moves = 0;
        setSpeed(speed);
    }

    // Build a level from a textfile, with an explicitly defined scale
    public LevelBoard(String fileName, int scale) {

        // Set Scale
        SCALE = scale;
        speed = SCALE;
        moves = 0;
        System.out.println("Loading level from textfile " + fileName + "...");

        // Attempt file reading
        try{
            
            BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
            String nextline = lineReader.readLine();

            allowedMoves = Integer.parseInt(lineReader.readLine());

            nextline = lineReader.readLine();

            // Reading in width and height
            String[] params = nextline.split(" ");
            width = Integer.parseInt(params[0]) * scale;
            height = Integer.parseInt(params[1]) * scale;
            
            // Read in board blocks
            nextline = lineReader.readLine();
            blocks = new ArrayList<Block>();
            int rowNum = 0;
			while (nextline != null) {
                readInRow(nextline, rowNum);
				nextline = lineReader.readLine();
                rowNum++;
			}

            lineReader.close();

        }catch(Exception e){

            // Create a default 1 by 1 board
            System.out.println(e);
            width = SCALE;
            height = SCALE;
        }
    }

    // Build a level from a string, formatted in the same way as a textfile, with a scale specified in the text
    public LevelBoard(String text){

        String[] lines = text.split("\n");

        // Reading in width, height, and scale
        String[] params = lines[0].split(" ");
        SCALE = Integer.parseInt(params[2]);
        speed = SCALE;

        allowedMoves = Integer.parseInt(params[3]);

        width = Integer.parseInt(params[0]) * SCALE;
        height = Integer.parseInt(params[1]) * SCALE;

        blocks = new ArrayList<Block>();
        moves = 0;

        for(int rowNum = 0; rowNum < height / SCALE; rowNum++){

            // Read in board blocks
            String nextline = lines[rowNum + 1];
            readInRow(nextline, rowNum);
        }
    }

    // Helper for parsing a string row
    public void readInRow(String nextline, int rowNum){

        // Set up character mapping
        Map<String, ColorType> charMap = new HashMap<>(){{
            put("X", ColorType.GRAY_OBS);
            put("W", ColorType.WHITE_NEUTRAL);

            put("R", ColorType.RED);
            put("Y", ColorType.YELLOW);
            put("B", ColorType.BLUE);
            
            put("O", ColorType.ORANGE);
            put("G", ColorType.GREEN);
            put("P", ColorType.PURPLE);
        }};

        String[] items = nextline.split(" ");
        for(int columnNum = 0; columnNum < items.length; columnNum++){
            String item = items[columnNum];

            // If we're at an endline, skip
            if(item.length() != 3){
                continue;
            }

            String id = item.substring(0, 1);
            ColorType obsColorType = charMap.get(id.toUpperCase());

            // If we're at a filler symbol like ., |, or -, skip (see text fille)
            if(obsColorType == null){
                continue;
            }

            // If ID is lowercase, make a goal
            if(id != id.toUpperCase()){
                setGoal(new Goal(obsColorType,
                    columnNum * SCALE,
                    rowNum * SCALE,
                    Integer.parseInt(item.substring(1, 2)) * SCALE,
                    Integer.parseInt(item.substring(2, 3)) * SCALE
                ));
            }else{
            
                // Create Block at correct position, size, and color
                addBlock(new Block(obsColorType,
                    columnNum * SCALE,
                    rowNum * SCALE,
                    Integer.parseInt(item.substring(1, 2)) * SCALE,
                    Integer.parseInt(item.substring(2, 3)) * SCALE
                ));
            }
        }
    }

    // Helper to add block
    public void addBlock(Block block){
        blocks.add(block);
    }

    // Helper to set goal
    public void setGoal(Goal goalSet){
        goal = goalSet;
    }

    //-------- Critical Getters for GUI --------//

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    // Basic information printer for Console
    public String getLevelInfo() {
        String info = "Scaled Dimensions: " + height + ", " + width + "\nMaximum number of moves: " + allowedMoves + "\n";
        for(Block block : blocks){
            info += "  " + block.getBlockInfo() + "\n";
        }
        return info;
    }

    // Printing the board as a grid for testing and visualization
    public String getBoardGrid(){

        // Set up character mapping
        Map<ColorType, String> charMapReverse = new HashMap<>(){{
            put(ColorType.GRAY_OBS, "X");
            put(ColorType.WHITE_NEUTRAL, "W");

            put(ColorType.RED, "R");
            put(ColorType.YELLOW, "Y");
            put(ColorType.BLUE, "B");

            put(ColorType.GREEN, "G");
            put(ColorType.ORANGE, "O");
            put(ColorType.PURPLE, "P");
        }};
        
        String[][] board = new String[height / SCALE][width / SCALE];

        // Iterate over goal, fill in values along the width and height
        String goalFiller = charMapReverse.get(goal.getColor()).toLowerCase();
        int normalizedGoalX = goal.getClosestLatticeX(SCALE) / SCALE;
        int normalizedGoalY = goal.getClosestLatticeY(SCALE) / SCALE;
        for(int col = normalizedGoalX; col < normalizedGoalX + goal.getWidth() / SCALE; col++){
            for(int row = normalizedGoalY; row < normalizedGoalY + goal.getHeight() / SCALE; row++){
                board[row][col] = goalFiller;
            }
        }

        // Iterate over each block, fill in values along the width and height
        for(Block block : blocks){
            String filler = charMapReverse.get(block.getColor());
            int normalizedX = block.getClosestLatticeX(SCALE) / SCALE;
            int normalizedY = block.getClosestLatticeY(SCALE) / SCALE;
            for(int col = normalizedX; col < normalizedX + block.getWidth() / SCALE; col++){
                for(int row = normalizedY; row < normalizedY + block.getHeight() / SCALE; row++){
                    board[row][col] = filler;
                }
            }
        }

        // Read array values into string
        String grid = "";
        for(String[] row : board){
            String rowString = "";
            for(String item : row){

                // If unfilled, use ., else use the given symbol
                if(item == null){
                    rowString = rowString + ". ";
                }else{
                    rowString = rowString + item + " ";
                }
            }
            grid = grid + rowString + "\n";
        }
        return grid;
    }

    //-------- Spatial Getters and Status Checks --------//

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getScale() {
        return SCALE;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAllowedMoves() {
        return allowedMoves;
    }

    public int getMoves() {
        return moves;
    }

    // Useful for detecting if we can move blocks
    public boolean isMoving() {
        for(Block block : blocks){
            if(block.isMoving()){
                return true;
            }
        }
        return false;
    }

    // What block currently covers point (x, y)? (Inclusive)
    public int BlockIndexAt(int x, int y){
        for(int i = 0; i < blocks.size(); i++){
            if((blocks.get(i)).containsCoordsInclusive(x, y)){
                return i;
            }
        }
        return -1;
    }

    //-------- Level Manipulation --------//

    // Move blocks according to stored velocities
    public void update(){
        for(int i = 0; i < blocks.size(); i++){
            Block block = blocks.get(i);
            if(block.isMoving()){

                // Update block
                block.update();

                for(int j = 0; j < blocks.size(); j++){
                    Block potentialCollidor = blocks.get(j);
                    
                    // Check for collisions
                    if(block.isCollidingWith(potentialCollidor) && i != j){

                        ColorType mergeResult = colorMix(block.getColor(), potentialCollidor.getColor());
                        moves++; //Move is complete, so increment moves
                        if(mergeResult != ColorType.WHITE_NEUTRAL){

                            // Merge colors if needed, delete block
                            potentialCollidor.setColor(mergeResult);
                            blocks.remove(i);
                        }else{

                            // Else, stop the block, move back one, and recenter
                            block.backPedal();
                            block.stop();
                            block.recenter(SCALE);
                        }
                    }
                }
            }
        }
    }

    public void update(int numFrames){
        for(int i = 0; i < numFrames; i++){
            update();
        }
    }

    // Attempt to push a block of given index (returns if successful)
    public boolean push(int blockIndex, Direction dir){
        if(!isMoving()){
            if(blocks.get(blockIndex).getColor() == ColorType.GRAY_OBS){
                return false;
            }
            (blocks.get(blockIndex)).push(dir, speed);
            return true;
        }
        return false;
    }

    // Check if the goal is satisfied and moves is within the allowed number
    public boolean isComplete(){

        if(moves > allowedMoves) return false;

        for(Block block : blocks){
            if(goal.Satisfied(block)){
                return true;
            }
        }
        return false;
    }

    // Change speed: true if successful
    public boolean setSpeed(int speedSet){
        if(SCALE % speedSet == 0){
            speed = speedSet;
            return true;
        }
        return false;
    }

    //-------- Color Mixing --------//

    // Return the corect color by mixing two primaries, else White as default
    public static ColorType colorMix(ColorType color1, ColorType color2){

        // Refer to the color hash values
        int colorMix = color1.hashValue * color2.hashValue;

        return colorMix == 6 ? ColorType.ORANGE : 
               colorMix == 15 ? ColorType.GREEN : 
               colorMix == 10 ? ColorType.PURPLE : 
               ColorType.WHITE_NEUTRAL;
    }

}
