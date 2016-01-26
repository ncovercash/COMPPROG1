

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Legend {
	String legend = "";
	Text legendObj;
	String n = System.getProperty("line.separator");
	public Legend(double x, double y, int fs, String[] parts, String delimiter1, String delimiter2, String orientation, DrawingCanvas c) {
		if (orientation == "vertical") {
			int i = 0;
			while (i < parts.length) {
				legend += parts[i];
				legend += delimiter1;
				legend += parts[i+1];
				legend += delimiter2;
				legend += n;
				i += 2;
				System.out.println(n);
				System.out.println(n.toString());
			}
			System.out.println(legend);
		} else {
			int i = 0;
			while (i < parts.length) {
				legend += parts[i];
				legend += delimiter1;
				legend += parts[i+1];
				legend += delimiter2;
				i += 2;
			}
			System.out.println(legend);
		}
		legendObj = new Text(legend, x, y, c);
		legendObj.setFontSize(fs);
	}
	public void addToCanvas(DrawingCanvas canvas) {
		legendObj.addToCanvas(canvas);
	}
	public boolean contains(Location point) {
		return legendObj.contains(point);
	}
	public DrawingCanvas getCanvas() {
		return legendObj.getCanvas();
	}
	public java.awt.Color getColor() {
		return legendObj.getColor();
	}
	public java.awt.Font getFont() {
		return legendObj.getFont();
	}
	public double getHeight() {
		return legendObj.getHeight();
	}
	public Location getLocation() {
		return legendObj.getLocation();
	}
	public java.lang.String getText() {
		return legendObj.getText();
	}
	public double getWidth() {
		return legendObj.getWidth();
	}
	public double getX() {
		return legendObj.getX();
	}
	public double getY() {
		return legendObj.getY();
	}
	public void hide() {
		legendObj.hide();
	}
	public boolean isHidden() {
		return legendObj.isHidden();
	}
	public void move(double dx, double dy) {
		legendObj.move(dx, dy);
	}
	public void moveTo(double x, double y) {
		legendObj.moveTo(x, y);
	}
	public void moveTo(Location point) {
		legendObj.moveTo(point);
	}
	public boolean overlaps(Drawable2DInterface item) {
		return legendObj.overlaps(item);
	}
	public void removeFromCanvas() {
		legendObj.removeFromCanvas();
	}
	public void sendBackward() {
		legendObj.sendBackward();
	}
	public void sendForward() {
		legendObj.sendForward();
	}
	public void sendToBack() {
		legendObj.sendToBack();
	}
	public void sendToFront() {
		legendObj.sendToFront();
	}
	public void setBold(boolean bool) {
		legendObj.setBold(bool);
	}
	public void setColor(java.awt.Color c) {
		legendObj.setColor(c);
	}
	public void setFont(java.awt.Font f) {
		legendObj.setFont(f);
	}
	public void setFont(java.lang.String fname) {
		legendObj.setFont(fname);
	}
	public void setFontSize(int size) {
		legendObj.setFontSize(size);
	}
	public void setItalic(boolean bool) {
		legendObj.setItalic(bool);
	}
	public void setPlain() {
		legendObj.setPlain();
	}
	public void setText(boolean text) {
		legendObj.setText(text);
	}
	public void setText(char text) {
		legendObj.setText(text);
	}
	public void setText(double text) {
		legendObj.setText(text);
	}
	public void setText(long text) {
		legendObj.setText(text);
	}
	public void setText(java.lang.Object text) {
		legendObj.setText(text);
	}
	public void setText(java.lang.String text) {
		legendObj.setText(text);
	}
	public void show() {
		legendObj.show();
	}
	public java.lang.String toString() {
		return legendObj.toString();
	}
}