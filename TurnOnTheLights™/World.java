

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
	boolean gameOver = false, currentGameOver = false, canTouchThis=true, endiSet=false, pendingLevelAdvance=false;
	Paddle pladdle;
	// int[][] levels = {{1,1},{1,3},{1,5},{2,1},{2,2},{3,1},{3,2}};
	int[][] levels = {{1,1}, {1,3}};
	Spud potatoesForLevel[][], firedSpud;
	int level = -1;
	double pFLdx = 1;
	Text pendingLevelText1, pendingLevelText2;
	FramedRect pendingLevelButton;
	FilledRect pendingLevelButtonTest;
	boolean moveX=true;
	double fsw;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		pladdle = new Paddle(c, 0, 1);
		firedSpud = new Spud(0, c.getHeight(), c.getWidth()/61.904761905, c.getWidth()/61.904761905*6.2698412698, 0, -20, "img/rocket.png", 1, c);
		nextLevel();
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
		} else if (pendingLevelAdvance) {
			if (pendingLevelButtonTest.contains(p)) {
				nextLevel();
			}
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
		new Particles(killed.getX()+killed.getWidth()/2, killed.getY()+killed.getHeight()/2, 10, 0, 0, 16, 1, 50, 500, 100, new int[] {0}, new Color[] {new Color(0xff0000), new Color(0xff1221)}, c);
		reeeeeeset.front();
	}
	public void nextLevel() {
		if (level+1 < levels.length && !pendingLevelAdvance) {
			pendingLevelAdvance=true;
			clearLevel();
			level++;
			levelB.setScore(level+1);
			pendingLevelText1 = new Text("Level "+(level+1), 0, c.getHeight()/2.5-(c.getHeight()/12), c);
			pendingLevelText1.setFontSize(c.getHeight()/12);
			pendingLevelText1.move(c.getWidth()/2-pendingLevelText1.getWidth()/2, 0);
			pendingLevelText2 = new Text("Go", 0, ((c.getHeight()/5)*3)-(c.getHeight()/12), c);
			pendingLevelText2.setFontSize(c.getHeight()/12);
			pendingLevelText2.move(c.getWidth()/2-pendingLevelText2.getWidth()/2, 0);
			pendingLevelButton = new FramedRect(pendingLevelText2.getX()-10, pendingLevelText2.getY()-10, pendingLevelText2.getWidth()+20, pendingLevelText2.getHeight()+20, c);
			pendingLevelButtonTest = new FilledRect(pendingLevelText2.getX()-10, pendingLevelText2.getY()-10, pendingLevelText2.getWidth()+20, pendingLevelText2.getHeight()+20, c);
			pendingLevelButtonTest.setColor(new Color(0xffffff));
			pendingLevelButtonTest.sendToBack();
		} else if (pendingLevelAdvance) {
			pendingLevelButton.removeFromCanvas();
			pendingLevelText1.removeFromCanvas();
			pendingLevelText2.removeFromCanvas();
			pendingLevelButton = null;
			pendingLevelText1 = null;
			pendingLevelText2 = null;
			drawLevel(level);
			pendingLevelAdvance = false;
		} else {
			currentGameOver = true;
			youWin();
		}
	}
	public void youWin() {
		System.out.println("YOU WIN!");
		int total = 0;
		for (int i=0;i<potatoesForLevel.length;i++) {
			for (int ii=0;ii<potatoesForLevel[i].length;ii++) {
				total++;
			}
		}
		for (int i=0;i<total;i++) {
			int[] a = {new RandomIntGenerator(0, potatoesForLevel.length-1).nextValue(), new RandomIntGenerator(0, potatoesForLevel[0].length-1).nextValue()};
			if (!potatoesForLevel[a[0]][a[1]].effectDone()) {
				while (potatoesForLevel[a[0]][a[1]].getY()+potatoesForLevel[a[0]][a[1]].getHeight() <= c.getHeight()) {
					potatoesForLevel[a[0]][a[1]].move(0, 3);
					pause(2);
				}
				potatoesForLevel[a[0]][a[1]].getOut();
				new Particles(potatoesForLevel[a[0]][a[1]].getX()+potatoesForLevel[a[0]][a[1]].getWidth()/2-c.getHeight()/192, potatoesForLevel[a[0]][a[1]].getY()+potatoesForLevel[a[0]][a[1]].getHeight()/2-c.getHeight()/192, c.getHeight()/24, 0, 0, 18, 1, 200, 0, 0, new int[] {0}, new Color[] {new Color(0x4a984b), new Color(0x54a953), new Color(0x5ab75a), new Color(0x5fc05f), new Color(0x64cb64)}, c);
				potatoesForLevel[a[0]][a[1]].effectIsDone();
			} else {
				i-=1;
			}
		}
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
		if (level != -1) {
			for (int i=0;i < potatoesForLevel.length; i++) {
				for (int ii=0;ii < potatoesForLevel[i].length; ii++) {
					potatoesForLevel[i][ii].killGamePotato();
				}
			}
		}
	}
	public void run() {
		while (!gameOver) {
			if (!currentGameOver && !pendingLevelAdvance) {
				moveX = !moveX;
				double pFLdy = 0;
				if (canTouchThis && !pendingLevelAdvance) {
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