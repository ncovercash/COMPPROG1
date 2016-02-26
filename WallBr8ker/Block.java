

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Block extends ActiveObject {
	FilledRect meme;
	DrawingCanvas c;
	int dx, dy;
	double m, ox, oy, ow, oh;
	boolean alive=true, moveability=false, ed=false;
	int hits = 0;
	public Block(double x, double y, double w, double h, int dx, int dy, Color c1, double mult, DrawingCanvas c) {
		this.c = c;
		this.dx = dx;
		this.dy = dy;
		this.m = mult;
		ox = x;
		oy = y;
		ow = w;
		oh = h;
		meme = new FilledRect(x, y, w, h, c);
		meme.setColor(c1);
		start();
	}
	public Block(Color c1, double mult, DrawingCanvas c, int pos) {
		this((c.getWidth()/2)-c.getWidth()/20+(pos*(c.getWidth()/50)), 0, c.getWidth()/50, c.getWidth()/50, new RandomIntGenerator(-c.getHeight()/60, c.getHeight()/60).nextValue(), new RandomIntGenerator(c.getHeight()/90, c.getHeight()/60).nextValue(), c1, mult, c);
	}
	public void run() {
		while (alive) {
			if (moveability) {
				boolean dyChanged=false;
				if (meme.getX()+dx+meme.getWidth() >= c.getWidth() || meme.getX()+dx <= 0) {
					dx = -dx;
					dy = dy+2;
					dyChanged = true;
				}
				meme.move(dx, dy);
				if (dyChanged) {
					dy = 0;
				}
			}
			pause(15);
		}
	}
	public void move() {
		meme.move(dx, dy);
	}
	public void moveTo(double dx, double dy) {
		meme.moveTo(dx, dy);
	}
	public void effectIsDone() {
		ed = true;
	}
	public void toggleMovability() {
		moveability = !moveability;
	}
	public void allowMovability() {
		moveability = true;
	}
	public void disallowMovability() {
		moveability = false;
	}
	public boolean getMovability() {
		return moveability;
	}
	public void killTotally() {
		alive=false;
		disallowMovability();
		try {
			meme.removeFromCanvas();
		} catch (IllegalStateException e) {
			//
		}
	}
	public void revive() {
		alive = true;
		start();
	}
	public void setColor(Color c) {
		meme.setColor(c);
	}
	public boolean isDead() {
		return !alive;
	}
	public boolean canMove() {
		return moveability;
	}
	public void toggleDeath() {
		alive = !alive;
		if (alive) {
			start();
		}
	}
	public void reverseX() {
		dx = -dx;
		move();
	}
	public void reverseY() {
		dy = -dy;
		move();
	}
	public double getX() {
		return meme.getX();
	}
	public double getXChange() {
		return dx;
	}
	public double getY() {
		return meme.getY();
	}
	public double getWidth() {
		return meme.getWidth();
	}
	public double getHeight() {
		return meme.getHeight();
	}
	public void moveToDeath() {
		meme.moveTo(0, c.getHeight());
		dx = 0;
		dy = 0;
		meme.moveTo(0, c.getHeight());
	}
	public int getScoreToAdd() {
		return (int)m;
	}
	public Location getLocation() {
		return meme.getLocation();
	}
	public FilledRect getObj() {
		return meme;
	}
	public void getOut() {
		meme.removeFromCanvas();
	}
	public void setMove(double dx, double dy) {
		this.dx = (int)dx;
		this.dy = (int)dy;
	}
	public void newXChange() {
		dx = new RandomIntGenerator(-5, 5).nextValue();
	}
	public int getHits() {
		return hits;
	}
	public void hit() {
		hits++;
	}
	public int getMult() {
		return (int)m;
	}
	public void move(double dx, double dy) {
		meme.move(dx, dy);
	}
	public boolean effectDone() {
		return ed;
	}
	public void shrink(double p) {
		double oow = getWidth();
		double ooh = getHeight();
		meme.setWidth(ow*(1-(p/100)));
		meme.setHeight(oh*(1-(p/100)));
		meme.move((oow-getWidth())/2, (ooh-getHeight())/2);
	}
}