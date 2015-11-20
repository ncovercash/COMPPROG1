import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Snow {
	FilledOval flake;
	DrawingCanvas canvas;
	public Snow(double x, double y, double w, double h, Color c, DrawingCanvas can) {
		canvas = can;
		flake = new FilledOval(x, y, w, h, canvas);
		flake.setColor(c);
	}
	public Snow(Location xy, double w, double h, Color c, DrawingCanvas can) {
		canvas = can;
		flake = new FilledOval(xy, w, h, canvas);
		flake.setColor(c);
	}
	public void move(double x, double y) {
		flake.move(x, y);
	}
	public void moveTo(double x, double y) {
		move(x-flake.getX(), y-flake.getY());
	}
	public void setColor(Color c) {
		flake.setColor(c);
	}
	double getX() {
		return flake.getX();
	}
	double getY() {
		return flake.getY();
	}
	double getWidth() {
		return flake.getWidth();
	}
	double getHeight() {
		return flake.getHeight();
	}
}