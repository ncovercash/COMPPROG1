import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Orn {
	FilledOval main;
	FilledOval inner1;
	FilledOval inner2;
	FramedOval hook;
	DrawingCanvas canvas;
	public Orn(double x, double y, double w, double h, Color c1, Color c2, Color c3, DrawingCanvas c) {
		canvas = c;
		main = new FilledOval(x, y, w, h, canvas);
		main.setColor(c1);
		inner1 = new FilledOval(x+w/4, y+h/4, w/2, h/2, canvas);
		inner1.setColor(c2);
		inner2 = new FilledOval(x+w/3, y+h/3, w/3, h/3, canvas);
		inner2.setColor(c3);
		hook = new FramedOval(x+w/2-w/20, y-h/20, w/10, h/10, canvas);
	}
	public Orn(Location xy, double w, double h, Color c1, Color c2, Color c3, DrawingCanvas c) {
		canvas = c;
		main = new FilledOval(xy, w, h, canvas);
		main.setColor(c1);
		inner1 = new FilledOval(xy.getX()+w/4, xy.getY()+h/4, w/2, h/2, canvas);
		inner1.setColor(c2);
		inner2 = new FilledOval(xy.getX()+w/3, xy.getY()+h/3, w/3, h/3, canvas);
		inner2.setColor(c3);
		hook = new FramedOval(xy.getX()+w/2-w/20, xy.getY()-h/20, w/10, h/10, canvas);
	}
	public void move(double x, double y) {
		main.move(x, y);
		inner1.move(x, y);
		inner2.move(x, y);
		hook.move(x, y);
	}
	public void moveTo(double x, double y) {
		move(x-main.getX(), y-main.getY());
	}
	public void setColor(Color c) {
		main.setColor(c);
	}
}