

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class World extends ActiveObject {
	VisibleImage endi;
	ScoreBox scor, levelB;
	DrawingCanvas c;
	boolean gameOver = false, currentGameOver = false, canTouchThis=true, endiSet=false;
	Paddle pladdle;
	int[][] levels = {{1,6},{1,3},{1,5},{2,1},{2,2},{3,1},{3,2}};
	Spud potatoesForLevel[][], firedSpud;
	int level = 0;
	double pFLdx = 1;
	boolean moveX=true;
	double fsw;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		pladdle = new Paddle(c, 0, 1);
		drawLevel(level);
		firedSpud = new Spud(0, c.getHeight(), c.getWidth()/61.904761905, c.getWidth()/61.904761905*6.2698412698, 0, -20, "img/rocket.png", 1, c);
		start();
	}
	public void reset() {
		canTouchThis = false;
		level = -1;
		nextLevel();
		// clearLevel();
		scor.setScore(0);
		currentGameOver = false;
		//drawLevel(level);
		if (endiSet) {
			endi.hide();
		}
		canTouchThis = true;
	}
	public void onMouseClick(Location p) {
		if (reeeeeeset.testClick(p)) {
			reset();
		} else {
			if (!currentGameOver) {
				fire();
			}
		}
	}
	public void fire() {
		firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight()); // 2 is for spacing
		firedSpud.setMove(0, -20);
		firedSpud.setImg("img/rocket.png");
		firedSpud.allowMovability();
	}
	public void uDone(Spud killed) {
		currentGameOver = true;
		try {
			endi = new VisibleImage(ImageIO.read(new File("img/memeEnd.jpg")), 0, 0, c.getWidth(), c.getHeight(), c);
			endiSet = true;
		} catch (IOException e) {
			System.out.println(e);
		}
		endi.sendToBack();
		new Particles(killed.getX()+killed.getWidth()/2, killed.getY()+killed.getHeight()/2, 10, 0, 0, 32, 4, 25, 100, 100, new int[] {0}, new Color[] {new Color(0xff0000), new Color(0xff1221)}, c);
		reeeeeeset.front();
	}
	public void nextLevel() {
		if (level+1 < levels.length) {
			clearLevel();
			level++;
			drawLevel(level);
			levelB.setScore(level+1);
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
			if (!firedSpud.canMove()) {
				firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
				firedSpud.setImg("img/rocket.png");
			}
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
		this.fsw = xGap - xGap/4;
		topX = c.getWidth()-((levels[lvl][1])*pWidth)-(((levels[lvl][1])-1)*xGap);
		topX /= 2;
		// topY = c.getHeight()-((levels[lvl][0])*pWidth)-(((levels[lvl][0])-1)*yGap);
		// topY /= 2;
		topY = 0;
		potatoesForLevel = new Spud[levels[lvl][0]][levels[lvl][1]];
		for (int i=0;i < potatoesForLevel.length; i++) {
			for (int ii=0;ii < potatoesForLevel[i].length; ii++) {
				if (ii >= 0) {
					potatoesForLevel[i][ii] = makeGameSpud(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth), pWidth);
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
			if (!currentGameOver) {
				moveX = !moveX;
				double pFLdy = 0;
				if (canTouchThis) {
					if (potatoesForLevel[0][0].getX() <= 0 || potatoesForLevel[0][potatoesForLevel[0].length-1].getX()+potatoesForLevel[0][potatoesForLevel[0].length-1].getWidth() >= c.getWidth()) {
						pFLdx = -pFLdx;
						pFLdy = fsw/4;
					}
				}
				if (canTouchThis) {
					if (potatoesForLevel[potatoesForLevel.length-1][0].getY()+potatoesForLevel[potatoesForLevel.length-1][0].getHeight() > c.getHeight()) {
						uDone(potatoesForLevel[potatoesForLevel.length-1][0]);
					}
				}
				if (firedSpud.getX() <= 0 || firedSpud.getX() + firedSpud.getWidth() >= c.getWidth()) {
					firedSpud.reverseX();
				}
				if (firedSpud.getY() < 0) {
					firedSpud.reverseY();
					if (firedSpud.getXChange() == 0) {
						firedSpud.newXChange();
					}
					firedSpud.setImg("img/rocket2.png");
				}
				if (firedSpud.getY() > c.getHeight()) {
					firedSpud.disallowMovability();
					firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
					firedSpud.setImg("img/rocket.png");
				}
				int done=0;
				int needed=0;
				if (canTouchThis) {
					for (int i=0;i < potatoesForLevel.length; i++) {
					    needed += potatoesForLevel[i].length;
					    if (canTouchThis) {
							for (int ii=0;ii < potatoesForLevel[i].length; ii++) {
								if (moveX) {
									potatoesForLevel[i][ii].move(pFLdx, pFLdy);
								}
								if (pFLdy != 0) {
									potatoesForLevel[i][ii].move(2*pFLdx, 3);
								}
								if (firedSpud.getObj().overlaps(potatoesForLevel[i][ii].getObj())) {
									firedSpud.disallowMovability();
									firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
									firedSpud.setImg("img/rocket.png");
									potatoesForLevel[i][ii].hit();
									scor.addScore(level+1);
									switch (potatoesForLevel[i][ii].getHits()) {
										case 0:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											break;
										case 1:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											potatoesForLevel[i][ii].shrink(10);
											break;
										case 2:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											potatoesForLevel[i][ii].shrink(20);
											break;
										case 3:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											potatoesForLevel[i][ii].shrink(30);
											break;
										case 4:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											potatoesForLevel[i][ii].shrink(40);
											break;
										case 5:
											potatoesForLevel[i][ii].setImg("img/moon/"+potatoesForLevel[i][ii].getHits()+"/0.png");
											potatoesForLevel[i][ii].shrink(50);
											uDone(potatoesForLevel[i][ii]);
											break;
									}
								}
								if (potatoesForLevel[i][ii].getHits()==4) {
									done++;
								}
							}
						}
					}
				}
				if (done == needed && canTouchThis) {
					nextLevel();
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
	public Spud makeGameSpud(double x, double y, double wh) {
		return new Spud(x, y, wh, wh, 0, new RandomIntGenerator(-10,-4).nextValue(), "img/moon/0/0.png", 1, c);
	}
}