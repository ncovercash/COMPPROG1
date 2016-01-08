 

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
	public ScoreBox(double x, double y, double w, double h, Color c1, DrawingCanvas c) {
		no = new FilledRect(x, y, w, h, c);
		no.setColor(c1);
		steve = new Text("Score: "+score, x+w/5, y+h/10, c);
		steve.setFontSize((int)h/3*2);
	}
	public ScoreBox(DrawingCanvas c) { // will generate correct sizes etc
		this(c.getWidth()-c.getWidth()/5, 0, c.getWidth()/5, c.getHeight()/20, new Color(209, 167, 117), c);
	}
	public int getScore() {
	    return score;
	}
	public void updateScore() {
	    steve.setText("Score: "+score);
	}
	public void setScore(int s) {
	    score = s;
	    updateScore();
	}
	public void addScore(int s) {
	    score += s;
	    updateScore();
	}
}