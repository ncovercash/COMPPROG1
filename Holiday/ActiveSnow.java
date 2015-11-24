import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ActiveSnow extends ActiveObject {
	DrawingCanvas canvas;
	int pauseTime = 5;
	int runTimes = 50000;
	int counter = 0;
	Snow[] activeFlakes;
	int amy;
	int qtyy;
	Color[] SnowColors = {new Color(0xeeeeee), new Color(0x999999), new Color(0xcccccc), new Color(0x888888), new Color(0x777777), new Color(0x666666), new Color(0x555555), new Color(0x444444), new Color(0x333333), new Color(0x111111), new Color(0x222222), new Color(0xffffff)};
	RandomIntGenerator amxG = new RandomIntGenerator(-3, 3);
	RandomIntGenerator amyG = new RandomIntGenerator(1, 3);
	RandomIntGenerator whgen = new RandomIntGenerator(1, 3);
	public ActiveSnow(int qty, DrawingCanvas c) {
		activeFlakes = new Snow[qty];
		pauseTime = new RandomIntGenerator(10, 60).nextValue();
		canvas = c;
		qtyy=qty;
		int i = 0;
		while (i < qty) {
			System.out.println(i);
			activeFlakes[i] = new Snow(new RandomIntGenerator(0, canvas.getWidth()).nextValue(), new RandomIntGenerator(-100, canvas.getHeight()).nextValue(), whgen.nextValue(), whgen.nextValue(), SnowColors[new RandomIntGenerator(0, 11).nextValue()], canvas);
			i++;
		}
		start();
	}
	public void move(int i, double x, double y) {
		activeFlakes[i].move(x, y);
	}
	public void moveTo(int i, double x, double y) {
		move(i, x-activeFlakes[i].getX(), y-activeFlakes[i].getY());
	}
	public void setColor(int i, Color c) {
		activeFlakes[i].setColor(c);
	}
	double getX(int i) {
		return activeFlakes[i].getX();
	}
	double getY(int i) {
		return activeFlakes[i].getY();
	}
	double getWidth(int i) {
		return activeFlakes[i].getWidth();
	}
	double getHeight(int i) {
		return activeFlakes[i].getHeight();
	}
	public void run() {
		while (counter < runTimes) {
			int i = 0;
			while (i < qtyy) {
				if (activeFlakes[i].getY()+activeFlakes[i].getHeight() == canvas.getHeight()) {
					activeFlakes[i].moveTo(activeFlakes[i].getX(), -100);
				}
				move(i, amxG.nextValue(), amyG.nextValue());
				i++;
			}
			counter++;
			pause(pauseTime);
		}
	}
}