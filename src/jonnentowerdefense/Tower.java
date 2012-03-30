/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public interface Tower {
    
    public void shoot(Monster target);
    
    public void doDamage(Monster target, int damage);
    
    public int getRange();
    
    public int getDamage();
    
    public int getAtkSpeed();
    
    public void setLocation(int x, int y);
    
    public Location getLocation();
    
}
