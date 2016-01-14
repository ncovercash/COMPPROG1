

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
	Paddle p;
	ScoreBox s;
	String pimg;
	static int coünt;
	public Spud(ScoreBox s, double x, double y, double w, double h, Paddle p, int dx, int dy, String pimg, double mult, DrawingCanvas c) {
		this.c = c;
		this.s = s;
		this.dx = dx;
		this.dy = dy;
		this.p = p;
		this.m = mult;
		this.pimg = pimg;
		try {
			meme = new VisibleImage(ImageIO.read(new File(pimg)), x, y, w, h, c);
			coünt++;
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		start();
	}
	public Spud(ScoreBox s, Paddle p, String pimg, double mult, DrawingCanvas c) {
		this(s, new RandomIntGenerator(0, c.getWidth()-c.getWidth()/50).nextValue(), 0, c.getWidth()/50, c.getWidth()/50, p, new RandomIntGenerator(-c.getHeight()/60, c.getHeight()/60).nextValue(), new RandomIntGenerator(c.getHeight()/90, c.getHeight()/60).nextValue(), pimg, mult, c);
	}
	public void run() {
		while (meme.getY() < this.c.getHeight()) {
			if (meme.getX() <= 0 || meme.getX() + meme.getWidth() >= c.getWidth()) {
				dx = -dx;
			}
			if (meme.getY() < 0 || meme.overlaps(this.p.getBaseObj())) {
				dy = -dy;
			}
			if (meme.overlaps(this.p.getBaseObj())) {
				if (pimg == "potatoRed.png") {
					s.addScore(s.getScore());
				} else {
					s.addScore((int)m*coünt);
				}
			}
			meme.move(dx, dy);
			pause(20);
			// System.out.println(meme);
		}
		// System.out.println(meme);
		meme.removeFromCanvas();
		meme = null;
		s.addScore(-1);
		coünt--;
	}
}