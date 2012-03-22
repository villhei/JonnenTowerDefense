/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

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
        }
        
        public Monster findTarget(Tower tower) {
            int ver = tower.getLocation().getVerPos();
            int hor = tower.getLocation().getHorPos();
            int distanceFromTarget = TDArea.greatestDistance();
            Monster closestMonster = null;
            
            for (int i = 0; i < monsterList.length; i++) {
                if(ver == monsterList[i].getLocation().getVerPos())
                    distanceFromTarget = 1*(hor-monsterList[i].getLocation().getHorPos());
                else if(hor == monsterList[i].getLocation().getHorPos())
                    distanceFromTarget = 1*(ver-monsterList[i].getLocation().getVerPos());
                
                if(distanceFromTarget <= tower.getRange() && distanceFromTarget < 1*(ver-closestMonster.getLocation().getVerPos()) )
                    closestMonster = monsterList[i];
            }
            return new DefaultMonster(5);
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
