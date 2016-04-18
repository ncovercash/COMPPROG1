

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Cacalatur extends ActiveObject {
	DrawingCanvas c;
	FramedRect border, nestedBorder, resultBorder, lowerSecBorder;
	Text mode;
	ScoreBox top;
	ArrayList<Integer> inputs;
	ArrayList<Button> buttons;
	public Cacalatur(DrawingCanvas c) {
		this.c=c;
		inputs = new ArrayList<Integer>();
		buttons = new ArrayList<Button>(40);
		if ((c.getHeight()-10)/2 < c.getWidth()-10) {
			border = new FramedRect((c.getWidth()-(c.getHeight()/2-10))/2, 5, (c.getHeight()-10)/2, c.getHeight()-10, c); 
		} else {
			border = new FramedRect(5, (c.getHeight()-(c.getWidth()/2-10))/2, c.getWidth()-10, (c.getWidth()-10)/2, c);
		}
		nestedBorder = new FramedRect(border.getX()+3, border.getY()+3, border.getWidth()-6, border.getHeight()-6, c);
		top = new ScoreBox(nestedBorder.getX()+nestedBorder.getWidth()/16, nestedBorder.getY()+nestedBorder.getHeight()/40, nestedBorder.getWidth()-nestedBorder.getWidth()/8, nestedBorder.getHeight()*0.1, new Color(0xffffff), "", c);
		new FramedRect(nestedBorder.getX()+nestedBorder.getWidth()/16, nestedBorder.getY()+nestedBorder.getHeight()/40, nestedBorder.getWidth()-nestedBorder.getWidth()/8, nestedBorder.getHeight()*0.1, c);
	}
	public void onMouseClick(Location p) {
	}
	public void onMouseMove(Location p) {
	}
	public void onMouseEnter(Location p) {
	}
	public void onMouseExit(Location p) {
	}
	public void onMousePress(Location p) {
	}
	public void onMouseDrag(Location p) {
	}
	public Button createButton(int row, int col, int totalRows, int totalCols, String string) {
		return null;
	}
}