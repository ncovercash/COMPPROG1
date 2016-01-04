import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Treé {
	Location tmp;
	double bh, bw;
	Triangul tri1, tri2, tri3, tri4;
	FilledRect stump;
	public Treé(double x, double y, double w, double h, Color[] cs, DrawingCanvas c) {
		bw = w/5;
		bh = h/8;
		new Triangul(x, y, bw*5, bh*8, 17, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		tri1 = new Triangul(x, y+(bh*3), bw*5, bh*5, 5, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		tri2 = new Triangul(x+(bw/2), y+bh+bh, bw*4, bh*4, 4, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		tri3 = new Triangul(x+(bw), y+bh, bw*3, bh*3, 3, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		tri4 = new Triangul(x+(bw*1.5), y, bw*2, bh*2, 2, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		DrawOrnament(tri1.getRight$().getX(), tri1.getRight$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri1.getLeft$().getX(), tri1.getLeft$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri2.getRight$().getX(), tri2.getRight$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri2.getLeft$().getX(), tri2.getLeft$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri3.getRight$().getX(), tri3.getRight$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri3.getLeft$().getX(), tri3.getLeft$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri4.getRight$().getX(), tri4.getRight$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		DrawOrnament(tri4.getLeft$().getX(), tri4.getLeft$().getY(), 20, 20, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), c);
		stump = new FilledRect(x+bw+bw, y+h-bh, bw, 2*bh, c);
		stump.sendToBack();
		stump.setColor(new Color(0x8B4513));
		new ActiveStar(x+(bw*2.5), y, 100, Color.YELLOW, Color.ORANGE, "ccswirl", c);
	}
	public void DrawOrnament(double x, double y, double w, double h, Color c1, Color c2, Color c3, DrawingCanvas c) {
		new ActiveOrn(x-w/2, y-h/2, w, h, c1, c2, c3, c);
	}
}