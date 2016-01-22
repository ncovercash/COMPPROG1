 

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Paddle {
	FilledRect pladal;
	public Paddle(double x, double y, double w, double h, Color c1, DrawingCanvas c) {
		pladal = new FilledRect(x, y, w, h, c);
		pladal.setColor(c1);
	}
	public Paddle(DrawingCanvas c) { // will generate correct sizes etc
		this(0, c.getHeight()-(c.getHeight()/25), c.getWidth()/10, c.getHeight()/20, new Color(209, 167, 117), c);
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
	public FilledRect getBaseObj() {
		return this.pladal;
	}
}