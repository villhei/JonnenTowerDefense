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
    
    
    private int health;
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
    
    public Location getLocation() {
        return new Location(0,0);
    }
    
    public void moveMonster() {
        
    }
}
