

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Pig extends ActiveObject {
	DrawingCanvas c;
	Color bgC, altC;
	boolean canMove=true, alive=true;
	double dx, dy;
	FilledOval head; 
	public Pig(double x, double y, double w, double h, double dx, double dy, Color col1, Color col2, DrawingCanvas c) {
		this.c = c;
		bgC = col1;
		altC = col2;
		this.dx = dx;
		this.dy = dy;
		makeHead(x, y, w, h);
		makeEars(x, y, w, h);
		makeNose(x, y, w, h);
		start();
	}
	public void makeHead(double x, double y, double w, double h) {
		head = new FilledOval(x,y,w,h,c);
		head.setColor(bgC);
	}
	public void makeEars(double x, double y, double w, double h) {
		//
	}
	public void makeNose(double x, double y, double w, double h) {
		//
	}
	public void run() {
		while ( alive == true ) {
			if (canMove == true) {
				move(dx,dy);
				if ( head.getX() < 0 ) {
					dx = -dx;
				}
			}
		}
	}
	public void grow(double gF) {
		//
	}
	public void shrink(double gF) {
		//
	}
	public void move(double dx, double dy) {
		//
	}
}
