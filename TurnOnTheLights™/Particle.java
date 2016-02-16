

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Particle extends ActiveObject {
	FilledOval base;
	DrawingCanvas c;
	boolean canMove=true;
	double life, counter=0, dx, dy, os, ow;
	public Particle(double x, double y, double wh, Color c1, double dx, double dy, int life, DrawingCanvas c) {
		this.c = c;
		this.life = life;
		this.dx = dx;
		this.dy = dy;
		os = wh;
		base = new FilledOval(x, y, wh, wh, c);
		base.setColor(c1);
		start();
	}
	public void run() {
		while (counter < life) {
			if (canMove) {
				ow = base.getWidth();
				base.setWidth(os*((life-counter)/life));
				base.setHeight(os*((life-counter)/life));
				base.move(ow-(os*((life-counter)/life)), ow-(os*((life-counter)/life)));
				base.move(dx, dy);
				pause(15);
				counter++;
			}
		}
		base.removeFromCanvas();
	}
	public void setMove(boolean a) {
		canMove = a;
	}
}