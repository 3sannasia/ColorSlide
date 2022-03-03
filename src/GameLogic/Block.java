package src.GameLogic;
public class Block {

    //-------- Spatial --------//

    private int x_pos;
    private int y_pos;

    private int width;
    private int height;

    private int x_vel;
    private int y_vel;

    //-------- Color --------//

    private ColorType color;

    //-------- Constructor --------//

    public Block(ColorType color, int x_pos, int y_pos, int width, int height) {

        this.color = color;

        this.x_pos = x_pos;
        this.y_pos = y_pos;

        this.width = width;
        this.height = height;

        x_vel = 0;
        y_vel = 0;
    }

    //-------- Spatial Get/Set --------//

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
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
        this.x_pos += this.x_vel;
        this.y_pos += this.y_vel;
    }    

    public void recenter(int scale) {
        this.x_pos = this.x_pos % scale;
        this.y_pos = this.y_pos % scale;
    }

    public void push(Direction dir, int speed) {
        if(dir == Direction.UP){
            y_vel = -speed;
        }else if(dir == Direction.DOWN){
            y_vel = speed;
        }else if(dir == Direction.LEFT){
            x_vel = -speed;
        }else if(dir == Direction.RIGHT){
            x_vel = speed;
        }
    }

    public void stop() {
        this.x_vel = 0;
        this.y_vel = 0;
    }

    //-------- Status Checks --------//
    
    public boolean isMoving() {
        return (x_vel != 0) || (y_vel != 0);
    }

    public Direction direction() {
        if(isMoving()){
            return Direction.STILL;
        }
        return  y_vel < 0 ? Direction.UP : 
                y_vel > 0 ? Direction.DOWN :
                x_vel < 0 ? Direction.RIGHT :
                Direction.LEFT;
    }

    public boolean coordinatesIn(int x, int y) {
        return 
            // horizantal bounds
            getX_pos() < x && getX_pos() + getWidth() > x && 
            // vertical bounds
            getY_pos() < y && getY_pos() + getHeight() > y; 
    }    

    public boolean isCollidingWith(Block other){

        // function assumes that we're examining the moving block and potential collisions with other blocks.
        if(isMoving() && other.isMoving()){

            // Two blocks aren't supposed to be moving at once... Bro, you broke it didn't you.
            return true;
        }

        return isMoving() && 
            // approach from above check
            (direction() == Direction.UP    && other.coordinatesIn(getX_pos(), getY_pos()) && other.coordinatesIn(getX_pos() + getWidth(), getY_pos()))  || 
            // approach from below check
            (direction() == Direction.DOWN  && other.coordinatesIn(getX_pos(), getY_pos() + getHeight()) && other.coordinatesIn(getX_pos() + getWidth(), getY_pos() + getHeight())) ||
            // approach from left check
            (direction() == Direction.LEFT  && other.coordinatesIn(getX_pos(), getY_pos()) && other.coordinatesIn(getX_pos(), getY_pos() + getHeight())) || 
            // approach from right check
            (direction() == Direction.RIGHT && other.coordinatesIn(getX_pos() + getWidth(), getY_pos()) && other.coordinatesIn(getX_pos() + getWidth(), getY_pos() + getHeight()));
    }


    //-------- Color Mixing --------//



}
