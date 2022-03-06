package src.GameLogic;

public class Goal {
    private int xPos;
    private int yPos;

    private int width;
    private int height;

    private ColorType color;

    //Can NOT move, unlike Blocks

    public Goal(int xPos, int yPos, int width, int height, ColorType color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setY(int y_pos) {
        this.yPos = yPos;
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
        return ((potential.getX() == xPos) && (potential.getY() == yPos) 
        && (potential.getColor() == color) && (potential.getWidth() == width) && (potential.getHeight() == height));
    }

}
