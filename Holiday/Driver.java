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
		base.setColor(giftBorderColor);
		new FilledRect(base.getX()+base.getWidth()/20, base.getY()+base.getHeight()/20, base.getWidth()-base.getWidth()/10, base.getHeight()-base.getHeight()/10, canvas).setColor(giftInsideColor);;
		new FilledRect(base.getX()+base.getWidth()/2-base.getWidth()/10, base.getY(), base.getWidth()/5, base.getHeight(), canvas).setColor(giftRibbonColor);
		new FilledRect(base.getX(), base.getY()+base.getHeight()/2-base.getHeight()/10, base.getWidth(), base.getHeight()/5, canvas).setColor(giftRibbonColor);
		new FilledOval(base.getX()+base.getWidth()/2-base.getWidth()/6, base.getY()+base.getHeight()/2-base.getHeight()/6, base.getWidth()/3, base.getHeight()/3, canvas).setColor(giftRibbonColor);
	}
	public void onMouseClick(Location p) {
		drawGift(100, 100, p);
	}
}