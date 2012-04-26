/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */

public class DefaultTower implements Tower {
    
    private int range;
    private Location location;
    private int atkSpeed;
    private int damage;
    
    public DefaultTower(int range, int damage, int atkSpeed, Location location) {
        this.range = range;
        this.damage = damage;
        this.atkSpeed = atkSpeed;
        this.location = location;
    }
    
    public int getRange() {
        return this.range;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public int getAtkSpeed() {
        return this.atkSpeed;
    }
    
    public void shoot(Monster target) {
        if(target != null) {
            doDamage(target, this.damage);
        }
    }
    
    public void doDamage(Monster target, int damage) {
        target.reduceHealth(damage);
        if(target.getHealth() < 1)
            target.die();
    }
    
//    public Monster findTarget() {
//        int distanceFromTarget;
//        
//        Monster[] monsterList = TDGame.getMonsterList();
//        for (int i = 0; i < .length; i++) {
//            
//        }
//            if(this.location.getHorPos() == )
//                distanceFromTarget = 
//        
//        return null;
//    }

    public void setLocation(int x, int y) {
        this.location = new Location(x,y);
    }
    
    public Location getLocation() {
        return this.location;
    }
}
