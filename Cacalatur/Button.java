

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Button extends ActiveObject {
	FilledRect bg;
	FramedRect border;
	int buttonFontSize;
	int BID, BID2; // nonce var
	Text button;
	public Button(String text, double x, double y, double w, double h, Color bgC, Color tC, DrawingCanvas c, int BID, int BID2) {
		bg = new FilledRect(x, y, w, h, c);
		this.BID=BID;
		this.BID2=BID2;
		bg.setColor(bgC);
		button = new Text(text, x+w/20, y+h/20, c);
		button.setColor(tC);
		button.setFontSize((int)h-((int)h/10));
		buttonFontSize = (int)h-((int)h/10);
		bg.setWidth(button.getWidth()*1.3);
		border = new FramedRect(x, y, w, h, c);
		border.setColor(tC);
		while (border.getWidth()-6 < button.getWidth() || border.getHeight()-6 < button.getHeight()) {
			buttonFontSize--;
			button.setFontSize(buttonFontSize);
		}
		button.moveTo(border.getX()+border.getWidth()/2-button.getWidth()/2, border.getY()+border.getHeight()/2-button.getHeight()/2);
		bg.setWidth(button.getWidth());
		bg.setHeight(button.getHeight());
	}
	public Button(String text, double x, double y, double w, double h, Color bgC, Color tC, DrawingCanvas c, int BID) {
		bg = new FilledRect(x, y, w, h, c);
		this.BID=BID;
		BID2=0;
		bg.setColor(bgC);
		button = new Text(text, x+w/20, y+h/20, c);
		button.setColor(tC);
		button.setFontSize((int)h-((int)h/10));
		buttonFontSize = (int)h-((int)h/10);
		bg.setWidth(button.getWidth()*1.3);
		border = new FramedRect(x, y, w, h, c);
		border.setColor(tC);
		while (border.getWidth()-6 < button.getWidth() || border.getHeight()-6 < button.getHeight()) {
			buttonFontSize--;
			button.setFontSize(buttonFontSize);
		}
		button.moveTo(border.getX()+border.getWidth()/2-button.getWidth()/2, border.getY()+border.getHeight()/2-button.getHeight()/2);
		bg.setWidth(button.getWidth());
		bg.setHeight(button.getHeight());
	}
	public Button(String text, double x, double y, double w, double h, Color bgC, Color tC, DrawingCanvas c) {
		bg = new FilledRect(x, y, w, h, c);
		BID=0;
		BID2=0;
		bg.setColor(bgC);
		button = new Text(text, x+w/20, y+h/20, c);
		button.setColor(tC);
		button.setFontSize((int)h-((int)h/10));
		buttonFontSize = (int)h-((int)h/10);
		bg.setWidth(button.getWidth()*1.3);
		border = new FramedRect(x, y, w, h, c);
		border.setColor(tC);
		while (border.getWidth()-6 < button.getWidth() || border.getHeight()-6 < button.getHeight()) {
			buttonFontSize--;
			button.setFontSize(buttonFontSize);
		}
		button.moveTo(border.getX()+border.getWidth()/2-button.getWidth()/2, border.getY()+border.getHeight()/2-button.getHeight()/2);
		bg.setWidth(button.getWidth());
		bg.setHeight(button.getHeight());
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
		return button.contains(p);
	}
	public int getBID() {
		return BID;
	}
	public int getBID2() {
		return BID2;
	}
	public void sendToFront() {
		bg.sendToFront();
		button.sendToFront();
		border.sendToFront();
	}
}