/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author jonne
 */
public class GameWindow {
    
    
    private static char[][] area = {{'B', 'B', 'S', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'F', 'B', 'B'}};
    JFrame frame;
    private GameArea TDArea;
    final int horSize = 600;
    final int verSize = 800;
    private Game TDGame;
    
    public GameWindow(Game game) {
        this.TDGame = game;
        this.TDArea = new GameArea(area);
        
        frame = new JFrame("Jonnen Tower Defense");
        frame.setSize(horSize,verSize);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.black);
        frame.setResizable(false);
        
        JPanel gamearea = new JPanel(new GridLayout(12,12,1,1));
        gamearea.setSize(600, 600);
        gamearea.setPreferredSize(new Dimension(600,600));
        gamearea.setVisible(true);
        
        for (int i = 0; i < 144; i++) {
            JPanel cell = new JPanel();
            cell.setSize(50, 50);
            cell.setBackground(Color.green);
            cell.setVisible(true);
            gamearea.add(cell);
        }
        
        JPanel menuarea = new JPanel(new GridLayout());
        
        JPanel build = new JPanel(new GridLayout(2,2,5,5));
        build.setSize(300,200);
        build.setPreferredSize(new Dimension(300,200));
        build.setBackground(Color.LIGHT_GRAY);
        build.setVisible(true);
        

//        for (int i = 0; i < 4 ; i++) {
//            JPanel buildpanel = new JPanel();
//            buildpanel.setSize(10,10);
//            buildpanel.setBackground(Color.YELLOW);
//            buildpanel.setVisible(true);
//            build.add(buildpanel);
//        }
        
        JPanel score = new JPanel();
        score.setSize(300,200);
        score.setPreferredSize(new Dimension(300,200));
        score.setBackground(Color.GRAY);
        score.setVisible(true);
        JLabel scoretxt = new JLabel("SCORE");
        score.add(scoretxt);
        
        menuarea.add(build);
        menuarea.add(score);
        
        frame.add(gamearea,BorderLayout.NORTH);
        frame.add(menuarea,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   
}
