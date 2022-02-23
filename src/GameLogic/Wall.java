package src.GameLogic;

public class Wall {
    private int baseCord;
    private int length;

    public Wall(int baseCord, int length) {
        this.baseCord = baseCord;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getBaseCord() {
        return baseCord;
    }

    public void setBaseCord(int baseCord) {
        this.baseCord = baseCord;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}
