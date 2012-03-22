/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public interface Monster {
    
    public int reduceHealth(int damage);
    
    public int getHealth();
    
    public void moveMonster();
    
    public void die();
    
    public Location getLocation();    
}
