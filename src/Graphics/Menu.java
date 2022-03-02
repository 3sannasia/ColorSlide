package src.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
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
public class Menu extends JFrame {
    static JMenu menu;
    static JMenuItem play;
    static JMenuItem instructions;
    static JMenuItem previous_level;
    static JMenuBar menu_bar;
    public Menu() {
        JFrame frame = new JFrame("Menu");
        menu_bar = new JMenuBar();
        menu = new JMenu("Play");
        play = new JMenuItem("Start");
        instructions = new JMenuItem("Instructions");
        previous_level = new JMenuItem("Previous Level");
    
        menu.add(play);
        menu.add(instructions);
        menu.add(previous_level);
        menu_bar.add(menu);

        frame.setJMenuBar(menu_bar);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Menu menu = new Menu();
    }
    
}
