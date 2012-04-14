/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
            frame.setResizable(false);
            frame.setBackground(Color.black);
            JPanel playarea = new JPanel(new GridLayout(12,12,1,1));
            playarea.setSize(600, 600);
            playarea.setPreferredSize(new Dimension(600,600));
            playarea.setVisible(true);
            
            
            for (int i = 0; i < 144; i++) {
                //JLabel ruutu = new JLabel(new ImageIcon(mypic));
                JButton ruutu = new JButton();
                ruutu.setVisible(true);
                ruutu.setSize(50,50);
                ruutu.setBackground(Color.green);
                playarea.add(ruutu);
            }
            
            JPanel menuarea = new JPanel(new GridLayout());
            menuarea.setSize(600,200);
            menuarea.setPreferredSize(new Dimension(600,200));
            menuarea.setVisible(true);
            
            JPanel score = new JPanel(new GridLayout());
            score.setSize(300,200);
            score.setPreferredSize(new Dimension(300,200));
            score.setBackground(Color.gray);
            JLabel scoretxt = new JLabel("SCORE");
            score.add(scoretxt);
            score.setVisible(true);
            
            JPanel build = new JPanel(new GridLayout(1, 2, 2, 0));
            build.setSize(300,200);
            build.setPreferredSize(new Dimension(300,200));
            build.setBackground(Color.LIGHT_GRAY);
            JLabel buildtxt = new JLabel("BUILD");
            build.add(buildtxt);
            build.setVisible(true);
            
            menuarea.add(build);
            menuarea.add(score);
            
            frame.add(playarea, BorderLayout.NORTH);
            frame.add(menuarea, BorderLayout.SOUTH);
            
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}