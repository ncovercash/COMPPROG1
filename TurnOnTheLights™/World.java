

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class World extends ActiveObject {
	ScoreBox scor;
	DrawingCanvas c;
	boolean gameOver = false;
	Paddle pladdle;
	ResetButton reeeeeeset;
	public World(DrawingCanvas c) {
		this.c = c;
		scor = new ScoreBox(c, 0, new Color(0xff00ff), "Score: ", 0, 1);
		reeeeeeset = new ResetButton(c);
		pladdle = new Paddle();
		start();
	}
	public void reset() {
		//
	}
	public void onMouseClick(Location p) {
		if (reeeeeeset.testClick(p)) {
			reset();
		} else {
		}
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= c.getWidth()-pladdle.getWidth()) {
			pladdle.moveTo(p.getX(), 0);
		}
	}
	public void run() {
		while (!gameOver) {
			//insert stuff here
			pause(1);
		}
	}
	public void onMouseEnter(Location p) {
	}
	public void onMouseExit(Location p) {
	}
	public void onMousePress(Location p) {
	}
	public void onMouseDrag(Location p) {
	}
	public Spud makeSpud(int pos) {
		// do a something
	}
}