import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Paddle {
	FilledRect donald;
	public Paddle(double x, double y, double w, double h, Color c1, DrawingCanvas c) {
		donald = new FilledRect(x, y, w, h, c);
		donald.setColor(c1);
	};
	public Paddle(DrawingCanvas c) { // will generate correct sizes etc
		this(0, c.getHeight()-(c.getHeight()/25), c.getWidth()/10, c.getHeight()/20, new Color(209, 167, 117), c);
	};
	public void moveTo(double dx, double dy) {
		donald.moveTo(dx,dy);
	};
	public void move(double dx, double dy) {
		donald.move(dx,dy);
	};
	public double getX() {
		return donald.getX();
	};
	public double getY() {
		return donald.getY();
	};
	public double getWidth() {
		return donald.getWidth();
	};
	public double getHeight() {
		return donald.getHeight();
	};
};