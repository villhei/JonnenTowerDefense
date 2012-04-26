/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author jonne
 */
public class AreaCell  {

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
	
	public int getHP()
	{
		return this.hp;
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

}
