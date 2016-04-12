

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Button extends ActiveObject {
	FilledRect bg;
	int BID; // nonce var
	Text button;
	public Button(String text, double x, double y, double w, double h, Color bgC, Color tC, DrawingCanvas c, int BID) {
		bg = new FilledRect(x, y, w, h, c);
		this.BID=BID;
		bg.setColor(bgC);
		button = new Text(text, x+w/20, y+h/20, c);
		button.setColor(tC);
		button.setFontSize((int)h-((int)h/10));
		bg.setWidth(button.getWidth()*1.3);
	}
	public Button(String text, double x, double y, double w, double h, Color bgC, Color tC, DrawingCanvas c) {
		bg = new FilledRect(x, y, w, h, c);
		BID=0;
		bg.setColor(bgC);
		button = new Text(text, x+w/20, y+h/20, c);
		button.setColor(tC);
		button.setFontSize((int)h-((int)h/10));
		bg.setWidth(button.getWidth()*1.3);
	}
	public void moveTo(double dx, double dy) {
		bg.moveTo(dx,dy);
		button.moveTo(dx,dy);
	}
	public void move(double dx, double dy) {
		bg.move(dx,dy);
		button.move(dx,dy);
	}
	public double getX() {
		return bg.getX();
	}
	public double getY() {
		return bg.getY();
	}
	public double getWidth() {
		return bg.getWidth();
	}
	public double getHeight() {
		return bg.getHeight();
	}
	public FilledRect getBaseObjBG() {
		return bg;
	}
	public Text getBaseObjText() {
		return button;
	}
	public String getButtonText() {
		return button.getText();
	}
	public boolean testClick(Location p) {
		return bg.contains(p);
	}
	public int getBID() {
		return BID;
	}
}