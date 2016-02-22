

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
	int[][] levels = {{2,5}, {3,5}};
	ArrayList<ObjectThingy> firedBricks, levelBricks;
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
		firedBricks = new ArrayList<ObjectThingy>();
		levelBricks = new ArrayList<ObjectThingy>();
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
		// firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight()); // 2 is for spacing
		// firedSpud.setMove(0, -20);
		// firedSpud.setImg("img/fired.png");
		// firedSpud.allowMovability();
	}
	public void uDone(ObjectThingy killed) {
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
		for (int i=0;i<levelBricks.size();i++) {
			for (int ii=0;ii<levelBricks.get(i).size();ii++) {
				total++;
			}
		}
		for (int i=0;i<total;i++) {
			int[] a = {new RandomIntGenerator(0, levelBricks.size()-1).nextValue(), new RandomIntGenerator(0, levelBricks.get(0).size()-1).nextValue()};
			if (!levelBricks.get(a[0]).get(a[1]).effectDone()) {
				while (levelBricks.get(a[0]).get(a[1]).getY()+levelBricks.get(a[0]).get(a[1]).getHeight() <= c.getHeight()) {
					levelBricks.get(a[0]).get(a[1]).move(0, 3);
					pause(2);
				}
				levelBricks.get(a[0]).get(a[1]).getOut();
				new Particles(levelBricks.get(a[0]).get(a[1]).getX()+levelBricks.get(a[0]).get(a[1]).getWidth()/2-c.getHeight()/192, levelBricks.get(a[0]).get(a[1]).getY()+levelBricks.get(a[0]).get(a[1]).getHeight()/2-c.getHeight()/192, c.getHeight()/24, 0, 0, 18, 1, 200, 0, 0, new int[] {0}, new Color[] {new Color(0x4a984b), new Color(0x54a953), new Color(0x5ab75a), new Color(0x5fc05f), new Color(0x64cb64)}, c);
				levelBricks.get(a[0]).get(a[1]).effectIsDone();
			} else {
				i-=1;
			}
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
		levelBricks.clear();
		for (int i=0;i < levels[lvl][0]]; i++) {
			levelBricks.add(new ArrayList<ObjectThingy>());
			for (int ii=0;ii < levels[lvl][1]; ii++) {
				if (ii >= 0) {
					levelBricks.get(i).add(makeGameBrick(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth), pWidth));
				} else {
					levelBricks.get(i).add(makeGameBrick(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth));
				}
			}
		}
	}
	public void clearLevel() {
		if (level != -1) {
			for (int i=0;i < levelBricks.size(); i++) {
				for (int ii=0;ii < levelBricks.get(i).size(); ii++) {
					levelBricks.get(i).get(i).killTotally();
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
					if (levelBricks.get(0).get(0).getX() <= 0 || levelBricks.get(0).get(levelBricks.get(0).size()-1).getX()+levelBricks.get(0).get(levelBricks.get(0).size()-1).getWidth() >= c.getWidth()) {
						pFLdx = -pFLdx;
						pFLdy = fsw/4;
					}
				}
				if (canTouchThis) {
					if (levelBricks.get(levelBricks.size()-1).get(0).getY()+levelBricks.get(levelBricks.size()-1).get(0).getHeight() > c.getHeight()) {
						uDone(levelBricks.get(levelBricks.size()-1).get(0);
					}
				}
				// if (firedSpud.getY() < 0) {
				// 	firedSpud.moveTo(-1000, -1000);
				// 	firedSpud.disallowMovability();
				// }
				// if (firedSpud.getY() > c.getHeight()) {
				// 	firedSpud.disallowMovability();
				// 	firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
				// 	firedSpud.setImg("img/fired.png");
				// }
				int done=0;
				int needed=0;
				if (canTouchThis) {
					for (int i=0;i < levelBricks.size(); i++) {
						needed += levelBricks[i].length;
						if (canTouchThis) {
							for (int ii=0;ii < levelBricks[i].length; ii++) {
								if (moveX) {
									levelBricks[i][ii].move(pFLdx, pFLdy);
								}
								if (pFLdy != 0) {
									levelBricks[i][ii].move(2*pFLdx, 3);
								}
								/*if (firedSpud.getObj().overlaps(levelBricks[i][ii].getObj())) {
									// firedSpud.disallowMovability();
									// firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
									// firedSpud.setImg("img/fired.png");
									levelBricks[i][ii].hit();
									scor.addScore(level+1);
									switch (levelBricks[i][ii].getHits()) {
										case 0:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											break;
										case 1:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											levelBricks[i][ii].shrink(10);
											break;
										case 2:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											levelBricks[i][ii].shrink(20);
											break;
										case 3:
											levelBricks[i][ii].setImg("img/pixel.png");
											uDone(levelBricks[i][ii]);
											break;
									}
								}*/
								if (levelBricks[i][ii].getHits()==2) {
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
	public ObjectThingy makeGameBrick(double x, double y, double wh) {
		return new ObjectThingy(x, y, wh, wh, 0, 2, "img/bricks/0/0.png", 1, c);
	}
}

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
	int[][] levels = {{2,5}, {3,5}};
	ObjectThingy levelBricks[][];
	ArrayList<ObjectThingy> firedBricks;
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
		firedBricks = new ArrayList<ObjectThingy>();
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
		// firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight()); // 2 is for spacing
		// firedSpud.setMove(0, -20);
		// firedSpud.setImg("img/fired.png");
		// firedSpud.allowMovability();
	}
	public void uDone(ObjectThingy killed) {
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
		for (int i=0;i<levelBricks.size();i++) {
			for (int ii=0;ii<levelBricks[i].length;ii++) {
				total++;
			}
		}
		for (int i=0;i<total;i++) {
			int[] a = {new RandomIntGenerator(0, levelBricks.size()-1).nextValue(), new RandomIntGenerator(0, levelBricks.get(0).length-1).nextValue()};
			if (!levelBricks.get(a[0]).get(a[1]).effectDone()) {
				while (levelBricks.get(a[0]).get(a[1]).getY()+levelBricks.get(a[0]).get(a[1]).getHeight() <= c.getHeight()) {
					levelBricks.get(a[0]).get(a[1]).move(0, 3);
					pause(2);
				}
				levelBricks.get(a[0]).get(a[1]).getOut();
				new Particles(levelBricks.get(a[0]).get(a[1]).getX()+levelBricks.get(a[0]).get(a[1]).getWidth()/2-c.getHeight()/192, levelBricks.get(a[0]).get(a[1]).getY()+levelBricks.get(a[0]).get(a[1]).getHeight()/2-c.getHeight()/192, c.getHeight()/24, 0, 0, 18, 1, 200, 0, 0, new int[] {0}, new Color[] {new Color(0x4a984b), new Color(0x54a953), new Color(0x5ab75a), new Color(0x5fc05f), new Color(0x64cb64)}, c);
				levelBricks.get(a[0]).get(a[1]).effectIsDone();
			} else {
				i-=1;
			}
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
		levelBricks = new ObjectThingy[levels[lvl][0]][levels[lvl][1]];
		for (int i=0;i < levelBricks.size(); i++) {
			for (int ii=0;ii < levelBricks[i].length; ii++) {
				if (ii >= 0) {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth)+((ii-1)*xGap), topY+((i)*pWidth), pWidth);
				} else {
					levelBricks[i][ii] = makeGameBrick(topX+((ii)*pWidth), topY+((i)*pWidth), pWidth);
				}
			}
		}
	}
	public void clearLevel() {
		if (level != -1) {
			for (int i=0;i < levelBricks.size(); i++) {
				for (int ii=0;ii < levelBricks.get(i).size(); ii++) {
					levelBricks.get(i).get(ii).killTotally();
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
					if (levelBricks.get(0)[0].getX() <= 0 || levelBricks.get(0)[levelBricks.get(0).length-1].getX()+levelBricks.get(0)[levelBricks.get(0).length-1].getWidth() >= c.getWidth()) {
						pFLdx = -pFLdx;
						pFLdy = fsw/4;
					}
				}
				if (canTouchThis) {
					if (levelBricks[levelBricks.size()-1][0].getY()+levelBricks[levelBricks.size()-1][0].getHeight() > c.getHeight()) {
						uDone(levelBricks[levelBricks.size()-1][0]);
					}
				}
				// if (firedSpud.getY() < 0) {
				// 	firedSpud.moveTo(-1000, -1000);
				// 	firedSpud.disallowMovability();
				// }
				// if (firedSpud.getY() > c.getHeight()) {
				// 	firedSpud.disallowMovability();
				// 	firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
				// 	firedSpud.setImg("img/fired.png");
				// }
				int done=0;
				int needed=0;
				if (canTouchThis) {
					for (int i=0;i < levelBricks.size(); i++) {
						needed += levelBricks[i].length;
						if (canTouchThis) {
							for (int ii=0;ii < levelBricks[i].length; ii++) {
								if (moveX) {
									levelBricks[i][ii].move(pFLdx, pFLdy);
								}
								if (pFLdy != 0) {
									levelBricks[i][ii].move(2*pFLdx, 3);
								}
								/*if (firedSpud.getObj().overlaps(levelBricks[i][ii].getObj())) {
									// firedSpud.disallowMovability();
									// firedSpud.moveTo(pladdle.getX()-firedSpud.getWidth()/2, c.getHeight()-firedSpud.getHeight());
									// firedSpud.setImg("img/fired.png");
									levelBricks[i][ii].hit();
									scor.addScore(level+1);
									switch (levelBricks[i][ii].getHits()) {
										case 0:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											break;
										case 1:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											levelBricks[i][ii].shrink(10);
											break;
										case 2:
											levelBricks[i][ii].setImg("img/bricks/"+levelBricks[i][ii].getHits()+"/0.png");
											levelBricks[i][ii].shrink(20);
											break;
										case 3:
											levelBricks[i][ii].setImg("img/pixel.png");
											uDone(levelBricks[i][ii]);
											break;
									}
								}*/
								if (levelBricks[i][ii].getHits()==2) {
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
	public ObjectThingy makeGameBrick(double x, double y, double wh) {
		return new ObjectThingy(x, y, wh, wh, 0, 2, "img/bricks/0/0.png", 1, c);
	}
}