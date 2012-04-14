/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public class GameArea {
    
    private char[][] area;
    private AreaCell[][] gameArea;
    
    public GameArea(char[][] area) {
        this.area = area;
        boolean buildable = false;
        boolean route = false;
        boolean start = false;
        boolean finish = false;
        
        gameArea = new AreaCell[area.length][area[0].length];
        for (int i = 0; i < gameArea.length; i++) {
            for (int j = 0; j < gameArea[0].length; j++) {
                if(area[i][j] == 'B') {
                    buildable = true;
                    route = false;
                    start = false;
                    finish = false;
                }
                if(area[i][j] == 'E') {
                    buildable = false;
                    route = true;
                    start = false;
                    finish = false;
                }
                if(area[i][j] == 'S') {
                    buildable = false;
                    route = true;
                    start = true;
                    finish = false;
                }
                if(area[i][j] == 'F') {
                    buildable = false;
                    route = true;
                    start = false;
                    finish = true;
                }
                gameArea[i][j] = new AreaCell(buildable,route,start,finish);
            }
        }
    }
    
    public AreaCell[][] getArea() {
        return gameArea;
    }
     
    public int greatestDistance() {
        return Math.max(area.length, area[0].length);
    }
}
