package src;
import javax.swing.JFrame;

public class GUI {
    public static void main (String[] args) {
        int width = 500;
        int height = 500;
        JFrame frame = new JFrame("Menu Screen");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}