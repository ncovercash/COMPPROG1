

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Base extends ActiveObject {
	VisibleImage pladal;
	int mult, imgState=0;
	boolean alive=true;
	public Base(double x, double y, double w, double h, String img, int posFromBottom, DrawingCanvas c) {
		try {
			pladal = new VisibleImage(ImageIO.read(new File(img)), x, y, w, h, c);
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("a");
		}
		this.mult = posFromBottom+1;
		start();
	}
	public Base(DrawingCanvas c, int posFromBottom, int numOfBases) { // will generate correct sizes etc
		this(0, c.getHeight()-(c.getWidth()/18), c.getWidth()/20, c.getWidth()/20, "img/paddle0.png", posFromBottom, c);
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
	public void run() {
		while (alive) {
			try {
				switch (imgState) {
					case 0:
						pladal.setImage(ImageIO.read(new File("img/paddle1.png")));
						imgState=1;
						break;
					case 1:
						pladal.setImage(ImageIO.read(new File("img/paddle0.png")));
						imgState=0;
						break;
				}
			} catch (IOException e) {
				System.out.println(e);
				System.out.println("b");
			}
			pause(200);
		}
	}
}