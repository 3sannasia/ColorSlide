package src.GameLogic;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class LevelBoard {

    private int width;
    private int height;

    private final int SCALE;

    private ArrayList<Block> blocks;

    private Goal goal;

    // Speed at which blocks move: must be a divisor of SCALE: default to SCALE
    private int speed;

    // Unparsed starting level obstacle data for reset(), populates during valid level construction
    private String backup;


    //-------- Construction Functions --------//

    // Construct an empty level.
    // @param widthSet: the width of the level, in block unit lengths
    // @param heightSet: the height of the level, in block unit lengths
    // @param scale: the block unit length
    public LevelBoard(int widthSet, int heightSet, int scale) {

        width = widthSet;
        height = heightSet;

        blocks = new ArrayList<Block>();

        SCALE = scale;
        speed = SCALE;
        backup = "";
    }

    // Construct a level from a text file.
    // @param fileName: the file name of the text file to read from (see sample LevelTest)
    // @param scale: the block unit length
    // @param speed: the speed at which blocks move across a board
    public LevelBoard(String fileName, int scale, int speed){
        this(fileName, scale);
        setSpeed(speed);
    }

    // Construct a level from a text file.
    // @param fileName: the file name of the text file to read from (see sample LevelTest)
    // @param scale: the block unit length
    public LevelBoard(String fileName, int scale) {

        // Set Scale
        SCALE = scale;
        speed = SCALE;
        backup = "";
        System.out.println("Loading level from textfile " + fileName + "...");

        // Attempt file reading
        try{
            
            BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
            String nextline = lineReader.readLine();

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

    // Construct a level from a string in the same way as a textfile, 
    // with a scale specified in the text
    // @param text: the text data to parse
    public LevelBoard(String text){

        String[] lines = text.split("\n");

        // Reading in width, height, and scale
        String[] params = lines[0].split(" ");
        SCALE = Integer.parseInt(params[2]);
        speed = SCALE;
        backup = "";

        width = Integer.parseInt(params[0]) * SCALE;
        height = Integer.parseInt(params[1]) * SCALE;

        blocks = new ArrayList<Block>();

        for(int rowNum = 0; rowNum < height / SCALE; rowNum++){

            // Read in board blocks
            String nextline = lines[rowNum + 1];
            readInRow(nextline, rowNum);
        }
    }

    // Helper for parsing a string row
    // @param nextline: the text data to parse
    // @param rowNum: the level row number to parse to
    public void readInRow(String nextline, int rowNum){

        // Add to backup
        backup = backup + nextline + "\n";

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
    // @param block: the block to add to the level data
    public void addBlock(Block block){
        blocks.add(block);
    }

    // Helper to set goal
    // @param goal: the goal to add to the level data
    public void setGoal(Goal goalSet){
        goal = goalSet;
    }

    //-------- Critical Getters for GUI --------//

    // Helper to get blocks
    // @return: the arraylist of block data
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    // Basic information printer for Console
    // @return: a string enumerating a list of blocks
    public String getLevelInfo() {
        String info = "Scaled Dimenions: " + height + ", " + width + "\n";
        for(Block block : blocks){
            info += "  " + block.getBlockInfo() + "\n";
        }
        return info;
    }

    // Helper for printing the board as a grid for testing and visualization
    // @return: a string enumerating the entire level layout as a grid
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

    // Useful for detecting if we can move blocks
    // @return: whether any block on the board is moving
    public boolean isMoving() {
        for(Block block : blocks){
            if(block.isMoving()){
                return true;
            }
        }
        return false;
    }

    // What block currently covers point (x, y)? (Inclusive)
    // @return: the block arraylist index corresponding to the block at pixel dimensions (x, y)
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

                // Check for collisions
                ArrayList<Block> collisions = new ArrayList<Block>();

                for(int j = 0; j < blocks.size(); j++){
                    Block potentialCollidor = blocks.get(j);

                    // Check for collisions and add to list
                    if(block.isCollidingWith(potentialCollidor) && i != j){
                        collisions.add(potentialCollidor);
                    }
                }

                // Process collisions, if any
                if(!collisions.isEmpty()){
                    // If any collision is a stopping block, return
                    for(int j = 0; j < collisions.size(); j++){
                        Block potentialCollidor = collisions.get(j);
                        ColorType collidorColor = potentialCollidor.getColor();
                        if(collidorColor == ColorType.WHITE_NEUTRAL || collidorColor == ColorType.GRAY_OBS){
                            
                            // Stop the block, move back one, and recenter
                            block.backPedal();
                            block.stop();
                            block.recenter(SCALE);
                        }
                    }

                    // Else, merge with each block and remove initial
                    boolean merged = false;
                    for(int j = 0; j < collisions.size(); j++){
                        Block potentialCollidor = collisions.get(j);
                        ColorType mergeResult = colorMix(block.getColor(), potentialCollidor.getColor());
                        if(mergeResult != ColorType.WHITE_NEUTRAL){
                            potentialCollidor.setColor(mergeResult);
                            merged = true;
                        }
                    }

                    // Delete block
                    if(merged){
                        blocks.remove(i);
                    }else{
                        // Stop the block, move back one, and recenter
                        block.backPedal();
                        block.stop();
                        block.recenter(SCALE);                        
                    }
                }
            }
        }
    }

    // Update a specific number of frames
    public void update(int numFrames){
        for(int i = 0; i < numFrames; i++){
            update();
        }
    }

    // Attempt to push a block of given index (returns if successful)
    // @return: whether the push was successful, or if attempt was cancelled
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

    // Check if the goal is satisfied
    // @return: whether the goal is complete
    public boolean isComplete(){
        for(Block block : blocks){
            if(goal.Satisfied(block)){
                return true;
            }
        }
        return false;
    }

    // Change speed: true if successful; speed must be a divisor of SCALE
    // @return: true is successful
    public boolean setSpeed(int speedSet){
        if(SCALE % speedSet == 0){
            speed = speedSet;
            return true;
        }
        return false;
    }

    // Completely reset a level's block data
    public void reset(){

        // Empty the obstacle information
        blocks.clear();

        String[] lines = backup.split("\n");

        // Repopulate
        backup = "";
        for(int rowNum = 0; rowNum < height / SCALE; rowNum++){

            // Read in board blocks
            String nextline = lines[rowNum];
            readInRow(nextline, rowNum);
        }
    }

    //-------- Color Mixing --------//

    // Return the corect color by mixing two primaries, else White as default
    // @param color1: A color enumeration input
    // @param color2: A color enumeration input
    // @return: The mix of colors, or ColorType.WHITE if no mix
    public static ColorType colorMix(ColorType color1, ColorType color2){

        // Refer to the color hash values
        int colorMix = color1.hashValue * color2.hashValue;

        return colorMix == 6 ? ColorType.ORANGE : 
               colorMix == 15 ? ColorType.GREEN : 
               colorMix == 10 ? ColorType.PURPLE : 
               ColorType.WHITE_NEUTRAL;
    }

}
