/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.util.ArrayList;

/**
 *
 * @author jonne
 */
public class GameArea {
    
    private char[][] area;
    private AreaCell[][] gameArea;
    private Location startLocation;
    private Location finishLocation;
    private ArrayList<Location> path = new ArrayList<Location>();
    private boolean shot = false;
    
    public GameArea(char[][] area) {
        this.area = area;
        createGameArea();
        createPath();
    }

    public void createGameArea() {
        boolean buildable = false;
        boolean route = false;
        boolean start = false;
        boolean finish = false;
        boolean tower = false;

        gameArea = new AreaCell[area.length][area[0].length];
        for (int i = 0; i < gameArea.length; i++) {
            for (int j = 0; j < gameArea[0].length; j++) {
                if (area[i][j] == 'B') {
                    buildable = true;
                    route = false;
                    start = false;
                    finish = false;
                    tower = false;
                    //System.out.print("B");
                }
                if (area[i][j] == 'E') {
                    buildable = false;
                    route = true;
                    start = false;
                    finish = false;
                    tower = false;
                    //System.out.print("E");
                }
                if (area[i][j] == 'S') {
                    buildable = false;
                    route = true;
                    start = true;
                    finish = false;
                    tower = false;
                    startLocation = new Location(i, j);
                    //System.out.print("S");
                }
                if (area[i][j] == 'F') {
                    buildable = false;
                    route = true;
                    start = false;
                    finish = true;
                    tower = false;
                    finishLocation = new Location(i, j);
                    //System.out.print("F");
                }
                if(area[i][j] == 'T') {
                    buildable = false;
                    route = false;
                    start = false;
                    finish = false;
                    tower = true;
                }
                gameArea[i][j] = new AreaCell(this, buildable, route, start, finish, tower);
            }
        }
    }

    public void createPath() {
        Location current = startLocation;
        path.add(startLocation);
        boolean[][] used = new boolean[gameArea.length][gameArea[0].length];
        while (true) {
            if (current.getVerPos() + 1 < gameArea.length) {
                if (gameArea[current.getVerPos() + 1][current.getHorPos()].routeCell() && !used[current.getVerPos() + 1][current.getHorPos()]) {
                    gameArea[current.getVerPos()][current.getHorPos()].setNextCellonRoute(new Location(current.getVerPos() + 1, current.getHorPos()));
                    used[current.getVerPos()][current.getHorPos()] = true;
                    current = new Location(current.getVerPos() + 1, current.getHorPos());
                    path.add(current);
                }
            }
            if (current.getVerPos() - 1 >= 0) {
                if (gameArea[current.getVerPos() - 1][current.getHorPos()].routeCell() && !used[current.getVerPos() - 1][current.getHorPos()]) {
                    gameArea[current.getVerPos()][current.getHorPos()].setNextCellonRoute(new Location(current.getVerPos() - 1, current.getHorPos()));
                    used[current.getVerPos()][current.getHorPos()] = true;
                    current = new Location(current.getVerPos() - 1, current.getHorPos());
                    path.add(current);
                }
            }
            if (current.getHorPos() + 1 < gameArea[0].length) {
                if (gameArea[current.getVerPos()][current.getHorPos() + 1].routeCell() && !used[current.getVerPos()][current.getHorPos() + 1]) {
                    gameArea[current.getVerPos()][current.getHorPos()].setNextCellonRoute(new Location(current.getVerPos(), current.getHorPos() + 1));
                    used[current.getVerPos()][current.getHorPos()] = true;
                    current = new Location(current.getVerPos(), current.getHorPos() + 1);
                    path.add(current);
                }
            }
            if (current.getHorPos() - 1 >= 0) {
                if (gameArea[current.getVerPos()][current.getHorPos() - 1].routeCell() && !used[current.getVerPos()][current.getHorPos() - 1]) {
                    gameArea[current.getVerPos()][current.getHorPos()].setNextCellonRoute(new Location(current.getVerPos(), current.getHorPos() - 1));
                    used[current.getVerPos()][current.getHorPos()] = true;
                    current = new Location(current.getVerPos(), current.getHorPos() - 1);
                    path.add(current);
                }
            }
            if (current.getHorPos() == finishLocation.getHorPos() && current.getVerPos() == finishLocation.getVerPos()) {
                break;
            }
        }
    }
    
    
    public AreaCell[][] getArea() {
        return gameArea;
    }
    
    public boolean getShot() {
        return this.shot;
    }

    public void shoot(Location shooter, Location target) {

        gameArea[shooter.getVerPos()][shooter.getHorPos()].setShooter(shooter);
        gameArea[shooter.getVerPos()][shooter.getHorPos()].setTarget(target);
        this.shot = false;
    }
    
    public Location getFinishLocation() {
        return this.finishLocation;
    }
    
    public Location getStartLocation() {
        return this.startLocation;
    }
    
    public ArrayList<Location> getRoute() {
        return path;
    }
    public int getRouteLength() {
        return this.path.size()-1;
    }
     
    public int greatestDistance() {
        return Math.max(area.length, area[0].length);
    }
}
