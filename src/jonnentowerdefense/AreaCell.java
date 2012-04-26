/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author jonne
 */
public class AreaCell extends JPanel {

    private GameArea gamearea;
    private boolean buildable;
    private boolean route;
    private boolean start;
    private boolean finish;
    private boolean monster;
    private boolean tower;
    private boolean shot = false;
    private Location nextCell;
    private int hp;
    private Location shooter;
    private Location target;

    public AreaCell(GameArea gamearea, boolean buildable, boolean route, boolean start, boolean finish, boolean tower) {
        this.gamearea = gamearea;
        this.buildable = buildable;
        this.route = route;
        this.start = start;
        this.finish = finish;
        this.tower = tower;
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

    public void setMonsterHP(int hp) {
        this.hp = hp;
    }
    public void setNextCellonRoute(Location nextCell) {
        this.nextCell = nextCell;
    }

    public Location nextCellOnRoute() {
        return nextCell;
    }

    public void setShooter(Location shooter) {
        this.shooter = shooter;
    }
    public Location getShooter() {
        return this.shooter;
    }
    public void setTarget(Location target) {
        this.target = target;
    }
    public Location getTarget() {
        return this.target;
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
        Font font = new Font("Arial Black", 1, 30);
        gfx.setColor(Color.gray);
        gfx.fillRect(0, 0, 50, 50);
        gfx.setFont(font);
        gfx.setColor(Color.BLUE);
        gfx.drawString("S", 15, 35);
    }

    public void drawFinish(Graphics gfx) {
        Font font = new Font("Arial Black", 1, 30);
        gfx.setColor(Color.gray);
        gfx.fillRect(0, 0, 50, 50);
        gfx.setFont(font);
        gfx.setColor(Color.RED);
        gfx.drawString("F", 15, 35);
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
        gfx.fillRect(10, 10, 30, 30);
    }
    
    public void drawShoot(Graphics gfx) {
        gfx.setColor(Color.magenta);
        gfx.drawLine(25, 25, 5000, 2000);
    }

    public void drawMonster(Graphics gfx) {
        Font font = new Font("Arial Black", 3, 50);
        gfx.setColor(Color.black);
        gfx.drawString(""+hp, 20, 10);
        gfx.setColor(Color.red);
        gfx.fillOval(10, 10, 30, 30);
    }
}
