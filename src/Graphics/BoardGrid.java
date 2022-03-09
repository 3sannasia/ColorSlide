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
            for (int y = 2; y < 10; y++) {
                gbc.gridx = y;
                for (int x = 0; x < 8; x++) {
                    gbc.gridx = x;
                    Color color = Color.GRAY;
                    add(makePanel(color), gbc);
                }
            }
        }

        protected Component makePanel(Color color) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            return panel;
        }

        protected Component makeSmallerPane() {
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setOpaque(false);
            panel.setLayout(new GridBagLayout());;
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 0.25;
            gbc.weighty = 0.5;
            gbc.insets = new Insets(0, 0, 0, 4);

            int topGap = 0;
            int bottomGap = 4;
            for (int y = 0; y < 1; y++) {
                gbc.gridy = y;
                for (int x = 0; x < 1; x++) {
                    gbc.gridx = x;
                    switch (x) {
                        case 0:
                            gbc.insets = new Insets(topGap, 0, bottomGap, 4);
                            break;
                        case 3:
                            gbc.insets = new Insets(topGap, 4, bottomGap, 0);
                            break;
                        default:
                            gbc.insets = new Insets(topGap, 4, bottomGap, 4);
                            break;
                    }
                    panel.add(makePanel(Color.DARK_GRAY), gbc);
                }
                topGap = 4;
                bottomGap = 0;
            }

            return panel;
        }

    }

