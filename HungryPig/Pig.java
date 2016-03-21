

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Pig extends ActiveObject {
	DrawingCanvas c;
	Color bgC, altC1, altC2;
	boolean canMove=true, alive=true;
	double dx, dy;
	FilledOval head, ear1, ear2, noseWrapper, noseInner1, noseInner2, mouth, eyeWrapper1, eyeWrapper2, eyePupil1, eyePupil2;
	public Pig(double x, double y, double w, double h, double dx, double dy, Color col1, Color col2, Color col3, DrawingCanvas c) {
		this.c = c;
		bgC = col1;
		altC1 = col2;
		altC2 = col3;
		this.dx = dx;
		this.dy = dy;
		makeHead(x, y, w, h);
		makeEars(x, y, w, h);
		makeEyes(x, y, w, h);
		makeNose(x, y, w, h);
		makeMouth(x, y, w, h);
		start();
	}
	public void makeHead(double x, double y, double w, double h) {
		head = new FilledOval(x,y,w,h,c);
		head.setColor(bgC);
	}
	public void makeEars(double x, double y, double w, double h) {
		ear1 = new FilledOval(x, y, w/4, h/4, c);
		ear1.setColor(bgC);
		ear2 = new FilledOval(x+w-(w/4), y, w/4, h/4, c);
		ear2.setColor(bgC);
	}
	public void makeNose(double x, double y, double w, double h) {
		noseWrapper = new FilledOval(x+(w/2)-w/6, y+(h/2)-h/6, w/3, h/3, c);
		noseWrapper.setColor(altC2);
		noseInner1 = new FilledOval(x+(w/2)-w/6+w/30, y+(h/2)-h/6+(((h/3)-(h/6))/2), w/13, h/6, c);
		noseInner1.setColor(bgC);
		noseInner2 = new FilledOval(x+(w/2)+w/6-w/30-(w/13), y+(h/2)-h/6+(((h/3)-(h/6))/2), w/13, h/6, c);
		noseInner2.setColor(bgC);
	}
	public void makeMouth(double x, double y, double w, double h) {
		mouth = new FilledOval(x+(w/2)-(w/7), y+h-(h/5)+(h/25), w/3.5, h/5, c);
		mouth.setColor(altC1);
	}
	public void makeEyes(double x, double y, double w, double h) {
		eyeWrapper1 = new FilledOval(x+w/6, y+(h/8), w/4, h/5, c);
		eyeWrapper1.setColor(altC2);
		eyePupil1 = new FilledOval(x+w/6-(w/24)+(w/8), y+(h/8)+(h/20), w/12, (h/5)-(h/10), c);
		eyePupil1.setColor(altC1);
		System.out.println(x+w/6-(w/24)+(w/8));
		System.out.println(x+w-w/6-(w/4)-(w/24)+(w/8));
		eyeWrapper2 = new FilledOval(x+w-w/6-(w/4), y+(h/8), w/4, h/5, c);
		eyeWrapper2.setColor(altC2);
		eyePupil2 = new FilledOval(x+w-w/6-(w/4)-(w/24)+(w/8), y+(h/8)+(h/20), w/12, (h/5)-(h/10), c);
		eyePupil2.setColor(altC1);
	}
	public void run() {
		while (!alive) {
			if (canMove) {
				move(dx,dy);
				if (head.getX()+head.getWidth() <= 0 || head.getX() >= c.getWidth()) {
					dx = -dx;
					move(dx, 15+dy);
				}
			}
			pause(5);
		}
	}
	public void grow(double gF) {
		double headChangeW = head.getWidth()*gF;
		double headChangeH = head.getHeight()*gF;
		double changeW = head.getWidth()*gF;
		double changeH = head.getHeight()*gF;
		head.setWidth(head.getWidth()*(1+gF));
		head.setHeight(head.getHeight()*(1+gF));
		head.move(-(changeW/2), -(changeH/2));
		changeW = ear1.getWidth()*gF;
		changeH = ear1.getHeight()*gF;
		ear1.setWidth(ear1.getWidth()*(1+gF));
		ear1.setHeight(ear1.getHeight()*(1+gF));
		ear1.moveTo(head.getLocation());
		changeW = ear2.getWidth()*gF;
		changeH = ear2.getHeight()*gF;
		ear2.setWidth(ear2.getWidth()*(1+gF));
		ear2.setHeight(ear2.getHeight()*(1+gF));
		ear2.moveTo(head.getX()+head.getWidth()-ear2.getWidth(), head.getY());
		changeW = noseWrapper.getWidth()*gF;
		changeH = noseWrapper.getHeight()*gF;
		noseWrapper.setWidth(noseWrapper.getWidth()*(1+gF));
		noseWrapper.setHeight(noseWrapper.getHeight()*(1+gF));
		noseWrapper.move(-changeW/2, -changeH/2);
		changeW = noseInner1.getWidth()*gF;
		changeH = noseInner1.getHeight()*gF;
		noseInner1.setWidth(noseInner1.getWidth()*(1+gF));
		noseInner1.setHeight(noseInner1.getHeight()*(1+gF));
		noseInner1.move(-changeW/4, -changeH/2);
		changeW = noseInner2.getWidth()*gF;
		changeH = noseInner2.getHeight()*gF;
		noseInner2.setWidth(noseInner2.getWidth()*(1+gF));
		noseInner2.setHeight(noseInner2.getHeight()*(1+gF));
		noseInner2.move(0, -changeH/2);
		changeW = mouth.getWidth()*gF;
		changeH = mouth.getHeight()*gF;
		mouth.setWidth(mouth.getWidth()*(1+gF));
		mouth.setHeight(mouth.getHeight()*(1+gF));
		mouth.move(-changeW/2, 0);
		mouth.moveTo(mouth.getX(), head.getY()+head.getHeight()-(head.getHeight()/5)+(head.getHeight()/25));	}
	public void shrink(double sF) {
		double headChangeW = -head.getWidth()*sF;
		double headChangeH = -head.getHeight()*sF;
		double changeW = -head.getWidth()*sF;
		double changeH = -head.getHeight()*sF;
		head.setWidth(head.getWidth()*(1-sF));
		head.setHeight(head.getHeight()*(1-sF));
		head.move(-(changeW/2), -(changeH/2));
		changeW = -ear2.getWidth()*sF;
		changeH = -ear2.getHeight()*sF;
		ear1.setWidth(ear1.getWidth()*(1-sF));
		ear1.setHeight(ear1.getHeight()*(1-sF));
		ear1.moveTo(head.getX(), head.getY());
		changeW = -ear2.getWidth()*sF;
		changeH = -ear2.getHeight()*sF;
		ear2.setWidth(ear2.getWidth()*(1-sF));
		ear2.setHeight(ear2.getHeight()*(1-sF));
		ear2.moveTo(head.getX()+head.getWidth()-ear2.getWidth(), head.getY());
		changeW = -noseWrapper.getWidth()*sF;
		changeH = -noseWrapper.getHeight()*sF;
		noseWrapper.setWidth(noseWrapper.getWidth()*(1-sF));
		noseWrapper.setHeight(noseWrapper.getHeight()*(1-sF));
		noseWrapper.move(-changeW/2, -changeH/2);
		changeW = -noseInner2.getWidth()*sF;
		changeH = -noseInner2.getHeight()*sF;
		noseInner2.setWidth(noseInner2.getWidth()*(1-sF));
		noseInner2.setHeight(noseInner2.getHeight()*(1-sF));
		noseInner2.move(0, -changeH/2);
		changeW = -noseInner1.getWidth()*sF;
		changeH = -noseInner1.getHeight()*sF;
		noseInner1.setWidth(noseInner1.getWidth()*(1-sF));
		noseInner1.setHeight(noseInner1.getHeight()*(1-sF));
		noseInner1.move(-changeW/4, -changeH/2);
		changeW = -mouth.getWidth()*sF;
		changeH = -mouth.getHeight()*sF;
		mouth.setWidth(mouth.getWidth()*(1-sF));
		mouth.setHeight(mouth.getHeight()*(1-sF));
		mouth.move(-changeW/2, 0);
		mouth.moveTo(mouth.getX(), head.getY()+head.getHeight()-(head.getHeight()/5)+(head.getHeight()/25));
	}
	public void move(double dx, double dy) {
		head.move(dx,dy);
		ear1.move(dx,dy);
		ear2.move(dx,dy);
		eyeWrapper1.move(dx,dy);
		eyePupil1.move(dx,dy);
		eyeWrapper2.move(dx,dy);
		eyePupil2.move(dx,dy);
		mouth.move(dx,dy);
		noseWrapper.move(dx,dy);
		noseInner1.move(dx,dy);
		noseInner2.move(dx,dy);
	}
}

