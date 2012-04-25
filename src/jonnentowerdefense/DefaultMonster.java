/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public class DefaultMonster implements Monster {
    
    private int routeIndex = 0;
    private int health;
    private int value;
    private Location location;
    public DefaultMonster(int health) {
        this.health = health;
    }
    
    public int reduceHealth(int damage) {
        this.health -= damage;
        return this.health;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void die() {
        
    }
    
    public int getValue() {
        return this.value;
    }
    
    public int getRouteIndex() {
        return this.routeIndex;
    }
    
    public void increaseRouteIndex() {
        this.routeIndex+=1;
    }
    
    public void setLocation(int x, int y) {
        this.location = new Location(x,y);
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }
    
    public void moveMonster() {
        
    }
}
