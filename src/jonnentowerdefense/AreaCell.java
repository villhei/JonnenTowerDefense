/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import javax.swing.*;

/**
 *
 * @author jonne
 */
public class AreaCell extends JPanel {
    
    private boolean buildable;
    private boolean route;
    private boolean start;
    private boolean finish;
    
    public AreaCell(boolean buildable, boolean route, boolean start, boolean finish) {
        this.buildable = buildable;
        this.route = route;
        this.start = start;
        this.finish = finish;
    }
    
    public boolean routeCell() {
        return route;
    }
    
    public boolean buildCell() {
        return buildable;
    }
    
    public boolean isStart() {
        return start;
    }
    
    public boolean isFinish() {
        return finish;
    }
    
    public int hasMonsters() {
        return 0;
    }
    
    public boolean hasTower() {
        return false;
    }
    
    public Location nextCellOnRoute() {
        return new Location(0,0);
    }
    
}
