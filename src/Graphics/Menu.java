package src.Graphics;
import src.GameLogic.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;

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
    static JMenuItem previous_level;
    static JMenuBar menu_bar;
    static JFrame frame;
    public Menu() {
        // Setting up the window and the menu drop down
        frame = new JFrame("Menu");
        menu_bar = new JMenuBar();
        menu = new JMenu("Play");
        frame.getContentPane();
        play = new JMenuItem("Start");
        instructions = new JMenuItem("Instructions");
        previous_level = new JMenuItem("Previous Level");

        // Adding components to the menu bar
        menu_bar.add(menu);
        menu.add(play);
        menu.add(instructions);
        menu.add(previous_level);
   
        play.addActionListener(this);
        instructions.addActionListener(this);
        previous_level.addActionListener(this);
        frame.setJMenuBar(menu_bar);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    //-------- Loads board when start pressed --------//
    public void StartGame() {
        ScreenState start = new ScreenState(frame);
        start.startGame(new JFrame("Level " + start.getCurrentLevel()));
        
    }

    //-------- Load Previous Level when previous level pressed --------//
    
    public void PreviousLevel() {
        ScreenState previousLevel = new ScreenState(frame);
        previousLevel.previousLevel(new JFrame("Previous Level"));
    }

    //-------- Loads instructions when button pressed --------//
    public void Instructions() {
        //Creates instruction Window
        // Figure out how to wipe and replace the same JFrame
        ScreenState instructions = new ScreenState(frame);
        instructions.displayInstructions(new JFrame("Instructions"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            StartGame();
        }else if(e.getSource() == instructions){
            Instructions();
        }else if (e.getSource() == previous_level){
            PreviousLevel();
         }
    }
}
