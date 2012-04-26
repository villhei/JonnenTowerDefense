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


public class Game extends Thread {
    
    
        /**
         * B = buildable, E = empty, S = start, F = finish.
         */
        private static char[][] area = {{'B', 'B', 'S', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'E', 'B', 'B'},
                                        {'B', 'B', 'F', 'B', 'B'}};
        
        GameArea TDArea;
        GameWindow main;
        ArrayList<Monster> monsterList = new ArrayList<Monster>();
        ArrayList<Tower> towerList = new ArrayList<Tower>();
        ArrayList<Location> path;
        Location startLocation;
        Location finishLocation;
        Player player;
        int numberOfMonsters;
        int killedMonsters = 0;
        
        
        public Game() throws InterruptedException {
            this.initiate();
        }
        
        public void initiate() throws InterruptedException {
            //TDArea = new GameArea(area);
            main = new GameWindow(this);
            player = new Player();
            TDArea = main.getGameArea();
            path = TDArea.getRoute();
            startLocation = TDArea.getStartLocation();
            finishLocation = TDArea.getFinishLocation();
            for (int i = 0; i < path.size(); i++) {
                System.out.print("hor:"+path.get(i).getHorPos() + " ver:"+ path.get(i).getVerPos()+"||");
            }
            System.out.println("");
            GameLoop();
        }
        
        public void GameLoop() throws InterruptedException {
            
            numberOfMonsters = 10;
            int index = 0;
            while(true) {
                index+=1;
                System.out.println(index);
                if(index <= 10) {
                    addMonster();
                    //numberOfMonsters-=1;
                }
                main.repaint();
                Thread.sleep(50);
                moveMonsters();
                main.repaint();
                Thread.sleep(50);
                //shootMonsters();
                main.repaint();
                Thread.sleep(50);
                checkMonsters();
                main.repaint();
                Thread.sleep(50);
                if(killedMonsters == numberOfMonsters) {
                    System.out.println("WAVE CLEARED");
                    Thread.sleep(500);
                    break;
                }
            }
        }
        
        public void addMonster() {
            Monster tmp = new DefaultMonster(5);
            tmp.setLocation(startLocation);
            TDArea.getArea()[startLocation.getVerPos()][startLocation.getHorPos()].putMonster();
            monsterList.add(tmp);
        }
        
        public void moveMonsters() {
            for (Monster tmpMonster : monsterList) {
                System.out.println("hor:"+tmpMonster.getLocation().getHorPos() + " ver:" + tmpMonster.getLocation().getVerPos());
                TDArea.getArea()[tmpMonster.getLocation().getVerPos()][tmpMonster.getLocation().getHorPos()].remMonster();
                tmpMonster.increaseRouteIndex();
                int routeIndex = tmpMonster.getRouteIndex();
                tmpMonster.setLocation(path.get(routeIndex));
                TDArea.getArea()[tmpMonster.getLocation().getVerPos()][tmpMonster.getLocation().getHorPos()].putMonster();
            }
        }
        
        public void shootMonsters() {
            for (Tower tmpTower : towerList) {
                Monster target = findTarget(tmpTower);
                tmpTower.shoot(target);
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
        
        public void checkMonsters() {
            System.out.println("checkmonsters, monstereita:" + monsterList.size());
            for (int i = 0; i < monsterList.size(); i++) {
                Monster tmpMonster = monsterList.get(i);
                if(tmpMonster.getHealth() <= 0) {
                    tmpMonster.die();
                    monsterList.remove(i);
                    player.addScore(tmpMonster.getValue());
                    player.addMoney(tmpMonster.getValue());
                    System.out.println("kuolin koska kuolin");
                    killedMonsters+=1;
                    continue;
                }
                if(tmpMonster.getRouteIndex() >= TDArea.getRouteLength()) {
                    tmpMonster.die();
                    monsterList.remove(i);
                    player.removeScore(tmpMonster.getValue());
                    System.out.println("kuolin koska maali");
                    killedMonsters+=1;
                }
            }
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
