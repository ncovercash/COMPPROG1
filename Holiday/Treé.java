import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Treé {
	Location tmp;
	double bh, bw;
	public Treé(double x, double y, double w, double h, Color[] cs, DrawingCanvas c) {
		// new FramedRect(x, y, w, h, c).setColor(cs[new RandomIntGenerator(0, cs.length-1).nextValue()]);
		bw = w/5;
		bh = h/8;
		new Triangul(x, y+(bh*3), bw*5, bh*5, 5, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		new Triangul(x+(bw/2), y+bh+bh, bw*4, bh*4, 4, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		new Triangul(x+(bw), y+bh, bw*3, bh*3, 3, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
		new Triangul(x+(bw*1.5), y, bw*2, bh*2, 2, cs[new RandomIntGenerator(0, cs.length-1).nextValue()], c);
	}
}