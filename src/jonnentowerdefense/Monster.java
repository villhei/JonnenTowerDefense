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
    
    public int getValue();
    
    public int getRouteIndex();
    
    public void increaseRouteIndex();
    
    public void setLocation(int x, int y);
    
    public void setLocation(Location location);
    
    public Location getLocation();    
}
