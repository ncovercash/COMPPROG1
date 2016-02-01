

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Legend {
	String legend = "";
	Text[] legendObjs;
	public Legend(double x, double y, int fs, String[] parts, String delimiter1, String delimiter2, String orientation, DrawingCanvas c) {
		if (parts.length%2!=0) {
			System.out.println("bad array");
			System.exit(1);
		}
		if (orientation == "vertical") {
			legendObjs = new Text[parts.length/2];
			for (int i = 0; i < parts.length; i+=2) {
				legend += parts[i];
				legend += delimiter1;
				legend += parts[i+1];
				legend += delimiter2;
				legendObjs[i/2] = new Text(legend, x, y+(fs*i/2)+((i/2)*(fs/5)), c);
				legend = "";
			}
		} else {
			for (int i = 0; i < parts.length; i+=2) {
				legend += parts[i];
				legend += delimiter1;
				legend += parts[i+1];
				legend += delimiter2;
			}
			legendObjs = new Text[1];
			legendObjs[0] = new Text(legend, x, y, c);
		}
		setFontSize(fs);
	}
	public void addToCanvas(DrawingCanvas canvas) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].addToCanvas(canvas);
		}
	}
	public DrawingCanvas getCanvas() {
		return legendObjs[0].getCanvas();
	}
	public java.awt.Color getColor() {
		return legendObjs[0].getColor();
	}
	public java.awt.Font getFont() {
		return legendObjs[0].getFont();
	}
	public double getHeight() {
		return legendObjs[0].getHeight();
	}
	public Location getLocation() {
		return legendObjs[0].getLocation();
	}
	public double getWidth() {
		return legendObjs[0].getWidth();
	}
	public double getX() {
		return legendObjs[0].getX();
	}
	public double getY() {
		return legendObjs[0].getY();
	}
	public void hide() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].hide();
		}
	}
	public boolean isHidden() {
		return legendObjs[0].isHidden();
	}
	public void move(double dx, double dy) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].move(dx, dy);
		}
	}
	public void moveTo(double x, double y) {
		move(x-getX(), y-getY());
	}
	public void moveTo(Location point) {
		move(point.getX()-getX(), point.getY()-getY());
	}
	public boolean overlaps(Drawable2DInterface item) {
	    boolean outcome=false;
		for (int i=0;i < legendObjs.length; i++) {
			if (legendObjs[i].overlaps(item)) {
				outcome = true;
			}
		}
		return outcome;
	}
	public void removeFromCanvas() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].removeFromCanvas();
		}
	}
	public void sendBackward() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].sendBackward();
		}
	}
	public void sendForward() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].sendForward();
		}
	}
	public void sendToBack() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].sendToBack();
		}
	}
	public void sendToFront() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].sendToFront();
		}
	}
	public void setBold(boolean bool) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setBold(bool);
		}
	}
	public void setColor(java.awt.Color c) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setColor(c);
		}
	}
	public void setFont(java.awt.Font f) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setFont(f);
		}
	}
	public void setFont(java.lang.String fname) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setFont(fname);
		}
	}
	public void setFontSize(int size) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setFontSize(size);
		}
	}
	public void setItalic(boolean bool) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setItalic(bool);
		}
	}
	public void setPlain() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setPlain();
		}
	}
	public void setText(boolean text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void setText(char text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void setText(double text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void setText(long text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void setText(java.lang.Object text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void setText(java.lang.String text) {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].setText(text);
		}
	}
	public void show() {
		for (int i=0;i < legendObjs.length; i++) {
			legendObjs[i].show();
		}
	}
}