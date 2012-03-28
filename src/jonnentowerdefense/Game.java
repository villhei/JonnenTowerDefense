/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.awt.event.*;
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
        Monster[] monsterList;
        Tower[] towerList;
        
        public Game() {
            this.init();
        }
        
        public void init() {
            TDArea = new GameArea(area);
            monsterList = new Monster[5];
            towerList = new Tower[5];
            GameWindow main = new GameWindow(this);
        }
        
        public void GameLoop() {
            while(true) {
                
            }
        }
        
        public Monster findTarget(Tower tower) {
            
            Monster closestMonster = null;
            
            for (int i = 0; i < monsterList.length; i++) {
                Monster tmpMonster = monsterList[i];
                if(isInRange(tmpMonster, tower))
                    closestMonster = tmpMonster;
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
        
        public Monster[] getMonsterList() {
            return this.monsterList;
        }
        
        public Tower[] getTowerList() {
            return this.towerList;
        }
}
