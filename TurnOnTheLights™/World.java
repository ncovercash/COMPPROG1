

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
	Spud potatosForLevel[][];
	int level = 0;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		pladdle = new Paddle(c, 0, 1);
		drawLevel(level);
		start();
	}
	public void reset() {
		//
	}
	public void onMouseClick(Location p) {
		if (reeeeeeset.testClick(p)) {
			reset();
		} else {
		}
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
		// lets do the math
		pWidth = c.getHeight()/6;
		xGap = pWidth/3;
		yGap = pWidth/2.5;
		topX = c.getWidth()-((levels[lvl][1])*pWidth)-(((levels[lvl][1])-1)*xGap);
		topX /= 2;
		topY = c.getHeight()-((levels[lvl][0])*pWidth)-(((levels[lvl][0])-1)*yGap);
		topY /= 2;
		potatosForLevel = new Spud[levels[lvl][0]][levels[lvl][1]];
		for (int i=0;i < potatosForLevel.length; i++) {
			for (int ii=0;ii < potatosForLevel[i].length; ii++) {
				if (ii >= 1) {
					potatosForLevel[i][ii] = makeGameSpud(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth)+((i-1)*yGap), pWidth);
				} else {
					potatosForLevel[i][ii] = makeGameSpud(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth);
				}
			}
		}
		potatosForLevel[0][0] = makeGameSpud(topX, topY, pWidth);
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