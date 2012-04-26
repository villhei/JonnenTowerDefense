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
    
    /**
         * B = buildable, E = empty, S = start, F = finish.
         */
    private static char[][] area =     {{'B', 'S', 'B', 'B', 'E', 'E', 'E', 'E', 'B', 'B', 'F', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'T', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'T', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'T', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'T', 'B', 'E', 'B', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'B', 'B', 'E', 'T', 'B', 'E', 'B', 'B', 'E', 'B'},
                                        {'B', 'E', 'E', 'E', 'E', 'B', 'B', 'E', 'E', 'E', 'E', 'B'},};
    JFrame frame;
    private GameArea TDArea;
    final int horSize = 600;
    final int verSize = 800;
    private Game TDGame;
    private GameAreaDraw draw;
    
    public GameWindow(Game game) {
        this.TDGame = game;
        this.TDArea = new GameArea(area);
        
        frame = new JFrame("Jonnen Tower Defense");
        frame.setSize(horSize,verSize);
        frame.setLayout(new BorderLayout());
        //frame.setBackground(Color.black);
        frame.setResizable(false);
        
        draw = new GameAreaDraw(TDArea);
        JPanel gamearea = draw.getAreaPanel();
        JPanel menuarea = new JPanel(new GridLayout());
        JPanel build = makeBuildArea();
        JPanel score = makeScoreArea();

//        for (int i = 0; i < 4 ; i++) {
//            JPanel buildpanel = new JPanel();
//            buildpanel.setSize(10,10);
//            buildpanel.setBackground(Color.YELLOW);
//            buildpanel.setVisible(true);
//            build.add(buildpanel);
//        }
        menuarea.add(build);
        menuarea.add(score);
        
        frame.add(gamearea,BorderLayout.NORTH);
        frame.add(menuarea,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
//    public JPanel makeGameArea() {
//        JPanel gamearea = new JPanel(new GridLayout(12,12,1,1));
//        gamearea.setSize(600, 600);
//        gamearea.setPreferredSize(new Dimension(600,600));
//        gamearea.setVisible(true);
//        
//        
//        AreaCell[][] areaArray = TDArea.getArea();
//        for (int i = 0; i < areaArray.length; i++) {
//            for (int j = 0; j < areaArray[0].length; j++) {
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
//            }
//        }
//        return gamearea;
//    }
    
    public JPanel makeBuildArea() {
        JPanel build = new JPanel(new GridLayout(2,2,5,5));
        build.setSize(300,200);
        build.setPreferredSize(new Dimension(300,200));
        build.setBackground(Color.LIGHT_GRAY);
        build.setVisible(true);
        return build;
    }
    
    public JPanel makeScoreArea() {
        JPanel score = new JPanel();
        score.setSize(300,200);
        score.setPreferredSize(new Dimension(300,200));
        score.setBackground(Color.GRAY);
        score.setVisible(true);
        JLabel scoretxt = new JLabel("SCORE");
        score.add(scoretxt);
        return score;
    }
    
    public GameArea getGameArea() {
        return this.TDArea;
    }

    public void repaint() {
        draw.updateCells();
    }
   
}
