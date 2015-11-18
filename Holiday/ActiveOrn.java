import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ActiveOrn extends ActiveObject {
	DrawingCanvas canvas;
	int pauseTime = 200;
	int runTimes = 100;
	int counter = 0;
	Orn orn;
	public ActiveOrn(double x, double y, double w, double h, Color c1, Color c2, Color c3, DrawingCanvas c) {
		canvas = c;
		orn = new Orn(x, y, w, h, c1, c2, c3, canvas);
		start();
	}
	public ActiveOrn(Location xy, double w, double h, Color c1, Color c2, Color c3, DrawingCanvas c) {
		canvas = c;
		orn = new Orn(xy, w, h, c1, c2, c3, canvas);
		start();
	}
	public void move(double x, double y) {
		orn.main.move(x, y);
		orn.inner1.move(x, y);
		orn.inner2.move(x, y);
		orn.hook.move(x, y);
	}
	public void moveTo(double x, double y) {
		move(x-orn.main.getX(), y-orn.main.getY());
	}
	public void setColor(Color c) {
		orn.main.setColor(c);
	}
	public void run() {
		while (counter < runTimes) {
			orn.main.setColor(new Color(0xff0000));
			orn.inner1.setColor(new Color(0x00ff00));
			orn.inner2.setColor(new Color(0x0000ff));
			pause(pauseTime);
			orn.main.setColor(new Color(0x00ff00));
			orn.inner1.setColor(new Color(0x0000ff));
			orn.inner2.setColor(new Color(0xff0000));
			pause(pauseTime);
			runTimes++;
		}
	}
}