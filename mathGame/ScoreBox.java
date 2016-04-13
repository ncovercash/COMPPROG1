package mathGame;

 

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ScoreBox {
	FilledRect no;
	Text steve;
	int score;
	String text;
	public ScoreBox(double x, double y, double w, double h, Color c1, String a, DrawingCanvas c) {
		text = a;
		no = new FilledRect(x, y, w, h, c);
		no.setColor(c1);
		steve = new Text(a+score, x+w/5, y+h/10, c);
		steve.setFontSize((int)h/3*2);
	}
	public ScoreBox(DrawingCanvas c, int xPos, Color c1, String a) { // will generate correct sizes etc
		this(c.getWidth()-c.getWidth()/5, (xPos)*(c.getHeight()/20), c.getWidth()/5, c.getHeight()/20, c1, a, c);
	}
	public int getScore() {
	    return score;
	}
	public void updateScore() {
	    steve.setText(text+score);
	}
	public void setScore(int s) {
	    score = s;
	    updateScore();
	}
	public void addScore(int s) {
	    score += s;
	    updateScore();
	}
	public void front() {
		no.sendToFront();
		steve.sendToFront();
	}
}