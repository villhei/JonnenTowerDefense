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
    final int verSize = 600;
    private Game TDGame;
    
    public GameWindow(Game game) {
        this.TDGame = game;
        this.TDArea = new GameArea(area);
        frame = new JFrame("Jonnen Tower Defense");
        frame.setSize(horSize,verSize);
        frame.setLayout(new GridLayout());
        frame.setBackground(Color.black);
        JPanel paneeli = new JPanel();
        paneeli.setSize(60, 60);
        paneeli.setVisible(true);
        frame.add(paneeli);
        paneeli.setVisible(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   
}
