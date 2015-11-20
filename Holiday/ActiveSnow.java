import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ActiveSnow extends ActiveObject {
	DrawingCanvas canvas;
	int pauseTime = 5;
	int runTimes = 5000;
	int counter = 0;
	Snow activeFlake;
	int amy;
	RandomIntGenerator amxG = new RandomIntGenerator(-3, 3);
	RandomIntGenerator amyG = new RandomIntGenerator(1, 3);
	RandomIntGenerator whgen = new RandomIntGenerator(1, 3);
	public ActiveSnow(double x, double y, Color c1, DrawingCanvas c) {
		canvas = c;
		activeFlake = new Snow(x, y, whgen.nextValue(), whgen.nextValue(), c1, canvas);
		amy = amyG.nextValue();
		start();
	}
	public ActiveSnow(Location xy, Color c1, DrawingCanvas c) {
		canvas = c;
		activeFlake = new Snow(xy, whgen.nextValue(), whgen.nextValue(), c1, canvas);
		amy = amyG.nextValue();
		start();
	}
	public void move(double x, double y) {
		activeFlake.move(x, y);
	}
	public void moveTo(double x, double y) {
		move(x-activeFlake.getX(), y-activeFlake.getY());
	}
	public void setColor(Color c) {
		activeFlake.setColor(c);
	}
	double getX() {
		return activeFlake.getX();
	}
	double getY() {
		return activeFlake.getY();
	}
	double getWidth() {
		return activeFlake.getWidth();
	}
	double getHeight() {
		return activeFlake.getHeight();
	}
	public void run() {
		while (counter < runTimes) {
			if (activeFlake.getY()+activeFlake.getHeight() == canvas.getHeight()) {
				activeFlake.moveTo(activeFlake.getX(), -100);
			}
			move(amxG.nextValue(), amy);
			counter++;
			pause(pauseTime);
		}
	}
}