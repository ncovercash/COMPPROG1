



import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class BG extends ActiveObject {
	FilledRect bg;
	DrawingCanvas c;
	Color fadeOrigin;
	double[] fadeTmp;
	boolean alive=true, fadeOn=false;
	public BG(DrawingCanvas c) {
		bg = new FilledRect(0, 0, c.getWidth(), c.getHeight(), c);
		setColor(new Color(0xffffff));
		bg.sendToBack();
		this.c=c;
		start();
	}
	public BG(double x, double y, double w, double h, DrawingCanvas c) {
		bg = new FilledRect(x, y, w, h, c);
		setColor(new Color(0xffffff));
		this.c=c;
		bg.sendToBack();
		start();
	}
	public FilledRect getBaseObj() {
		return bg;
	}
	public void resize() {
		bg.setWidth(c.getWidth());
		bg.setHeight(c.getHeight());
	}
	public Color getColor() {
		return bg.getColor();
	}
	public void setColor(Color c) {
		bg.setColor(c);
	}
	public void fade(Color c1, Color c2, int time) {
		fadeTmp = new double[] {((c2.getRed()+0.0)-(c1.getRed()+0.0))/time, ((c2.getGreen()+0.0)-(c1.getGreen()+0.0))/time, ((c2.getBlue()+0.0)-(c1.getBlue()+0.0))/time, time};
		fadeOn=true;
		fadeOrigin=c1;
	}
	public void run() {
		while (alive) {
			if (fadeOn) {
			    double red,blue,green;
				int i=0;
				bg.setColor(fadeOrigin);
				red = fadeOrigin.getRed();
				green = fadeOrigin.getGreen();
				blue = fadeOrigin.getBlue();
				while (i < fadeTmp[3]) {
				    red+=fadeTmp[0];
				    green+=fadeTmp[1];
				    blue+=fadeTmp[2];
					bg.setColor(new Color((int)red, (int)green, (int)blue));
					pause(1);
					i++;
				}
				fadeOn=false;
			}
			pause(1);
		}
	}
}