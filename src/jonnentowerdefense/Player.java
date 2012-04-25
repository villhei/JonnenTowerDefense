/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

/**
 *
 * @author jonne
 */
public class Player {

    private int score = 0;
    private int money = 10;
    
    public Player() {
        
    }
    public void addScore(int score) {
        this.score+=score;
    }
    
    public void removeScore(int score) {
        this.score-=score;
    }
    public int getScore() {
        return this.score;
    }
    
    public void addMoney(int value) {
        this.money+=value;
    }
    
    public void removeMoney(int amount) {
        this.money-=amount;
    }
    
    public int getMoney() {
        return this.money;
    }
}
