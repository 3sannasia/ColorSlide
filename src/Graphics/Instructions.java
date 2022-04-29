package src.Graphics;
import src.GameLogic.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Creates the instruction screen
 */
public class Instructions extends JFrame {

    static JFrame frame;
    static JPanel panel;
    static JScrollPane scrollPanel;

    private int height = 800;
    private int width = 800;

    /**
     * Default constructor that creates the instruction screen
     */
    public Instructions() { 

        //Creates frame
        frame = new JFrame("Instructions");

        // Forms the instruction screen image as scrollable 
        ImageIcon instructionsPicture = new ImageIcon("src/Graphics/InstructionGameScreen.jpg");
        JLabel instructionPicLabel = new JLabel(instructionsPicture);
        scrollPanel = new JScrollPane(instructionPicLabel);


        // Adds frame components and the sliding screen
        frame.setTitle("Rules");
        JLabel instructionLabel = new JLabel("Instructions");
        scrollPanel.add(instructionLabel);
        scrollPanel.setBackground(Color.orange);
        frame.add(scrollPanel, BorderLayout.CENTER);

        // Set frame to right size
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    /**
     * Creates the instruction screen
     */
    public Instructions(int width, int height) {

        frame = new JFrame("Instructions");

        // Forms the instruction screen image as scrollable 
        ImageIcon instructionsPicture = new ImageIcon("src/Graphics/InstructionGameScreen.jpg");
        JLabel instructionPicLabel = new JLabel(instructionsPicture);
        scrollPanel = new JScrollPane(instructionPicLabel);


        // Adds frame components and the sliding screen
        frame.setTitle("Rules");
        JLabel instructionLabel = new JLabel("Instructions");
        scrollPanel.add(instructionLabel);
        scrollPanel.setBackground(Color.orange);
        frame.add(scrollPanel, BorderLayout.CENTER);
   
        // Image image = null;
        // try {
        //     image = ImageIO.read(new File("course-project-vf-a/src/Graphics/InstructionGameScreen.jpg"));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

      
        // Image instruction = getScaledImage(image, 800, 800);
        // ImageIcon icon = new ImageIcon(instruction);
        // JLabel label = new JLabel(icon);

        // panel.add(label);
        // frame.add(panel, BorderLayout.CENTER);

        // Set frame to right size
        frame.setResizable(false);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }


    /**
     * Rescales and returns image to specified width and height
     */
    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }
}


