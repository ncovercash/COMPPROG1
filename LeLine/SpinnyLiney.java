

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class SpinnyLiney extends ActiveObject {
	DrawingCanvas c;
	double angle=45;
	int rgbMod=0;
	int[] rgb = {0,0,0};
	boolean live=true,increasing=true;
	public SpinnyLiney(DrawingCanvas can) {
		c = can;
		start();
	}
	public void run() {
		while (live) {
			if (rgb[rgbMod] == 0) {
				rgbMod = new RandomIntGenerator(0, 2).nextValue();
			} else if (rgb[rgbMod] == 255) {
				rgbMod = new RandomIntGenerator(0, 2).nextValue();
			}
			if (rgb[rgbMod] == 0) {
				increasing=true;
			} else if (rgb[rgbMod] == 255) {
				increasing=false;
			}
			if (increasing) {
				rgb[rgbMod]+=5;
			} else {
				rgb[rgbMod]-=5;
			}
			new Line(c.getWidth()/2, c.getHeight()/2, c.getWidth()/2+dxdyFromAngle(angle)[0], c.getHeight()/2+dxdyFromAngle(angle)[1], c).setColor(new Color(rgb[0], rgb[1], rgb[2]));
			angle = (angle+1)%360;
			pause(5);
		}
	}
	public double[] dxdyFromAngle(double ang) {
		return new double[] {(c.getWidth()/1.5)*(Math.cos((-Math.toRadians(ang+90)))), (c.getWidth()/1.5)*(Math.sin((-Math.toRadians(ang+90))))};
	}
}