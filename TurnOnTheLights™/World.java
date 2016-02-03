

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class World extends ActiveObject {
	ScoreBox scor, levelB;
	DrawingCanvas c;
	boolean gameOver = false;
	Paddle pladdle;
	int[][] levels = {{3,3},{1,5},{2,3},{2,5}};
	Spud potatoesForLevel[][], firedSpud;
	int level = 0;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		pladdle = new Paddle(c, 0, 1);
		drawLevel(level);
		firedSpud = new Spud(0, c.getHeight(), c.getWidth()/25, c.getWidth()/25, 0, -8, "img/moon/0/0.png", 1, c);
		start();
	}
	public void reset() {
		level = 0;
		clearLevel();
		scor.setScore(0);
		levelB.setScore(0);
		gameOver = true;
		pause(2);
		gameOver = false;
		drawLevel(level);
		start();
	}
	public void onMouseClick(Location p) {
		if (reeeeeeset.testClick(p)) {
			reset();
		} else {
			fire();
		}
	}
	public void fire() {
		firedSpud.moveTo(pladdle.getX()+(pladdle.getWidth()/2)-(c.getWidth()/50), c.getHeight()-(pladdle.getHeight()/2)-(c.getWidth()/25));
		firedSpud.setMove(0, -8);
		firedSpud.allowMovability();
	}
	public void nextLevel() {
		if (level+1 < levels.length) {
			clearLevel();
			level++;
			System.out.println(level);
			drawLevel(level);
		} else {
			clearLevel();
			gameOver = true;
			youWin();
		}
	}
	public void youWin() {
		System.out.println("YOU WIN");
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= c.getWidth()-pladdle.getWidth()) {
			pladdle.moveTo(p.getX(), 0);
		}
	}
	public void drawLevel(int lvl) {
		double topX;
		double topY;
		double xGap;
		double yGap;
		double pWidth;
		levelB.setScore(lvl+1);
		// lets do the math
		pWidth = c.getHeight()/6;
		xGap = pWidth/3;
		yGap = pWidth/2.5;
		topX = c.getWidth()-((levels[lvl][1])*pWidth)-(((levels[lvl][1])-1)*xGap);
		topX /= 2;
		topY = c.getHeight()-((levels[lvl][0])*pWidth)-(((levels[lvl][0])-1)*yGap);
		topY /= 2;
		potatoesForLevel = new Spud[levels[lvl][0]][levels[lvl][1]];
		for (int i=0;i < potatoesForLevel.length; i++) {
			for (int ii=0;ii < potatoesForLevel[i].length; ii++) {
				if (ii >= 0) {
					potatoesForLevel[i][ii] = makeGameSpud(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth)+((i-1)*yGap), pWidth);
				} else {
					potatoesForLevel[i][ii] = makeGameSpud(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth);
				}
			}
		}
	}
	public void clearLevel() {
		for (int i=0;i < potatoesForLevel.length; i++) {
			for (int ii=0;ii < potatoesForLevel[i].length; ii++) {
				potatoesForLevel[i][ii].killGamePotato();
			}
		}
	}
	public void run() {
		while (!gameOver) {
			//insert stuff here
			pause(1);
		}
	}
	public void onMouseEnter(Location p) {
	}
	public void onMouseExit(Location p) {
	}
	public void onMousePress(Location p) {
	}
	public void onMouseDrag(Location p) {
	}
	public Spud makeGameSpud(double x, double y, double wh) {
		return new Spud(x, y, wh, wh, 0, new RandomIntGenerator(-10,-4).nextValue(), "img/moon/0/0.png", 1, c);
	}
}