package src.Graphics;
// import src.GameLogic.*;
import javax.swing.JFrame;


import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public Menu(int width_, int height_) {

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

    // Returns true current screen is on game board screen
    public boolean getGameStarted() {
        return gameStarted;
    }

    // Returns true current screen is on Instruction Screen
    public boolean getInstructionsPressed() {
        return instructionScreen;
    }

    // Returns true current screen is on game board screen
    public boolean getPreviousLevelPressed() {
        return prevLevel;
    }

    // Resets Current Screen State Position
    public void resetScreenBool() {
        gameStarted = false;
        prevLevel = false;
        instructionScreen = false;
    }

    //-------- Loads board when start pressed --------//
    public void StartGame() {
        ScreenState start = new ScreenState(frame, width, height);
        // start.startGame(new JFrame("Level " + start.getCurrentLevel()));
        
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

    // Controls drop down menu buttons 
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
