import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ActiveGift extends ActiveObject {
	DrawingCanvas canvas;
	int pauseTime = 5;
	int runTimes = 5000;
	int counter = 0;
	Gift gift;
	int amx = 1;
	int amy = 1;
	public ActiveGift(double x, double y, double w, double h, DrawingCanvas c) {
		canvas = c;
		gift = new Gift(x, y, w, h, canvas);
		start();
	}
	public ActiveGift(Location xy, double w, double h, DrawingCanvas c) {
		canvas = c;
		gift = new Gift(xy, w, h, canvas);
		start();
	}
	public void move(double x, double y) {
		gift.move(x, y);
	}
	public void moveTo(double x, double y) {
		move(x-gift.base.getX(), y-gift.base.getY());
	}
	public void setColor(Color c) {
		gift.inside.setColor(c);
	}
	public void run() {
		while (counter < runTimes) {
			if (gift.getX()+gift.getWidth() == canvas.getWidth() || gift.getX() == 0) {
				amx = -amx;
			}
			if (gift.getY()+gift.getHeight() == canvas.getHeight() || gift.getY() == 0) {
				amy = -amy;
			}
			move(amx, amy);
			counter++;
			pause(pauseTime);
		}
	}
}