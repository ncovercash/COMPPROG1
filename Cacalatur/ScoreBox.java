 

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ScoreBox {
	FilledRect no;
	Text steve;
	double score;
	String text;
	public ScoreBox(double x, double y, double w, double h, Color c1, String a, DrawingCanvas c) {
		text = a;
		no = new FilledRect(x, y, w, h, c);
		no.setColor(c1);
		steve = new Text(a+score, x+w/5, y+h/10, c);
		steve.setFontSize((int)h/3*2);
		updateScore();
	}
	public ScoreBox(DrawingCanvas c, double xPos, Color c1, String a) { // will generate correct sizes etc
		this(c.getWidth()-c.getWidth()/5, (xPos)*(c.getHeight()/20), c.getWidth()/5, c.getHeight()/20, c1, a, c);
	}
	public double getScore() {
		return score;
	}
	public void updateScore() {
		if ((int)score == score) {
			steve.setText(text+(int)score);
		} else {
			steve.setText(text+score);
		}
		steve.moveTo(no.getX()+no.getWidth()-steve.getWidth(), steve.getY());
	}
	public void setScore(double s) {
		score = s;
		updateScore();
	}
	public void addScore(double s) {
		score += s;
		updateScore();
	}
	public void front() {
		no.sendToFront();
		steve.sendToFront();
	}
	public double getX() {
		return no.getX();
	}
	public double getY() {
		return no.getY();
	}
	public double getWidth() {
		return no.getWidth();
	}
	public double getHeight() {
		return no.getHeight();
	}
}