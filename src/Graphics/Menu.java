// package src.Graphics;
// import javax.swing.JFrame;
// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.AbstractAction;
// /**
//  * Starting screen
//  * 
//  * 
//  * 
//  * Buttons: Play, Instructions
//  * 
//  * Labels: Previous level
//  * 
//  */
// public class Menu extends JFrame implements ActionListener {
//     static JMenu menu;
//     static JMenuItem play;
//     static JMenuItem instructions;
//     static JMenuItem previous_level;
//     static JMenuBar menu_bar;
//     public Menu() {
//         JFrame frame = new JFrame("Menu");
//         menu_bar = new JMenuBar();
//         menu = new JMenu("Play");
//         play = new JMenuItem(new AbstractAction("Start")) {
//             actionPerformed();
//         };
//         instructions = new JMenuItem("Instructions");
//         previous_level = new JMenuItem("Previous Level");
    
//         menu.add(play);
//         menu.add(instructions);
//         menu.add(previous_level);
//         menu_bar.add(menu);
//         JMenuItem.addActionListener(this);
//         JMenuItem.addActionListener(this);
//         JMenuItem.addActionListener(this);
//         frame.setJMenuBar(menu_bar);
//         frame.setSize(500, 500);
//         frame.setVisible(true);
//     }

//     //-------- Loads board when start pressed --------//
//     public void StartGame() {

//     }

//     //-------- Load Previous Level when previous level pressed --------//
    
//     public void PreviousLevel() {

//     }

//     //-------- Loads instructions when button pressed --------//
//     public void Instructions() {

//     }
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if(e.getActionCommand().equals("Start")){
//             StartGame();
//         }else if(e.getActionCommand().equals("Previous Level")){
//             Instructions();
//         }else if (e.getActionCommand().equals("Previous Level")){
//             PreviousLevel();
//          }
//     }
//     public static void main(String[] args){
//         Menu menu = new Menu();
//     }
    
// }
