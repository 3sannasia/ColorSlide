package src;
import javax.swing.JFrame;

public class Main {
    public static void main (String[] args) {
        final int WIDTH = 800;
        final int HEIGHT = 500;
        JFrame frame = new JFrame("Menu Screen");
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);

        ScreenRenderer renderer = new ScreenRenderer(WIDTH, HEIGHT);
		frame.add(renderer);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}