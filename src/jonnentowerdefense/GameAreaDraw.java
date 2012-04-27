/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jonnentowerdefense;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author jonnaira
 */
public class GameAreaDraw extends JPanel {

	private GameArea TDArea;
	private JPanel gamearea;
	private AreaCell[][] areaArray;
	private ArrayList<Location> shooters = new ArrayList<Location>();
	private ArrayList<Location> targets = new ArrayList<Location>();
	private Location shooter;
	private Location target;
	private Image road;
	private Image grass;
	private Image towerimg;

	public GameAreaDraw(GameArea TDArea, GridLayout grid) {
		super(grid);
		this.TDArea = TDArea;
		this.setSize(600, 600);
		this.setPreferredSize(new Dimension(600, 600));
		this.setVisible(true);
		getImages();
		
		areaArray = TDArea.getArea();
		for (int i = 0; i < areaArray.length; i++) {
			for (int j = 0; j < areaArray[0].length; j++) {
                JPanel cell = new JPanel();
                this.add(cell);
			}
		}
	}


	public JPanel getAreaPanel() {
		return this.gamearea;
	}
	

	@Override
	public void paint(Graphics gfx) {
		paintCellContents(gfx);
		paintLaserLines(gfx);
	}


	private void paintCellContents(Graphics gfx) {
		for (int i = 0; i < areaArray.length; i++) {
			for (int j = 0; j < areaArray[0].length; j++) {
				checkContentsForDraw(areaArray[i][j], gfx, i, j);
			}
		}
	}

	private void paintLaserLines(Graphics gfx) {
		for (int i = 0; i < shooters.size(); i++) {
			shooter = shooters.get(i);
			target = targets.get(i);
			gfx.setColor(Color.red);
			gfx.drawLine(shooter.getVerPos()*50+25, shooter.getHorPos()*50+25, target.getHorPos()*50+25, target.getVerPos()*50+25);
			gfx.setColor(Color.yellow);
			gfx.drawLine(shooter.getVerPos()*50+26, shooter.getHorPos()*50+25, target.getHorPos()*50+26, target.getVerPos()*50+25);
			gfx.setColor(Color.red);
			gfx.drawLine(shooter.getVerPos()*50+27, shooter.getHorPos()*50+25, target.getHorPos()*50+27, target.getVerPos()*50+25);
		}
		shooters.clear();
		targets.clear();
	}

	public void checkContentsForDraw(AreaCell areacell, Graphics gfx, int i, int j) {
		if (areacell.routeCell()) {
			if (areacell.hasMonsters()) {
				drawMonster(areacell, gfx, i, j);
				this.drawRoad(gfx, i, j);
			} else {
				this.drawRoad(gfx, i, j);
			}
			if (areacell.isStart()) {
				this.drawStart(gfx, i, j);
			}
			if (areacell.isFinish()) {
				this.drawFinish(gfx, i, j);
			}

		}
		if (areacell.hasMonsters()) {
			this.drawMonster(areacell, gfx, i, j);
		}
		if (areacell.buildCell() && !areacell.hasTower()) {
			this.drawBuild(gfx, i, j);
		} else if (areacell.hasTower()) {
			this.drawBuild(gfx, i, j);
			this.drawTower(gfx, i, j);
		}
		if (areacell.getShooter() != null && areacell.getTarget() != null) {
			shooters.add(areacell.getShooter());
			targets.add(areacell.getTarget());
		}
	}


	public void drawStart(Graphics gfx, int i, int j) {
		Font font = new Font("Arial Black", 1, 30);
		//gfx.setColor(Color.gray);
		//gfx.fillRect(0, 0, 50, 50);
		gfx.drawImage(road, (j*50), (i*50), this);
		gfx.setFont(font);
		gfx.setColor(Color.BLUE);
		gfx.drawString("S", 15+(i*50)+50, (i*50)+35);
	}

	public void drawFinish(Graphics gfx, int i, int j) {
		Font font = new Font("Arial Black", 1, 30);
		//gfx.setColor(Color.gray);
		//gfx.fillRect(0, 0, 50, 50);
		gfx.drawImage(road, (j*50), (i*50), this);
		gfx.setFont(font);
		gfx.setColor(Color.RED);
		gfx.drawString("F", (j*50)+15, (i*50)+35);
	}

	public void drawRoad(Graphics gfx, int i, int j) {
		//gfx.setColor(Color.gray);
		//gfx.fillRect(0, 0, 50, 50);
		gfx.drawImage(road, (j*50), (i*50), this);
	}

	public void drawBuild(Graphics gfx, int i, int j) {
		//gfx.setColor(Color.green);
		//gfx.fillRect(0, 0, 50, 50);
		gfx.drawImage(grass, (j*50), (i*50), this);
	}

	public void drawTower(Graphics gfx, int i, int j) {
		//gfx.setColor(Color.black);
		//gfx.fillRect(10, 10, 30, 30);
		gfx.drawImage(towerimg, (j*50), (i*50), this);
	}

	public void drawMonster(AreaCell areacell, Graphics gfx, int i, int j) {
		Font font = new Font("Arial Black", 4, 15);
		gfx.setFont(font);
		gfx.setColor(Color.red);
		gfx.fillOval(10+(j*50), 10+(i*50), 30, 30);
		gfx.setColor(Color.green);
		gfx.drawString("" + areacell.getHP(), 20+(j*50), 30+(i*50));

	}

	public void getImages() {

		try {
			File srcimg = new File("road.png");
			road = ImageIO.read(srcimg);

			srcimg = new File("grass.png");
			grass = ImageIO.read(srcimg);

			srcimg = new File("tower.png");
			towerimg = ImageIO.read(srcimg);
		} catch (IOException e) {
			System.out.println("Kuvaa ei ladattu.");
		}

	}
}
