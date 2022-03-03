package src.GameLogic;

import java.util.ArrayList;

public class LevelBoard {

    private int width;
    private int height;

    private final int SCALE;

    private ArrayList<Block> blocks;

    //-------- Construction Functions --------//

    public LevelBoard(int width, int height, int scale) {

        this.width = width;
        this.height = height;

        this.SCALE = scale;

    }

    public void AddBlock (Block block){
        blocks.add(block);
    }

    //-------- Critical Getters for GUI --------//

    public int getBlocks() {
        return blocks;
    }

    //-------- Spatial Get/Set --------//

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    //-------- Status Checks --------//

    public boolean isMoving() {
        for(Block block : blocks){
            if(block.isMoving()){
                return true;
            }
        }
        return false;
    }

    public int BlockIndexAt(int x, int y){
        for(int i = 0; i < blocks.size(); i++){
            if((blocks.get(i)).coordinatesIn(x, y)){
                return i;
            }
        }
        return -1;
    }

    //-------- Level Manipulation --------//

    public void update(){
        for(Block block : blocks){
            if(block.isMoving()){
                block.update();
                for(Block potentialCollidor : blocks){

                    // If a collision is seen, stop the block and recenter it so that everything lines up
                    if(block.isCollidingWith(potentialCollidor)){
                        block.stop();
                        block.recenter(SCALE);
                    }

                }
            }
        }
    }

    public void push(int blockIndex, Direction dir){
        if(!isMoving()){
            (blocks.get(blockIndex)).push(dir, SCALE / 10);
        }
    }
    
}
