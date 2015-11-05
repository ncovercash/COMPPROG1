import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Color giftBorderColor = new Color(0xff0000);
	Color giftInsideColor = new Color(0x00ff00);
	Color giftRibbonColor = new Color(0x0000ff);
	FilledRect base;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController(1000, 1000);
	}
	public void drawGift(int w, int h, Location p) {
		base = new FilledRect(p, w, h, canvas);
		base.setColor(giftBorder);
		new FilledRect(base.getX()+base.getWidth()/20, base.getY()+base.getHeight()/20, 10, 10, canvas);
	}
	public void onMouseClick(Location p) {
		drawGift(100, 100, p);
	}
}