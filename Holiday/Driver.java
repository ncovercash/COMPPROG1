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
	public void onMouseClick(Location p) {
		new Treé(p.getX(), p.getY(), 500, 800, new Color[] {new Color(0x000000), new Color(0x003300), new Color(0x006600), new Color(0x009900), new Color(0x00CC00), new Color(0x00FF00), new Color(0x330000), new Color(0x333300), new Color(0x336600), new Color(0x339900), new Color(0x33CC00), new Color(0x33FF00), new Color(0x660000), new Color(0x663300), new Color(0x666600), new Color(0x669900), new Color(0x66CC00), new Color(0x66FF00), new Color(0x990000), new Color(0x993300), new Color(0x996600), new Color(0x999900), new Color(0x99CC00), new Color(0x99FF00), new Color(0xCC0000), new Color(0xCC3300), new Color(0xCC6600), new Color(0xCC9900), new Color(0xCCCC00), new Color(0xCCFF00), new Color(0xFF0000), new Color(0xFF3300), new Color(0xFF6600), new Color(0xFF9900), new Color(0xFFCC00), new Color(0xFFFF00)}, canvas); // norm xmas colors
		// new Treé(p.getX(), p.getY(), 500, 800, new Color[] {new Color(0x6FFF00) , new Color(0xFF00FF) , new Color(0xFFFF00) , new Color(0x4D4DFF) , new Color(0xFE0001) , new Color(0xFF4105) , new Color(0x993CF3)}, canvas); // neon lol
	}
}