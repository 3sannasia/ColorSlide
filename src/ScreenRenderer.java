package src;

import src.GameLogic.*;
import javax.swing.*;
import java.awt.*;

public class ScreenRenderer extends JComponent{

    private final int WINDOW_WIDTH;
	private final int WINDOW_HEIGHT;

	// generic declarations for testing
	private LevelBoard currentBoard;
	private Block block1;
	private Block block2;
	private Block block3;


	//-------- Construct with basic Board --------//

	public ScreenRenderer(int width, int height) {
		WINDOW_WIDTH = width;
		WINDOW_HEIGHT = height;

		// Generic assignments for testing
		currentBoard = new LevelBoard(500, 400);

		block1 = new Block(ColorType.RED, 500, 400);
		block2 = new Block(ColorType.YELLOW, 300, 200);
		block3 = new Block(ColorType.BLUE, 600, 300);
    }

	//-------- Driver Paint function (called automatically) --------//

    public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		drawBoard(g);
		drawBlock(g, block1);
		drawBlock(g, block2);
		drawBlock(g, block3);
    }

	//-------- Draw Stored Components --------//

	// Example: Rending an item of a fixed name
	public void drawBoard(Graphics2D g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

		g.setColor(new Color(100, 100, 100));
		g.fillRect(WINDOW_WIDTH / 2 - currentBoard.getWidth() / 2,
				   WINDOW_HEIGHT / 2 - currentBoard.getHeight() / 2, 
				   currentBoard.getWidth(), 
				   currentBoard.getHeight()
		);
    }

	// Example: Calling a function to render a customizable item type
	public void drawBlock(Graphics2D g, Block block){

		// Reading private data through getter functions to render accordingly
		if(block.getColor() == ColorType.RED){
			g.setColor(new Color(255, 0, 0));
		}else if(block.getColor() == ColorType.YELLOW){
			g.setColor(new Color(200, 200, 0));
		}else if(block.getColor() == ColorType.BLUE){
			g.setColor(new Color(0, 0, 255));
		}else {
			g.setColor(new Color(255, 255, 255));
		}
		g.fillRect(block.getX_pos(), block.getY_pos(), 50, 50);
    }

}
