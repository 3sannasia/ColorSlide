package src.GameLogic;
public class Block {
    private Enum color;
    private int x_pos;
    private int y_pos;

    public Block(Enum color, int x_pos, int y_pos) {
        this.color = color;
        this.x_pos = x_pos;
        this.setY_pos(y_pos);
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public Enum getColor() {
        return color;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }
    
    public void setColor(Enum color) {
        this.color = color;
    }    
}
