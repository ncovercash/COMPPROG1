

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class World extends ActiveObject {
	// red: bad bigger, [0-.2), yellow:GREAT size reset, [.2-.25], green: reg +1 score, (.25,1)
	Pig pig;
	Slider size;
	ScoreBox scor;
	ResetButton RESET;
	Text a;
	int oldSize;
	Base base;
	ArrayList<Projectile> fired;
	Projectile deadProjectile;
	DrawingCanvas c;
	boolean gameOver=false, aSet=false;
	double nextPRandom;
	public World(DrawingCanvas c) {
		this.c=c;
		pig = new Pig(0, 0, 400, 400, 3, 0, new Color(0xff0000), new Color(0x000000), new Color(0xffffff), c);
		size = new Slider(10, 100, 40, 200, new int[] {1,101}, 50, new boolean[] {true, false, true, true}, new Color(0xff0000), "Size", c);
		base = new Base(c, 0, 1);
		scor = new ScoreBox(c, 0, new Color(250,193,102), "Score: ");
		RESET = new ResetButton(c);
		deadProjectile = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, 0, "img/projectile/green.png", 1, c);
		fired = new ArrayList<Projectile>();
		nextPRandom=.5;
		start();
	}
	public void onMouseClick(Location p) {
		if (RESET.testClick(p)) {
			reset();
		} else {
			fire();
		}
	}
	public void fire() {
		nextPRandom = Math.random();
		Projectile t;
		if (nextPRandom < .2) {
			deadProjectile.setImg("img/projectile/red.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -20, "img/projectile/red.png", -1, c);
		} else if (nextPRandom <= .25) {
			deadProjectile.setImg("img/projectile/yellow.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -20, "img/projectile/yellow.png", 0, c);
		} else {
			deadProjectile.setImg("img/projectile/green.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -20, "img/projectile/green.png", 1, c);
		}
		t.allowMovability();
		fired.add(t);
	}
	public void reset() {
		pig.removeFromCanvas();
		pig.interrupt();
		if (aSet) {
			a.hide();
		}
		pig = new Pig(0, 0, 400, 400, 3, 0, new Color(0xff0000), new Color(0x000000), new Color(0xffffff), c);
		scor.setScore(0);
		size.setSlide(50);
	}
	public void onMouseDrag(Location p) {
		if (size.contains(p)) {
			size.drag(p);
			if (size.val()>oldSize) {
				oldSize = size.val();
				pig.grow(0.1);
			} else if (size.val()<oldSize) {
				oldSize = size.val();
				pig.shrink(0.1);
			}
		}
	}
	public void die() {
		a = new Text("Score: "+scor.getScore(),0,0,c);
		aSet=true;
		a.setFontSize(c.getHeight()/6);
		a.moveTo(c.getWidth()/2-a.getWidth()/2, c.getHeight()/2-a.getHeight()/2);
		pig.interrupt();
		pig.stahp();
	}
	public void run() {
		while (!gameOver) {
			if (pig.getBottomY() >= c.getHeight()) {
				die();
			}
			for (int i=0;i<fired.size();i++) {
				if (fired.get(i).getY() < 0) {
					fired.get(i).getOut();
					fired.remove(i);
					i--;
				} else {
					if (pig.mouthOverlaps(fired.get(i).getObj())) {
						switch(fired.get(i).getMult()) {
							case -1:
								pig.grow(.1);
								break;
							case 0:
								pig.defaultSize();
								break;
							case 1:
								scor.addScore(1);
								break;
						}
						fired.get(i).getOut();
						fired.remove(i);
					} else if (pig.overlaps(fired.get(i).getObj())) {
						scor.addScore(-1);
						fired.get(i).getOut();
						fired.remove(i);
						i--;
					}
				}
			}
			pause(1);
		}
	}
	public void onMousePress(Location p) {
		//
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= c.getWidth()-base.getWidth()) {
			base.moveTo(p.getX(), 0);
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-5, base.getY());
		}
	}
	public void onMouseEnter(Location p) {
		//
	}
	public void onMouseExit(Location p) {
		//
	}
	public void debugLine(Exception a) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}
	public void debugLine(Exception a, String arg) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(arg+"  "+exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}
}
