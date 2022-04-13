package src.Graphics;
// import src.GameLogic.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import javax.imageio.ImageIO;



/**
 * Starting screen
 * 
 * 
 * 
 * Buttons: Play, Instructions
 * 
 * Labels: Previous level
 * 
 */
public class Menu extends JFrame implements ActionListener {
    static JMenu menu;
    static JMenuItem play;
    static JMenuItem instructions;
    static JMenuItem previousLevel;
    static JMenuItem quit;
    
    static JPanel panel;
    
    static JLabel label;

    static JMenuBar menu_bar;
    static JFrame frame;
    boolean gameStarted = false;
    boolean prevLevel = false;
    boolean instructionScreen = false;

    private int height = 800;
    private int width = 800;

    public Menu() {
        // Setting up the window and the menu drop down
        frame = new JFrame("Menu");
        menu_bar = new JMenuBar();
        menu = new JMenu("Play");
        frame.getContentPane();
        play = new JMenuItem("Start Game");
        instructions = new JMenuItem("Instructions");
        previousLevel = new JMenuItem("Previous Level");
        quit = new JMenuItem("Quit");

        // Adding a gif animation in the title screen
        label = new JLabel("block-sliding.gif");
        frame.add(label, BorderLayout.CENTER);

        //Coloring Drop Down Menu for appealing aesthetics
        play.setBackground(Color.GREEN);
        instructions.setForeground(Color.BLACK);
        previousLevel.setForeground(Color.BLACK);
        quit.setBackground(Color.red);

        // Adding components to the menu bar
        menu_bar.add(menu);
        menu.add(play);
        menu.add(instructions);
        menu.add(previousLevel);
        menu.add(quit);

        // Color Pane
        panel = new JPanel();
        panel.setBackground(Color.orange);
        frame.add(panel, BorderLayout.CENTER);


        play.addActionListener(this);
        instructions.addActionListener(this);
        previousLevel.addActionListener(this);
        quit.addActionListener(this);

        frame.setJMenuBar(menu_bar);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    /**
     * Constructor to load the menu screen
     * @throws IOException
     */
    public Menu(int width_, int height_) throws IOException {

        // Initializes private variables
        width = width_;
        height = height_;

        // Setting up the window and the menu drop down
        frame = new JFrame("Menu");
        menu_bar = new JMenuBar();
        menu = new JMenu("Play");
        frame.getContentPane();
        play = new JMenuItem("Start Game");
        instructions = new JMenuItem("Instructions");
        previousLevel = new JMenuItem("Previous Level");
        quit = new JMenuItem("Quit");

        // Color Pane
        panel = new JPanel();
        panel.setBackground(Color.BLACK);


        // Block sliding gif
        // Adding resized gif image to the menu screen
        Image image = null;
        try {
            image = ImageIO.read(new File("./src/Graphics/block-sliding.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

      
        Image gif = getScaledImage(image, 800, 800);
        ImageIcon icon = new ImageIcon(gif);
        JLabel label = new JLabel(icon);

        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);

        //Coloring Drop Down Menu for appealingaesthetics
        play.setBackground(Color.GREEN);
        instructions.setForeground(Color.BLACK);
        previousLevel.setForeground(Color.BLACK);
        quit.setBackground(Color.red);

        // Adding components to the menu bar
        menu_bar.add(menu);
        menu.add(play);
        menu.add(instructions);
        menu.add(previousLevel);
        menu.add(quit);

        play.addActionListener(this);
        instructions.addActionListener(this);
        previousLevel.addActionListener(this);
        quit.addActionListener(this);

        frame.setJMenuBar(menu_bar);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    /**
     * Returns resized image for the menu screen gif
     */
    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }

    /**
     * Returns true current screen is on game board screen
     */
    public boolean getGameStarted() {
        return gameStarted;
    }

    /**
     * Returns true current screen is on Instruction screen
     */
    public boolean getInstructionsPressed() {
        return instructionScreen;
    }

    /**
     * Returns true current screen is on previous level
     */
    public boolean getPreviousLevelPressed() {
        return prevLevel;
    }

    /**
     * Resets the game screen status 
     */
    public void resetScreenBool() {
        gameStarted = false;
        prevLevel = false;
        instructionScreen = false;
    }

    //-------- Loads board when start pressed --------//
    public void StartGame() {
        ScreenState start = new ScreenState(frame, width, height);
        start.startGame(new JFrame("Level " + start.getCurrentLevel()));
        
    }

    //-------- Load Previous Level when previous level pressed --------//
    public void PreviousLevel() {
        ScreenState previousLevel = new ScreenState(frame, width, height);
        previousLevel.previousLevel(new JFrame("Previous Level"));
    }

    //-------- Loads instructions when button pressed --------//
    public void Instructions() {
        ScreenState instructions = new ScreenState(frame, width, height);
        instructions.displayInstructions(new JFrame("Instructions"));
    }

    /**
     * Controls the drop down menu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            gameStarted = true;
            StartGame();
        }else if(e.getSource() == instructions){
            instructionScreen = true;
            Instructions();
        }else if (e.getSource() == previousLevel){
            prevLevel = true;
            PreviousLevel();
        } else if (e.getSource() == quit) {
            frame.dispose();
        }
    }
}
