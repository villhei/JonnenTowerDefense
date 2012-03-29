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
public class GameWindow extends JPanel{
    
    
    private static char[][] area = {{'B', 'B', 'S', 'B', 'B'},
                                    {'B', 'B', 'E', 'B', 'B'},
                                    {'B', 'B', 'E', 'B', 'B'},
                                    {'B', 'B', 'E', 'B', 'B'},
                                    {'B', 'B', 'F', 'B', 'B'}};
    JFrame frame;
    private GameArea TDArea;
    private AreaCell[][] AreaArray;
    private int horSize;// = AreaArray.length*60;
    private int verSize;// = AreaArray[0].length*60;
    private Game TDGame;
    
    public GameWindow(Game game) {
        this.TDGame = game;
        this.TDArea = new GameArea(area);
        this.AreaArray = TDArea.getArea();
        horSize = AreaArray.length*60;
        verSize = AreaArray[0].length*60;
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
    
    @Override public void paint(Graphics g) {
        super.paint(g);
        
    }
   
}
