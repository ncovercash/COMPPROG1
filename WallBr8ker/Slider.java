

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Slider extends ActiveObject {
	Line topL, spineL, bottomL;
	Line[] ticks;
	Text topT, bottomT, currentT, label;
	int ticksToMake;
	double cVal, topx, topy, bottomx, bottomy;
	boolean doneSearchingTicks=false;
	FramedRect slideBorder;
	FilledRect slide;
	int[] range;
	boolean[] opts; // options: vertical, show top/bottom vals, tick marks
	public Slider(double x, double y, double w, double h, int range[], double start, boolean[] opts, Color color, String name, DrawingCanvas c) {
		topx=x;
		topy=y;
		bottomx=x+w;
		bottomy=y+h;
		this.opts = opts;
		this.range = range;
		cVal=start;
		label = new Text(name, x, y, c);
		label.move(0,-label.getHeight());
		if (opts[0]) {
			if (opts[1]) {
				topT = new Text(range[1], x+w, y, c);
				topT.move(-topT.getWidth(), 0);
				bottomT = new Text(range[0], x+w, y+h, c);
				bottomT.move(-bottomT.getWidth(), -bottomT.getHeight());
				topL = new Line(x, y+topT.getHeight()/2, x+w-topT.getWidth(), y+topT.getHeight()/2, c);
				bottomL = new Line(x, y+h-bottomT.getHeight()/2, x+w-bottomT.getWidth(), y+h-bottomT.getHeight()/2, c);
			} else {
				topL = new Line(x, y, x+w, y, c);
				bottomL = new Line(x, y+h, x+w, y+h, c);
			}
			spineL = new Line(x+w/2, topL.getStart().getY(), x+w/2, bottomL.getStart().getY(), c);
			if (opts[2]) {
				for (int i = 1; i < 9; i++) {
					if (!doneSearchingTicks) {
						if ((range[1]-range[0])%i==0) {
							ticksToMake = i;
						}
					}
				}
				ticks = new Line[ticksToMake-2];
				for (int i=0;i<ticks.length;i++) {
					ticks[i] = new Line(x+(w/5*2), spineL.getStart().getY()+((spineL.getEnd().getY()-spineL.getStart().getY())/(ticksToMake-1)*(i+1)), x+(w/5*3), spineL.getStart().getY()+((spineL.getEnd().getY()-spineL.getStart().getY())/(ticksToMake-1)*(i+1)), c);
				}
			}
			slide = new FilledRect(x, y, w, h/10, c);
			slide.setColor(color);
			slideBorder = new FramedRect(x, y, w, h/10, c);
			setSlide(start);
		} else {
			//
		}
	}
	public void slideMove(double dx, double dy) {
		slide.move(dx, dy);
		slideBorder.move(dx, dy);
	}
	public void slideMoveTo(double dx, double dy) {
		slide.moveTo(dx, dy);
		slideBorder.moveTo(dx, dy);
	}
	public void setSlide(double pos) {
		if (pos < range[0] || pos > range[1]) {
			System.out.println("Out Of Bounds | "+debugLineStr(new Exception())+" | "+pos+ " | "+range[0]+" | "+range[1]);
		} else {
			slideMoveTo(slide.getX(), (-(((((pos-range[0])/(range[1]-range[0])*((Math.abs(-(spineL.getEnd().getY()-spineL.getStart().getY())))))+spineL.getStart().getY())-slide.getHeight()/2) - spineL.getStart().getY() ))+spineL.getStart().getY()+(spineL.getEnd().getY()-spineL.getStart().getY())-slide.getHeight());
		}
	}

	public void drag(Location p) {
		slide.moveTo(slide.getX(), p.getY()-(slide.getHeight()/2));
		slideBorder.moveTo(slide.getX(), p.getY()-(slide.getHeight()/2));
	}

	public void debugLine(Exception a) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}

	public String debugLineStr(Exception a) {
		StackTraceElement exfl = a.getStackTrace()[0];
		return exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber();
	}

	public int val() {
		double slidePos = (Math.abs(((slide.getY()+(slide.getHeight()/2)-spineL.getStart().getY())/(spineL.getEnd().getY()-spineL.getStart().getY()))-1)*(range[1]-range[0]))+range[0];
		if ((int)slidePos > range[1]) {
			slidePos = range[1];
		} else if ((int)slidePos < range[0]) {
			slidePos = range[0];
		}
		return (int)slidePos;
	}

	public boolean contains(Location p) {
		if (p.getX() < bottomx && p.getX() > topx && p.getY() < bottomy && p.getY() > topy) {
			return true;
		} else {
			return false;
		}
	}
}