

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
	boolean gameOver = false, currentGameOver = false, canTouchThis=true, endiSet=false, pendingLevelAdvance=false, aset=false;
	Base base;
	int[][] levels = {{2,5}, {3,5}, {4,6}};
	Block[][] levelBricks;
	ArrayList<Projectile> firedBricks;
	int level = -1;
	double pFLdx = 1;
	Text pendingLevelText1, pendingLevelText2;
	FramedRect pendingLevelButton;
	FilledRect pendingLevelButtonTest;
	boolean moveX=true;
	double fsw;
	Text a;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		base = new Base(c, 0, 1);
		firedBricks = new ArrayList<Projectile>();
		nextLevel();
		start();
	}
	public void reset() {
		canTouchThis = false;
		clearLevel();
		level = -1;
		nextLevel();
		scor.setScore(0);
		currentGameOver = false;
		if (endiSet) {
			endi.hide();
		}
		if (aset) {
			a.hide();
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
		Projectile t;
		if (Math.random() < .9) {
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -10, "img/projectile.png", 1, c);
			scor.addScore(-1);
		} else {
			t = new Projectile(base.getX()+(base.getWidth()/2)-12, base.getY(), 25, 25, 0, -15, "img/projectile.png", 2, c);
		}
		t.allowMovability();
		firedBricks.add(t);
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
		aset=true;
		a = new Text("You Win!", 0, 0, c);
		a.setFontSize(50);
		a.moveTo(c.getWidth()/2-a.getWidth()/2, c.getHeight()/2-a.getHeight()/2);
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= c.getWidth()-base.getWidth()) {
			base.moveTo(p.getX(), 0);
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
		pWidth = c.getHeight()/12;
		xGap = pWidth/3;
		yGap = pWidth/5+10;
		this.fsw = xGap - xGap/4;
		topX = c.getWidth()-((levels[lvl][1])*pWidth)-(((levels[lvl][1])-1)*xGap);
		topX /= 2;
		topY = 0;
		levelBricks = new Block[levels[lvl][0]][levels[lvl][1]];
		for (int i=0;i < levels[lvl][0]; i++) {
			for (int ii=0;ii < levels[lvl][1]; ii++) {
				if (ii >= 0) {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth), pWidth, pWidth);
				} else {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth, pWidth);
				}
			}
		}
		for (int i=0;i < levels[lvl][0]; i++) {
			for (int ii=0;ii < levels[lvl][1]; ii++) {
				levelBricks[i][ii].allowMovability();
			}
		}
	}
	public void clearLevel() {
		if (level != -1) {
			for (int i=0;i < levelBricks.length; i++) {
				for (int ii=0;ii < levelBricks[i].length; ii++) {
					levelBricks[i][ii].killTotally();
				}
			}
		}
	}
	public void run() {
		while (!gameOver) {
			if (!currentGameOver && !pendingLevelAdvance) {
				moveX = !moveX;
				double pFLdy = 0;
				int done=0;
				int needed=0;
				if (canTouchThis) {
					for (int i=0;i < levelBricks.length; i++) {
						needed += levelBricks[i].length;
						if (canTouchThis) {
							for (int ii=0;ii < levelBricks[i].length; ii++) {
								if (!firedBricks.isEmpty()) {
									for (int iii=0; iii < firedBricks.size(); iii++) {
										if (firedBricks.get(iii).getObj().overlaps(levelBricks[i][ii].getObj()) && firedBricks.get(iii).allowed()) {
											if (firedBricks.get(iii).getMult() == 1) {
												firedBricks.get(iii).getObj().removeFromCanvas();
												firedBricks.get(iii).disable();
												firedBricks.remove(iii);
												iii--;
											}
											levelBricks[i][ii].hit();
											scor.addScore((level+1)*2);
											switch (levelBricks[i][ii].getHits()) {
												case 0:
													levelBricks[i][ii].setImageBase("img/bricks/red/");
													break;
												case 1:
													levelBricks[i][ii].setImageBase("img/bricks/blue/");
													break;
												case 2:
													levelBricks[i][ii].setImageBase("img/bricks/green/");
													break;
												case 3:
													levelBricks[i][ii].killTotally();
													scor.addScore(level+1);
													// uDone(levelBricks[i][ii]);
													break;
											}
										} else if (firedBricks.get(iii).allowed()) {
											try {
												if (firedBricks.get(iii).getY() < 0) {
													firedBricks.get(iii).disable();
													firedBricks.get(iii).killTotally();
													firedBricks.remove(iii);
													iii--;
												}
											} catch (ArrayIndexOutOfBoundsException e) {
												System.out.println(e);
											}
										}
									}
								}
								if (levelBricks[i][ii].getHits()==3) {
									done++;
								}
							}
						}
					}
				}
				if (done == needed && canTouchThis) {
					System.out.println("this called it"+done+" "+needed);
					scor.addScore(10*(level+1));
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
	public Block makeGameBrick(double x, double y, double w, double h) {
		return new Block(x, y, w, h, 1, 0, "img/bricks/red/", 1, c);
	}
}
