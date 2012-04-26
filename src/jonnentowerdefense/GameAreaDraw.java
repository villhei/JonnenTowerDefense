/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jonnaira
 */
public class GameAreaDraw extends JPanel {
    
    private GameArea TDArea;
    private JPanel gamearea;
    private AreaCell[][] areaArray;
    
    public GameAreaDraw(GameArea TDArea) {
        this.TDArea = TDArea;
        
        gamearea = new JPanel(new GridLayout(12,12,1,1));
        gamearea.setSize(600, 600);
        gamearea.setPreferredSize(new Dimension(600,600));
        gamearea.setVisible(true);
        
        
        areaArray = TDArea.getArea();
        for (int i = 0; i < areaArray.length; i++) {
            for (int j = 0; j < areaArray[0].length; j++) {
//                JPanel cell = new JPanel();
//                cell.setSize(50, 50);
//                if(areaArray[i][j].buildCell())
//                    cell.setBackground(Color.green);
//                else if(areaArray[i][j].routeCell() && !areaArray[i][j].isStart() && !areaArray[i][j].isFinish())
//                    cell.setBackground(Color.gray);
//                else if(areaArray[i][j].isStart())
//                    cell.setBackground(Color.blue);
//                else if(areaArray[i][j].isFinish())
//                    cell.setBackground(Color.red);
//                cell.setVisible(true);
//                gamearea.add(cell);
                
                areaArray[i][j].repaint();
                gamearea.add(areaArray[i][j]);
            }
        }
    }
    
    public void updateAreaPanel() {
        
    }
    
    public JPanel getAreaPanel() {
        return this.gamearea;
    }
    
    public void updateCells() {
        
        for (int i = 0; i < areaArray.length; i++) {
            for (int j = 0; j < areaArray[0].length; j++) {
                areaArray[i][j].repaint();
            }
        }
    }
}
