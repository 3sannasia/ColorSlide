package src.GameLogic;

public enum ColorType {

    GRAY_OBS(0),
    WHITE_NEUTRAL(0),

    RED(2),
    YELLOW(3),
    BLUE (5),

    GREEN(0),
    ORANGE(0),
    PURPLE(0);

    // Primary Colors get prime numbers, useful for color matching
    public final int hashValue;
    ColorType(int hastValueSet){
        hashValue = hastValueSet;
    }
    
}
