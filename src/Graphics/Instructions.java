package src.Graphics;
import src.GameLogic.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
/**
 * 
 */
public class Instructions extends JFrame {


    static JFrame frame;
    static JPanel panel;

    private int height = 800;
    private int width = 800;

    public Instructions() { //ADD APPEALING IMAGE/GIF

        frame = new JFrame("Instructions");
        panel = new JPanel();

        //Added frame components
        JLabel instructionLabel = new JLabel("Instructions");
        frame.setTitle("Rules");

        panel.add(instructionLabel);
        panel.setBackground(Color.orange);

        //Places instructions label in the center of the screen
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setResizable(false);
        
        // Load Instructions frame
    }
    public Instructions(int width, int height) {
        frame = new JFrame("Instructions");
        panel = new JPanel();

        //Added frame components 
        //COULD ADD BLOCK SLIDING GIF
        frame.setTitle("Rules");
        JLabel instructionLabel = new JLabel("Instructions");
        panel.add(instructionLabel);
        panel.setBackground(Color.orange);
        frame.add(panel, BorderLayout.CENTER);

        //Set frame to right size
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
