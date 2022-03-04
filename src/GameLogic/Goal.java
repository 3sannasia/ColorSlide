package src.GameLogic;

public class Goal {
    private int x_pos;
    private int y_pos;

    private int width;
    private int height;

    private ColorType color;

    //Can NOT move, unlike Blocks

    public Goal(int x_pos, int y_pos, int width, int height, ColorType color) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }
    
    /*
    Check that the block matches with the target to determine if the player has completed the level.
    */
    public boolean match(Block potential)
    {
        return ((potential.getX_pos() == x_pos) && (potential.getY_pos() == y_pos) 
        && (potential.getColor() == color) && (potential.getWidth() == width) && (potential.getHeight() == height));
    }

}
