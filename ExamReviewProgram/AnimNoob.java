import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class AnimNoob extends ActiveObject {
	private noob a;
	private double i=0, runTimes=5000, pauseTime=50, dx=1, dy=1;
	private DrawingCanvas canvas;
	public AnimNoob(double x, double y, double w, double h, DrawingCanvas can) {
		a = new noob(x, y, w, h, can);
		canvas = can;
		start();
	}
	public void run() {
		while (i < runTimes) {
			i++;
			if (a.getX()+a.getWidth() == canvas.getWidth() || a.getX() == 0) {
				dx = -dx;
			}
			if (a.getY()+a.getHeight() == canvas.getHeight() || a.getY() == 0) {
				dy = -dy;
			}
			a.move(dx, dy);
			pause(pauseTime);
		}
	}
}