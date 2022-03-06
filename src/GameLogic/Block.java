package src.GameLogic;
public class Block {

    //-------- Spatial --------//

    private int x;
    private int y;

    private int width;
    private int height;

    private int xVel;
    private int yVel;

    //-------- Color --------//

    private ColorType color;

    //-------- Constructor --------//

    public Block(ColorType colorSet, int xSet, int ySet, int widthSet, int heightSet) {

        // Set Spatial and Color Variables
        color = colorSet;
        x = xSet;
        y = ySet;
        width = widthSet;
        height = heightSet;
        xVel = 0;
        yVel = 0;
    }

    //-------- Spatial Getters --------//

    // Basic information printer for Console
    public String getBlockInfo() {
        return "Block: X " + x + ", Y " + y + ", Width " + width + ", Height " + height + ", Color: " + color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //-------- Color Get/Set --------//

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    //-------- Block Manipulation --------//

    public void update() {
        this.x += this.xVel;
        this.y += this.yVel;
    }    

    // Move back one step if needed
    public void backPedal() {
        this.x -= this.xVel;
        this.y -= this.yVel;
    }

    // Set velocities to 0
    public void stop() {
        this.xVel = 0;
        this.yVel = 0;
    }

    // Set a velocity based on push direction
    public void push(Direction dir, int speed) {
        if(dir == Direction.UP){
            yVel = -speed;
        }else if(dir == Direction.DOWN){
            yVel = speed;
        }else if(dir == Direction.LEFT){
            xVel = -speed;
        }else if(dir == Direction.RIGHT){
            xVel = speed;
        }
    }

    // Shift position to closest lattice point on ((x * SCALE), (y * SCALE))
    public void recenter(int scale) {
        this.x = this.x - (this.x % scale);
        this.y = this.y - (this.y % scale);
    }

    //-------- Movement Status Checks --------//
    
    public boolean isMoving() {
        return (xVel != 0) || (yVel != 0);
    }

    public Direction getDirection() {
        if(isMoving()){
            return Direction.STILL;
        }
        return  yVel < 0 ? Direction.UP : 
                yVel > 0 ? Direction.DOWN :
                xVel < 0 ? Direction.RIGHT :
                Direction.LEFT;
    }

    // Check if (x, y) is within the bounds of the block (useful for collision detection)
    public boolean containsCoordsExclusive(int pointX, int pointY) {
        return 
            // horizantal bounds
            x < pointX && x + width > pointX && 
            // vertical bounds
            y < pointY && y + height > pointY; 
    }

    // Check if (x, y) is within or equal to the bounds of the block (useful for collision detection)
    public boolean containsCoordsInclusive(int pointX, int pointY) {
        return 
            // horizantal bounds
            x <= pointX && x + width >= pointX && 
            // vertical bounds
            y <= pointY && y + height >= pointY; 
    }    

    // Central Hitbox detection (Exclusive)
    public boolean isCollidingWith(Block other){
        return isMoving() && 
            // if other contains upper left corner
            other.containsCoordsExclusive(getX(), getY()) ||  
            // if other contains lower left corner
            other.containsCoordsExclusive(getX(), getY() + getHeight())  ||
            // if other contains upper right corner
            other.containsCoordsExclusive(getX() + getWidth(), getY())  ||
            // if other contains lower right corner
            other.containsCoordsExclusive(getX() + getWidth(), getY() + getHeight());
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
