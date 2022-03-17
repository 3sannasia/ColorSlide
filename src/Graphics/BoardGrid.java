package src.Graphics;
 
import java.awt.*;
import java.awt.Container;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;

public class BoardGrid extends JPanel {

        public BoardGrid() {
            setBackground(Color.BLACK);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;

            gbc = new GridBagConstraints();
            gbc.weightx = 0.25;
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.weighty = 0.16;
            gbc.fill = GridBagConstraints.BOTH;


            // 2D grid is made
            for (int y = 2; y < 10; y++) {
                gbc.gridx = y;
                for (int x = 0; x < 8; x++) {
                    gbc.gridx = x;
                    Color color = Color.GRAY;
                    add(makePanel(color), gbc);
                }
            }
        }

        
        ///make a single panel on grid
        protected Component makePanel(Color color) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            return panel;
        }
    }

