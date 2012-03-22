/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public class Location {
    
    private int ver;
    private int hor;
    
    public Location(int ver, int hor) {
        this.ver = ver;
        this.hor = hor;
        
    }
    
    public int getVerPos() {
        return this.ver;
    }
   
    public int getHorPos() {
        return this.hor;
    }
}
