

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class World extends ActiveObject {
	DrawingCanvas c;
	Paddle padleet;
	ScoreBox scor;
	ResetButton reeeeeeset;
	Spud[] spudatoes;
	boolean gameOver = false;
	int activeUnreleasedSpud = 0;
	public World(DrawingCanvas c) {
		this.c = c;
		spudatoes = new Spud[] {
			makeSpud(0),
			makeSpud(1),
			makeSpud(2),
			makeSpud(3),
			makeSpud(4)
		};
		padleet = new Paddle(c);
		scor = new ScoreBox(c, 0, new Color(0xff00ff), "Score: ");
		reeeeeeset = new ResetButton(c);
		start();
	}
	public void onMouseClick(Location p) {
		if (reeeeeeset.testClick(p)) {
			scor.setScore(0);
			spudatoes = new Spud[] {
				makeSpud(0),
				makeSpud(1),
				makeSpud(2),
				makeSpud(3),
				makeSpud(4)
			};
			activeUnreleasedSpud = 0;
		} else {
			if (activeUnreleasedSpud < spudatoes.length) {
				spudatoes[activeUnreleasedSpud].allowMovability();
				activeUnreleasedSpud++;
			}
		}
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= c.getWidth()-padleet.getWidth()) {
			padleet.moveTo(p.getX(), 0);
		}
	}
	public void run() {
		while (!gameOver) {
			for (int i = 0; i < spudatoes.length; i++) {
				if (!spudatoes[i].isDead()) {
					if (padleet.getBaseObj().overlaps(spudatoes[i].getObj())) {
						if (spudatoes[i].getScoreToAdd() == "double") {
							scor.addScore(scor.getScore());
						} else {
							scor.addScore(Integer.parseInt(spudatoes[i].getScoreToAdd()));
						}
						spudatoes[i].reverseY();
					}
					if (spudatoes[i].getX() <= 0 || spudatoes[i].getX() + spudatoes[i].getWidth() >= c.getWidth()) {
						spudatoes[i].reverseX();
					}
					if (spudatoes[i].getY() < 0) {
						spudatoes[i].reverseY();
					}
					if (spudatoes[i].getY() > c.getHeight()) {
						spudatoes[i].killPotato(i);
					}
				}
			}
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
	public Spud makeSpud(int pos) {
		switch (new RandomIntGenerator(1,10).nextValue()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				return new Spud("potatoBlue.png", 1, c, pos);
			case 7:
			case 8:
			case 9:
				return new Spud("potatoGreen.png", 2, c, pos);
			case 10:
				return new Spud("potatoRed.png", 3, c, pos);
			default: return new Spud("", 1, c, -1);
		}
	}
}