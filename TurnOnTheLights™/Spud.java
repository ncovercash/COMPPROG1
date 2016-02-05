

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Spud extends ActiveObject {
	VisibleImage meme;
	DrawingCanvas c;
	int dx, dy;
	double m;
	String pimg;
	static int coünt;
	boolean alive=true, moveability=false;
	int hits = 0;
	public Spud(double x, double y, double w, double h, int dx, int dy, String pimg, double mult, DrawingCanvas c) {
		this.c = c;
		this.dx = dx;
		this.dy = dy;
		this.m = mult;
		if (pimg != null && !pimg.isEmpty()) {
			this.pimg = pimg;
			try {
				meme = new VisibleImage(ImageIO.read(new File(pimg)), x, y, w, h, c);
				coünt++;
			} catch (IOException e) {
				System.out.println(e);
				System.exit(1);
			}
		} else {
			this.pimg = "";
			try {
				meme = new VisibleImage(ImageIO.read(new File("img/potatoFallback.png")), x, y, w, h, c);
				coünt++;
			} catch (IOException e) {
				System.out.println(e);
				System.exit(1);
			}
		}
		start();
	}
	public Spud(String pimg, double mult, DrawingCanvas c, int pos) {
		this((c.getWidth()/2)-c.getWidth()/20+(pos*(c.getWidth()/50)), 0, c.getWidth()/50, c.getWidth()/50, new RandomIntGenerator(-c.getHeight()/60, c.getHeight()/60).nextValue(), new RandomIntGenerator(c.getHeight()/90, c.getHeight()/60).nextValue(), pimg, mult, c);
	}
	public void run() {
		while (alive) {
			if (moveability) {
				meme.move(dx, dy);
			}
			pause(15);
		}
		coünt--;
	}
	public void move() {
		meme.move(dx, dy);
	}
	public void moveTo(double dx, double dy) {
		meme.moveTo(dx, dy);
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
	public void killGamePotato() {
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
	public void setImg(String pimg) {
		this.pimg = pimg;
		System.out.println(pimg);
		try {
			meme.setImage(ImageIO.read(new File(pimg)));
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
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
	public VisibleImage getObj() {
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
}