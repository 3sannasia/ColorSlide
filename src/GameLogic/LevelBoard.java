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

    private Goal target;

    //-------- Construction Functions --------//

    public LevelBoard(int widthSet, int heightSet, int scale) {

        width = widthSet;
        height = heightSet;

        SCALE = scale;

        blocks = new ArrayList<Block>();
    }

    public LevelBoard(String fileName, int scale) {

        // Set Scale
        SCALE = scale;
        System.out.println("Loading level from textfile " + fileName + "...");

        // Attempt file reading
        try{
            
            BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
            String nextline = lineReader.readLine();

            // Set up character mapping
            Map<String, ColorType> charMap = new HashMap<>(){{
                put("X", ColorType.GRAY_OBS);
                put("R", ColorType.RED);
                put("O", ColorType.ORANGE);
                put("Y", ColorType.YELLOW);
                put("G", ColorType.GREEN);
                put("B", ColorType.BLUE);
                put("P", ColorType.PURPLE);
                put("W", ColorType.WHITE_NEUTRAL);
            }};

            // Reading in width and height
            String[] params = nextline.split(" ");
            width = Integer.parseInt(params[0]) * scale;
            height = Integer.parseInt(params[1]) * scale;
            
            // Read in board blocks
            nextline = lineReader.readLine();
            blocks = new ArrayList<Block>();
            int rowNum = 0;
			while (nextline != null) {
                String[] items = nextline.split(" ");
                for(int columnNum = 0; columnNum < items.length; columnNum++){
                    String item = items[columnNum];

                    // If we're at an endline, skip
                    if(item.length() != 3){
                        continue;
                    }

                    ColorType obsType = charMap.get(item.substring(0, 1));

                    // If we're at a filler symbol like ., |, or -, skip (see text fille)
                    if(obsType == null){
                        continue;
                    }
                    
                    // Create Block at correct position, size, and color
                    AddBlock(new Block(obsType,
                        columnNum * SCALE,
                        rowNum * SCALE,
                        Integer.parseInt(item.substring(1, 2)) * SCALE,
                        Integer.parseInt(item.substring(2, 3)) * SCALE
                    ));
                }
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

    // Helper to add block
    public void AddBlock(Block block){
        blocks.add(block);
    }

    // Helper to add goal
    public void AddGoal(Goal goal){
        target = goal;
    }

    //-------- Critical Getters for GUI --------//

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    // Basic information printer for Console
    public String getLevelInfo() {
        String info = "Scaled Dimenions: " + height + ", " + width + "\n";
        for(Block block : blocks){
            info += "  " + block.getBlockInfo() + "\n";
        }
        return info;
    }

    //-------- Spatial Getters and Status Checks --------//

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    // Move blocks according to stored velocities and handle collisions
    public void update(){
        for(int i = 0; i < blocks.size(); i++){
            Block block = blocks.get(i);
            if(block.isMoving()){

                block.update();

                for(int j = 0; j < blocks.size(); j++){
                    Block potentialCollidor = blocks.get(j);

                    // If a collision is seen, stop the block, move back one, and recenter
                    if(block.isCollidingWith(potentialCollidor) && i != j){
                        System.out.println("Collision Detected with block " + potentialCollidor.getBlockInfo());
                        block.backPedal();
                        block.stop();
                        block.recenter(SCALE);
                    }

                }
            }
        }
    }

    // Attempt to push a block of given index (returns if successful)
    public boolean push(int blockIndex, Direction dir){
        if(!isMoving()){
            (blocks.get(blockIndex)).push(dir, SCALE / 10);
            return true;
        }
        return false;
    }
}
