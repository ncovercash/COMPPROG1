import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class noob {
	private FilledRect a;
	private FilledOval b;
	private FramedRect c;
	public noob(double x, double y, double w, double h, DrawingCanvas can) {
		a = new FilledRect(x, y, w, h, can);
		a.setColor(new Color(0, 255, 0));
		b = new FilledOval(x, y, w, h, can);
		b.setColor(new Color(0xff0000));
		c = new FramedRect(x, y, w, h, can);
	}
	public void move(double x, double y) {
		a.move(x, y);
		b.move(x, y);
		c.move(x, y);
	}
	public double getX() {
		return a.getX();
	}
	public double getY() {
		return a.getY();
	}
	public double getWidth() {
		return a.getWidth();
	}
	public double getHeight() {
		return a.getHeight();
	}
}