/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author jonne
 */


public class Game {
    
    
        /**
         * B = buildable, E = empty, S = start, F = finish.
         */
        private static char[][] area = {{'B', 'B', 'S', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'F', 'B', 'B'}};
        
        GameArea TDArea;
        ArrayList<Monster> monsterList = new ArrayList<Monster>();
        ArrayList<Tower> towerList = new ArrayList<Tower>();
        
        public Game() {
            this.initiate();
        }
        
        public void initiate() {
            //TDArea = new GameArea(area);
            GameWindow main = new GameWindow(this);
        }
        
        public void GameLoop() {
            while(true) {
                
            }
        }
        
        public void moveMonsters() {
            
        }
        
        public void shootMonsters() {
            for (Tower tmpTower : towerList) {
                findTarget(tmpTower);
            }
        }
        
        public Monster findTarget(Tower tower) {
            
            Monster closestMonster = null;
            
            for (Monster tmpMonster : monsterList) {
                //tmpMonster = monsterList.get(i);
                if(isInRange(tmpMonster, tower)) {
                    closestMonster = tmpMonster;
                    break;
                }
            }
            
            return closestMonster;
        }
        
        public boolean isInRange(Monster toBeChecked, Tower tower) {
            boolean inRange = false;
            int verTower = tower.getLocation().getVerPos();
            int horTower = tower.getLocation().getHorPos();
            int verMonster = toBeChecked.getLocation().getVerPos();
            int horMonster = toBeChecked.getLocation().getHorPos();
            int distanceFromMonster;
            
            //Lasketaan tornin ja monsterin etäisyys janan pituuden kaavalla.
            distanceFromMonster = (int)Math.sqrt(Math.pow(horMonster-horTower,2)+Math.pow(verMonster-verTower, 2));
            
            if(distanceFromMonster <= tower.getRange())
                return true;
            else
                return false;
        }
        
        public GameArea getGameArea() {
            return this.TDArea;
        }
        
        public ArrayList<Monster> getMonsterList() {
            return this.monsterList;
        }
        
        public ArrayList<Tower> getTowerList() {
            return this.towerList;
        }
}
