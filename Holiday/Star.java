import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Star {
	public Star(double x, double y, double wh, Color c1, DrawingCanvas c) {
		double reszfactor = wh/100;
		new FilledArc(x-(50*reszfactor), y-(reszfactor*100), wh, wh, 252, 36, c).setColor(c1);
		new FilledArc(x-(reszfactor*100), y-(reszfactor*65), wh, wh, 324, 36, c).setColor(c1);
		new FilledArc(x-(reszfactor*80), y-(reszfactor*10), wh, wh, 36, 36, c).setColor(c1);
		new FilledArc(x-(reszfactor*21), y-(reszfactor*10), wh, wh, 108, 36, c).setColor(c1);
		new FilledArc(x, y-(reszfactor*65), wh, wh, 180, 36, c).setColor(c1);
	}
}