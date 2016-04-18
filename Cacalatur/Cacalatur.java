

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
	String[] buttonTexts = new String[] {"1⁄X", "-", "*", "/", "-", "a", "b", "c"};
	ArrayList<Integer> inputs;
	ArrayList<Integer> buttonIDs;
	ArrayList<Button> buttons;
	public Cacalatur(DrawingCanvas c) {
		this.c=c;
		inputs = new ArrayList<Integer>();
		buttons = new ArrayList<Button>(buttonTexts.length);
		buttonIDs = new ArrayList<Integer>(buttonTexts.length);
		if ((c.getHeight()-10)/2 < c.getWidth()-10) {
			border = new FramedRect((c.getWidth()-(c.getHeight()/2-10))/2, 5, (c.getHeight()-10)/2, c.getHeight()-10, c); 
		} else {
			border = new FramedRect(5, (c.getHeight()-(c.getWidth()/2-10))/2, c.getWidth()-10, (c.getWidth()-10)/2, c);
		}
		nestedBorder = new FramedRect(border.getX()+3, border.getY()+3, border.getWidth()-6, border.getHeight()-6, c);
		top = new ScoreBox(nestedBorder.getX()+nestedBorder.getWidth()/16, nestedBorder.getY()+nestedBorder.getHeight()/40, nestedBorder.getWidth()-nestedBorder.getWidth()/8, nestedBorder.getHeight()*0.1, new Color(0xffffff), "", c);
		resultBorder = new FramedRect(top.getX()-4, top.getY()-4, top.getWidth()+8, top.getHeight()+8, c);
		mode = new Text("DEG", top.getX(), top.getY()+top.getHeight(), c);
		mode.setFontSize((int)top.getHeight()/6);
		mode.move(0,-mode.getHeight());
		lowerSecBorder = new FramedRect(resultBorder.getX(), nestedBorder.getY()+nestedBorder.getHeight()/40+nestedBorder.getHeight()*0.15, resultBorder.getWidth(), 100, c);
		lowerSecBorder.setHeight(nestedBorder.getY()+nestedBorder.getHeight()-nestedBorder.getHeight()/40);
		for (int i=0; i<buttonTexts.length; i++) {
			buttons.add(createButton((int)Math.floor(i/5.0), i%5, 10, 5, buttonTexts[i]));
			buttonIDs.add(Integer.parseInt(""+(int)Math.floor(i/5.0)+i%5));
		}
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
		return new Button(string, lowerSecBorder.getX()+6+((lowerSecBorder.getWidth()-8)/totalCols*col), lowerSecBorder.getY()+4+(4*row)+(((lowerSecBorder.getHeight()-8)/totalRows)*row), (lowerSecBorder.getWidth()-8)/totalCols-4, (lowerSecBorder.getHeight()-8)/totalRows, new Color(0xffffff), new Color(0x000000), c, Integer.parseInt(""+row+col));
	}
}