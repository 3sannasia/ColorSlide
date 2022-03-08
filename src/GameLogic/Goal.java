package src.GameLogic;

public class Goal {

    //-------- Spatial --------//

    private int x;
    private int y;

    private int width;
    private int height;

    //-------- Color --------//

    private ColorType color;

    //-------- Constructor --------//

    public Goal(ColorType colorSet, int xSet, int ySet, int widthSet, int heightSet) {

        // Set Spatial and Color Variables
        color = colorSet;
        x = xSet;
        y = ySet;
        width = widthSet;
        height = heightSet;
    }

    //-------- Spatial Getters --------//

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ColorType getColor() {
        return color;
    }

    public int getClosestLatticeX(int scale) {
        return this.x - (this.x % scale);
    }

    public int getClosestLatticeY(int scale) {
        return this.y - (this.y % scale);
    }
    
    //-------- Status Checks with Blocks --------//

    public boolean Satisfied(Block potential) {

        // Goal is satisfied if block is not moving and dims align
        return (!potential.isMoving() &&
            
                (potential.getColor() == color) &&
                (potential.getX() == x) && 
                (potential.getY() == y) &&
                (potential.getWidth() == width) && 
                (potential.getHeight() == height));
    }

}
