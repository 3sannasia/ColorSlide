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

public class BoardGrid extends JPanel {
    LevelBoard level_;
    GridBagConstraints gbc;

    @Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        System.out.println(level_.getBoardGrid());

        for (int y = 0; y < 300; y+=50) {

            for (int x =0 ; x < 500; x+=50) {

                Color color = Color.CYAN;
                System.out.println(x + " kjdfb " + y);
                
                
                // displaying each block according to color
                int blockIndex = level_.BlockIndexAt(x+25 , y+25 );
               
                if(blockIndex >=0){
                ColorType blockColor = level_.getBlocks().get(blockIndex).getColor();
                
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
                    color = Color.getHSBColor(7, 51, 51); // don't know if this works
                }
            }
                g2d.setColor(color);
		        g2d.fillRect(x , y, 40, 40);
            }
        }

    }
		


    
    // // Maybe this for the other colored blocks to merge
    // public void repaint(Color color) {  
    //     Graphics g = makePanel(color).getGraphics();
    //     g.setColor(color);
    //     // g.drawRect(x, y, width, height);
    //     // g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

    //     //use makepanel to return panel and use it to call repaint


    // }

    // Maybe this for goal block
    // @Override
	// public void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     g.setColor(Color.RED);
    //     //how to pass position
    //     g.drawRect(0, 0, 100, 100);
    //     g.fillRect(0, 0, 100, 100);
        
    //     // DISCLAIMER: Currently it draws red rectangle but below the white grid squares

	// }

      

        public BoardGrid(LevelBoard level) {

            level_ = level;

            System.out.println("skdhfjlkashfan");
            setBackground(Color.BLACK);
  

            gbc = new GridBagConstraints();
            gbc.weightx = 0.25;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.weighty = 0.16;
            gbc.fill = GridBagConstraints.BOTH;
  
            
        }

        
        ///make a single panel on grid

    }

