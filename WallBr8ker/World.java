

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
	int[] levels = {5,5};
	Block[][] levelBricks;
	ArrayList<Projectile> firedBricks;
	int level = -1,syncCount=0,syncDelay=400,numLevels=2, speed=1;
	double pFLdx = 1, nextPRandom;
	Text pendingLevelText1, pendingLevelText2;
	FramedRect pendingLevelButton;
	FilledRect pendingLevelButtonTest;
	boolean moveX=true;
	double fsw;
	Text a;
	Slider levelSlide, numSlide;
	ResetButton reeeeeeset;
	Projectile deadProjectile;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		levelB = new ScoreBox(c, 1, new Color(255,255,255), "Level: ");
		reeeeeeset = new ResetButton(c);
		base = new Base(c, 0, 1);
		firedBricks = new ArrayList<Projectile>();
		deadProjectile = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, 0, "img/projectile.png", 1, c);
		nextPRandom=.1;
		nextLevel();
		numSlide = new Slider(10, 100, 40, 100, new int[] {1,10}, 5, new boolean[] {true, true, true, true}, new Color(0xff0000), "Number of Levels", c);
		levelSlide = new Slider(10, 250, 40, 100, new int[] {2,10}, 2, new boolean[] {true, true, true, true}, new Color(0x0000ff), "Grid Size", c);
		start();
	}
	public void reset() {
		canTouchThis = false;
		try {
			clearLevel();
		} catch(NullPointerException a) {
			//
		}
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
		if (nextPRandom < .9) {
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -10, "img/projectile.png", 1, c);
			scor.addScore(-1);
		} else {
			t = new Projectile(base.getX()+(base.getWidth()/2)-12, base.getY(), 25, 25, 0, -12, "img/projectile.png", 2, c);
		}
		t.allowMovability();
		firedBricks.add(t);
		nextPRandom = Math.random();
		if (nextPRandom < .9) {
			deadProjectile.setWidth(10);
			deadProjectile.setHeight(10);
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-5, base.getY());
		} else {
			deadProjectile.setWidth(25);
			deadProjectile.setHeight(25);
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-12, base.getY());
		}
	}
	public void nextLevel() {
		if (level+1 < numLevels && !pendingLevelAdvance) {
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
		if (deadProjectile.getWidth() == 25) {
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-12, base.getY());
		} else {
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-5, base.getY());
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
		topX = c.getWidth()-((levels[1])*pWidth)-(((levels[1])-1)*xGap);
		topX /= 2;
		topY = 0;
		levelBricks = new Block[levels[0]][levels[1]];
		for (int i=0;i < levels[0]; i++) {
			for (int ii=0;ii < levels[1]; ii++) {
				if (ii >= 0) {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth), pWidth, pWidth);
				} else {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth, pWidth);
				}
			}
		}
		for (int i=0;i < levels[0]; i++) {
			for (int ii=0;ii < levels[1]; ii++) {
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
											if (firedBricks.get(iii).getY() < 0) {
												firedBricks.get(iii).disable();
												firedBricks.get(iii).killTotally();
												firedBricks.remove(iii);
												iii--;
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
				if (canTouchThis) {
					// syncing
					// syncCount++;
					// if (syncCount == syncDelay) {
					// 	syncCount=0;
					// 	debugLine(new Exception());
					// 	for (int i=0;i<levelBricks[0].length;i++) {
					// 		boolean noGo=false;
					// 		int[] col=new int[levelBricks.length];
					// 		for (int ii=0;ii<levelBricks.length;ii++) {
					// 			col[ii]=(int)levelBricks[ii][i].getX();
					// 			System.out.println(ii+","+i);
					// 		}
					// 		System.out.println(Arrays.toString(col));
					// 		int[] numArray = col;
					// 		System.out.println(Arrays.toString(col));
					// 		// int minOfCol = medianOfIntCollection(col);
					// 		int minOfCol=0;
					// 		if (col[0] < 500) {
					// 			minOfCol = maxOfIntCollection(col);
					// 		} else if (col[0] > 700) {
					// 			minOfCol = minOfIntCollection(col);
					// 		} else {
					// 			noGo = true;
					// 		}
					// 		double[] oSets=new double[levelBricks.length];
					// 		for (int ii=0;ii<levelBricks.length;ii++) {
					// 			oSets[ii]=(levelBricks[ii][i].getX()-col[ii]);
					// 		}
					// 		double oSet=0;
					// 		for (int ii=0;ii<oSets.length;ii++) {
					// 			oSet+=oSets[ii];
					// 		}
					// 		oSet = oSet/oSets.length;
					// 		for (int ii=0;ii<levelBricks.length;ii++) {
					// 			if (levelBricks[ii][i].getX() > c.getWidth()/6 && levelBricks[ii][i].getX() < c.getWidth()*5/6 && !noGo) {
					// 				levelBricks[ii][i].move((oSet+(minOfCol-levelBricks[ii][i].getX())), 0);
					// 			}
					// 		}
					// 	}
					// }
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
		if (levelSlide.contains(p)) {
			levelSlide.drag(p);
			if (levelSlide.val()!=levels[0]) {
				levels = new int[] {levelSlide.val(), levelSlide.val()};
				try {
					clearLevel();
				} catch (NullPointerException e) {
					//
				}
				reset();
			}
		} else if (numSlide.contains(p)) {
			numSlide.drag(p);
			if (numSlide.val()!=numLevels) {
				numLevels = numSlide.val();
			}
		}
	}
	public int minOfIntCollection(int[] input) {
		int min=2147483647;
		for (int i=0;i<input.length;i++) {
			if (input[i] < min) {
				min=input[i];
			}
		}
		return min;
	}
	public int maxOfIntCollection(int[] input) {
		int max=-2147483647;
		for (int i=0;i<input.length;i++) {
			if (input[i] > max) {
				max=input[i];
			}
		}
		return max;
	}
	public Block makeGameBrick(double x, double y, double w, double h) {
		return new Block(x, y, w, h, speed, 0, "img/bricks/red/", 1, c);
	}
	public void debugLine(Exception a) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}
	public int medianOfIntCollection(int[] numArray) {	
		System.out.println(Arrays.toString(numArray));
		Arrays.sort(numArray);
		int median;
		int middle = ((numArray.length) / 2);
		if (numArray.length % 2 == 0) {
			int medianA = numArray[middle];
			int medianB = numArray[middle-1];
			median = (medianA + medianB) / 2;
		} else {
			median = numArray[middle + 1];
		}
		System.out.println(median);
		return median;
	}
}

