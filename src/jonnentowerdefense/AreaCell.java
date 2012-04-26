/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.Color;
import java.awt.Graphics;
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
    private boolean monster;
    private boolean tower;
    private Location nextCell;

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

    public void putMonster() {
        this.monster = true;
    }

    public void remMonster() {
        this.monster = false;
    }

    public boolean hasMonsters() {
        return monster;
    }

    public void setTower() {
        this.tower = true;
    }

    public boolean hasTower() {
        return tower;
    }

    public void setNextCellonRoute(Location nextCell) {
        this.nextCell = nextCell;
    }

    public Location nextCellOnRoute() {
        return nextCell;
    }

    @Override
    public void paint(Graphics gfx) {

        if (route) {
            if (hasMonsters()) {
                drawMonster(gfx);
            } else {
                this.drawRoad(gfx);
            }
            if (start) {
                this.drawStart(gfx);
            }
            if (finish) {
                this.drawFinish(gfx);
            }

        }
        if (hasMonsters()) {
            this.drawMonster(gfx);
        }
        if (buildable && !hasTower()) {
            this.drawBuild(gfx);
        } else if (hasTower()) {
            this.drawTower(gfx);
        }
    }

    public void drawStart(Graphics gfx) {
        gfx.setColor(Color.blue);
        gfx.fillRect(0, 0, 50, 50);
    }

    public void drawFinish(Graphics gfx) {
        gfx.setColor(Color.red);
        gfx.fillRect(0, 0, 50, 50);
    }

    public void drawRoad(Graphics gfx) {
        gfx.setColor(Color.gray);
        gfx.fillRect(0, 0, 50, 50);
    }

    public void drawBuild(Graphics gfx) {
        gfx.setColor(Color.green);
        gfx.fillRect(0, 0, 50, 50);
    }

    public void drawTower(Graphics gfx) {
        gfx.setColor(Color.black);
        gfx.fillRect(0, 0, 50, 50);
    }

    public void drawMonster(Graphics gfx) {
        gfx.setColor(Color.red);
        gfx.fillOval(10, 10, 30, 30);
    }
}
