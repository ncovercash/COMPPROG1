import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Gift {
	Color giftBorderColor = new Color(0xff0000);
	Color giftInsideColor = new Color(0x00ff00);
	Color giftRibbonColor = new Color(0x0000ff);
	FilledRect base;
	FilledRect inside;
	FilledRect ribbon1;
	FilledRect ribbon2;
	FilledOval ribbon3;
	DrawingCanvas canvas;
	public Gift(double x, double y, double w, double h, DrawingCanvas c) {
		canvas = c;
		base = new FilledRect(x, y, w, h, canvas);
		base.setColor(giftBorderColor);
		inside = new FilledRect(base.getX()+base.getWidth()/20, base.getY()+base.getHeight()/20, base.getWidth()-base.getWidth()/10, base.getHeight()-base.getHeight()/10, canvas);
		inside.setColor(giftInsideColor);
		ribbon1 = new FilledRect(base.getX()+base.getWidth()/2-base.getWidth()/10, base.getY(), base.getWidth()/5, base.getHeight(), canvas);
		ribbon1.setColor(giftRibbonColor);
		ribbon2 = new FilledRect(base.getX(), base.getY()+base.getHeight()/2-base.getHeight()/10, base.getWidth(), base.getHeight()/5, canvas);
		ribbon2.setColor(giftRibbonColor);
		ribbon3 = new FilledOval(base.getX()+base.getWidth()/2-base.getWidth()/6, base.getY()+base.getHeight()/2-base.getHeight()/6, base.getWidth()/3, base.getHeight()/3, canvas);
		ribbon3.setColor(giftRibbonColor);
	}
	public Gift(Location xy, double w, double h, DrawingCanvas c) {
		canvas = c;
		base = new FilledRect(xy, w, h, canvas);
		base.setColor(giftBorderColor);
		inside = new FilledRect(base.getX()+base.getWidth()/20, base.getY()+base.getHeight()/20, base.getWidth()-base.getWidth()/10, base.getHeight()-base.getHeight()/10, canvas);
		inside.setColor(giftInsideColor);
		ribbon1 = new FilledRect(base.getX()+base.getWidth()/2-base.getWidth()/10, base.getY(), base.getWidth()/5, base.getHeight(), canvas);
		ribbon1.setColor(giftRibbonColor);
		ribbon2 = new FilledRect(base.getX(), base.getY()+base.getHeight()/2-base.getHeight()/10, base.getWidth(), base.getHeight()/5, canvas);
		ribbon2.setColor(giftRibbonColor);
		ribbon3 = new FilledOval(base.getX()+base.getWidth()/2-base.getWidth()/6, base.getY()+base.getHeight()/2-base.getHeight()/6, base.getWidth()/3, base.getHeight()/3, canvas);
		ribbon3.setColor(giftRibbonColor);
	}
	public void move(int x, int y) {
		base.move(x, y);
		inside.move(x, y);
		ribbon1.move(x, y);
		ribbon2.move(x, y);
		ribbon3.move(x, y);
	}
	public void moveTo(int x, int y) {
		move(x-base.getX(), y-base.getY());
	}
}