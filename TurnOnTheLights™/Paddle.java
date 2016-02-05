 

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Paddle {
	VisibleImage pladal;
	int mult;
	public Paddle(double x, double y, double w, double h, String img, int posFromBottom, DrawingCanvas c) {
		try {
			pladal = new VisibleImage(ImageIO.read(new File(img)), x, y, w, h, c);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		this.mult = posFromBottom+1;
	}
	public Paddle(DrawingCanvas c, int posFromBottom, int numOfPaddles) { // will generate correct sizes etc
		this(0, c.getHeight()-(c.getWidth()/25*3.1474358974), c.getWidth()/25, c.getWidth()/25*3.1474358974, "img/paddle.png", posFromBottom, c);
	}
	public void moveTo(double dx, double dy) {
		this.pladal.moveTo(dx,pladal.getY());
	}
	public void move(double dx, double dy) {
		this.pladal.move(dx,dy);
	}
	public double getX() {
		return this.pladal.getX();
	}
	public double getY() {
		return this.pladal.getY();
	}
	public double getWidth() {
		return this.pladal.getWidth();
	}
	public double getHeight() {
		return this.pladal.getHeight();
	}
	public VisibleImage getBaseObj() {
		return this.pladal;
	}
	public int getMult() {
		return this.mult;
	}
	public void getMult(int m) {
		mult = m;
	}
}