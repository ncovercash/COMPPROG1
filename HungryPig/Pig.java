

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
		while (alive) {
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
		head.move(-(head.getWidth()*(gF/2)), -(head.getHeight()*(gF/2)));
		head.setWidth(head.getWidth()*(1+gF));
		head.setHeight(head.getHeight()*(1+gF));
		ear1.move(-(ear1.getWidth()*(gF/2)), -(ear1.getHeight()*(gF/2)));
		ear1.setWidth(ear1.getWidth()*(1+gF));
		ear1.setHeight(ear1.getHeight()*(1+gF));
		ear2.move(-(ear2.getWidth()*(gF/2)), -(ear2.getHeight()*(gF/2)));
		ear2.setWidth(ear2.getWidth()*(1+gF));
		ear2.setHeight(ear2.getHeight()*(1+gF));
		mouth.move(-(mouth.getWidth()*(gF/2)), -(mouth.getHeight()*(gF/2)));
		mouth.setWidth(mouth.getWidth()*(1+gF));
		mouth.setHeight(mouth.getHeight()*(1+gF));
		noseWrapper.move(-(noseWrapper.getWidth()*(gF/2)), -(noseWrapper.getHeight()*(gF/2)));
		noseWrapper.setWidth(noseWrapper.getWidth()*(1+gF));
		noseWrapper.setHeight(noseWrapper.getHeight()*(1+gF));
		noseInner1.move(-(noseInner1.getWidth()*(gF/2)), -(noseInner1.getHeight()*(gF/2)));
		noseInner1.setWidth(noseInner1.getWidth()*(1+gF));
		noseInner1.setHeight(noseInner1.getHeight()*(1+gF));
		noseInner2.move(-(noseInner2.getWidth()*(gF/2)), -(noseInner2.getHeight()*(gF/2)));
		noseInner2.setWidth(noseInner2.getWidth()*(1+gF));
		noseInner2.setHeight(noseInner2.getHeight()*(1+gF));
		eyeWrapper1.move(-(eyeWrapper1.getWidth()*(gF/2)), -(eyeWrapper1.getHeight()*(gF/2)));
		eyeWrapper1.setWidth(eyeWrapper1.getWidth()*(1+gF));
		eyeWrapper1.setHeight(eyeWrapper1.getHeight()*(1+gF));
		eyePupil1.move(-(eyePupil1.getWidth()*(gF/2)), -(eyePupil1.getHeight()*(gF/2)));
		eyePupil1.setWidth(eyePupil1.getWidth()*(1+gF));
		eyePupil1.setHeight(eyePupil1.getHeight()*(1+gF));
		eyeWrapper2.move(-(eyeWrapper2.getWidth()*(gF/2)), -(eyeWrapper2.getHeight()*(gF/2)));
		eyeWrapper2.setWidth(eyeWrapper2.getWidth()*(1+gF));
		eyeWrapper2.setHeight(eyeWrapper2.getHeight()*(1+gF));
		eyePupil2.move(-(eyePupil2.getWidth()*(gF/2)), -(eyePupil2.getHeight()*(gF/2)));
		eyePupil2.setWidth(eyePupil2.getWidth()*(1+gF));
		eyePupil2.setHeight(eyePupil2.getHeight()*(1+gF));

		ear1.moveTo(head.getLocation());
		ear2.moveTo(head.getX()+head.getWidth()-ear2.getWidth(), head.getY());
		mouth.moveTo(head.getX()+(head.getWidth()/2)-(mouth.getWidth()/2),head.getY()+head.getHeight()-(head.getHeight()/5)+(head.getHeight()/25));
		eyeWrapper1.moveTo(head.getX()+head.getWidth()/6, head.getY()+(head.getHeight()/8));
		eyeWrapper2.moveTo(head.getX()+head.getWidth()-head.getWidth()/6-(head.getWidth()/4), head.getY()+(head.getHeight()/8));
		eyePupil1.moveTo(head.getX()+head.getWidth()/6-(head.getWidth()/24)+(head.getWidth()/8), head.getY()+(head.getHeight()/8)+(head.getHeight()/20));
		eyePupil2.moveTo(eyeWrapper2.getX()+(eyeWrapper2.getWidth()/2)-(eyePupil2.getWidth()/2), eyeWrapper2.getY()+(eyeWrapper2.getHeight()/2)-(eyePupil2.getHeight()/2));
		noseInner1.moveTo(head.getX()+(head.getWidth()/2)-head.getWidth()/6+head.getWidth()/30, head.getY()+(head.getHeight()/2)-head.getHeight()/6+(((head.getHeight()/3)-(head.getHeight()/6))/2));
		noseInner2.moveTo(head.getX()+(head.getWidth()/2)+head.getWidth()/6-head.getWidth()/30-(head.getWidth()/13), head.getY()+(head.getHeight()/2)-head.getHeight()/6+(((head.getHeight()/3)-(head.getHeight()/6))/2));
	}
	public void shrink(double sF) {
		if (sF < 0) {
			grow(sF);
		} else if (sF > 0) {
			grow(-sF);
		}
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
	public void removeFromCanvas() {
		head.removeFromCanvas();
		ear1.removeFromCanvas();
		ear2.removeFromCanvas();
		eyeWrapper1.removeFromCanvas();
		eyePupil1.removeFromCanvas();
		eyeWrapper2.removeFromCanvas();
		eyePupil2.removeFromCanvas();
		mouth.removeFromCanvas();
		noseWrapper.removeFromCanvas();
		noseInner1.removeFromCanvas();
		noseInner2.removeFromCanvas();
	}
}

