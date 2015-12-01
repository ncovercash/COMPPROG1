import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	ActiveGift a;
	ActiveOrn o;
	ActiveSnow s;
	
	int t = 0;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController(2500, 1250);
	}
	public void begin() {
		// a = new ActiveGift(new RandomIntGenerator(0, 1000).nextValue(), new RandomIntGenerator(0, 1000).nextValue(), new RandomIntGenerator(0, 100).nextValue(), new RandomIntGenerator(0, 100).nextValue(), new RandomIntGenerator(10, 60).nextValue(), canvas);
		// o = new ActiveOrn(200, 200, 200, 200, SnowColors[new RandomIntGenerator(0, 11).nextValue()], new Color(0x00ff00), new Color(0x0000ff), new RandomIntGenerator(10, 60).nextValue(), canvas);
	}
	public void onMouseMove(Location p) {
		new Triangul(p.getX(), p.getY(), 100, 100, 5, new Color(0xff00ff), canvas);
	}
}