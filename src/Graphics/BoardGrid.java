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
    
    // Maybe this for the other colored blocks to merge
    public void repaint(Color color) {  
        Graphics g = makePanel(color).getGraphics();
        g.setColor(color);
        // g.drawRect(x, y, width, height);
        // g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        //use makepanel to return panel and use it to call repaint


    }

    // Maybe this for goal block
    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        //how to pass position
        g.drawRect(0, 0, 100, 100);
        g.fillRect(0, 0, 100, 100);
        
        // DISCLAIMER: Currently it draws red rectangle but below the white grid squares

	}

        public void DrawBoardGrid(){

            // 2D grid is made
            for (int y = 0; y < 8; y++) {
                gbc.gridx = y;
                for (int x = 0; x < 8; x++) {
                    gbc.gridx = x;
                    Color color = Color.getHSBColor(7, 51, 59);
                    level_.getBlocks().get(level_.BlockIndexAt(x, y)).setColor(ColorType.PURPLE);
                    // displaying each block according to color
                    if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.RED){
                        color = Color.RED;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.YELLOW){
                        color = Color.YELLOW;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.BLUE){
                        color = Color.BLUE;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.GRAY_OBS){
                        color = Color.GRAY;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.WHITE_NEUTRAL){
                        color = Color.WHITE;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.GREEN){
                        color = Color.GREEN;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.ORANGE){
                        color = Color.ORANGE;
                    }else if(level_.getBlocks().get(level_.BlockIndexAt(x, y)).getColor()==ColorType.PURPLE){
                        color = Color.getHSBColor(7, 51, 51); // don't know if this works
                    }

                    add(makePanel(color), gbc);
                }
            }

        }

        public BoardGrid(LevelBoard level) {

            level_ = level;
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());

            gbc = new GridBagConstraints();
            gbc.weightx = 0.25;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.weighty = 0.16;
            gbc.fill = GridBagConstraints.BOTH;
            DrawBoardGrid();
            
        }

        
        ///make a single panel on grid



        
        protected Component makePanel(Color color) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            return panel;
        }
    }

