package src.Graphics;
 
import java.awt.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;

import src.GameLogic.ColorType;
import src.GameLogic.LevelBoard;
import src.GameLogic.Goal;

public class BoardGrid extends JPanel {

    LevelBoard level_;

     //-------- Paint method for updating screen after move/(any chnages) --------//
    @Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        int drawScale = 40;
        Goal goal = level_.getGoal();
        // goes through all pixels in grid and colors them according to the code in backend for each pixel
        for (int y = 0; y < level_.getHeight(); y += level_.getScale()) {
            for (int x = 0 ; x < level_.getWidth(); x+= level_.getScale()) {

                Color color = Color.BLACK;
                for(int xx = 0; xx < goal.getWidth(); xx+=50){
                    for(int yy = 0; yy < goal.getHeight(); yy+=50){
                        if(x == goal.getX() + xx && y == goal.getY() + yy){
                            if(goal.getColor()==ColorType.RED){
                                color = new Color(255, 0, 0, 175);
                            }else if(goal.getColor()==ColorType.YELLOW){
                                color = new Color(255, 255, 0, 175);;
                            }else if(goal.getColor()==ColorType.BLUE){
                                color = new Color(0, 0, 255, 175);
                            }else if(goal.getColor()==ColorType.GRAY_OBS){
                                color = new Color(100, 100, 100, 175);
                            }else if(goal.getColor()==ColorType.WHITE_NEUTRAL){
                                color = new Color(255, 255, 255, 175);
                            }else if(goal.getColor()==ColorType.GREEN){
                                color = new Color(0, 255, 0, 175);
                            }else if(goal.getColor()==ColorType.ORANGE){
                                color = new Color(255, 100, 0, 175);
                            }else if(goal.getColor()==ColorType.PURPLE){
                                color = new Color(255, 0, 255, 175); // don't know if this works
                            } 
                        }
                    
                    }

                }
               
                // displaying each block according to color
                int blockIndex = level_.BlockIndexAt(x + level_.getScale() / 2 , y + drawScale / 2 );
               
                if(blockIndex >=0){
                ColorType blockColor = level_.getBlocks().get(blockIndex).getColor();
                
                // checkign for color to set in the grid
                if(blockColor==ColorType.RED){
                    color = Color.RED;
                }else if(blockColor==ColorType.YELLOW){
                    color = Color.YELLOW;
                }else if(blockColor==ColorType.BLUE){
                    color = Color.BLUE;
                }else if(blockColor==ColorType.GRAY_OBS){
                    color = Color.GRAY;
                }else if(blockColor==ColorType.WHITE_NEUTRAL){
                    color = Color.WHITE;
                }else if(blockColor==ColorType.GREEN){
                    color = Color.GREEN;
                }else if(blockColor==ColorType.ORANGE){
                    color = Color.ORANGE;
                }else if(blockColor==ColorType.PURPLE){
                    color = new Color(255, 0, 255); // don't know if this works
                }
            }
                g2d.setColor(color);
		        g2d.fillRect(x / level_.getScale() * drawScale, y / level_.getScale() * drawScale, drawScale * 4 / 5, drawScale * 4 / 5);
            }
        }


    }
	
     
   //-------- Constructor, initializing backend --------//
    public BoardGrid(LevelBoard level) {
        level_ = level;
        setBackground(Color.BLACK);
    }

}

