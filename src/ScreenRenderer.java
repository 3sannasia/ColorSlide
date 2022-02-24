package src;
import javax.swing.*;
import java.awt.*;

public class ScreenRenderer extends JComponent{

    private final int WIDTH;
	private final int HEIGHT;

	public ScreenRenderer(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
    }

    public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(new Color(0, 0, 100));
		g.fillRect(WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2);
    }

}
