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
		new FilledRect(0, 0, canvas.getWidth(), canvas.getHeight(), canvas).setColor(new Color(0x000033));
		// a = new ActiveGift(new RandomIntGenerator(0, 1000).nextValue(), new RandomIntGenerator(0, 1000).nextValue(), new RandomIntGenerator(0, 100).nextValue(), new RandomIntGenerator(0, 100).nextValue(), new RandomIntGenerator(10, 60).nextValue(), canvas);
		// o = new ActiveOrn(200, 200, 200, 200, SnowColors[new RandomIntGenerator(0, 11).nextValue()], new Color(0x00ff00), new Color(0x0000ff), new RandomIntGenerator(10, 60).nextValue(), canvas);
		s = new ActiveSnow(80000, canvas); 
	}
	public void onMouseMove(Location p) {
	}
}