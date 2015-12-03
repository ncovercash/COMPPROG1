import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Treé {
	Location v1, v2, v3;
	public Treé(double x, double y, double w, double h, double f, Color c , DrawingCanvas cnvs) {
		v1 = new Location(x+w/2, y);
		v2 = new Location(x, y+h);
		v3 = new Location(x+w, y+h);
		new Line(v1, v2, cnvs).setColor(c);
		new Line(v3, v2, cnvs).setColor(c);
		new Line(v1, v3, cnvs).setColor(c);
		Location vtmp = new Location(v2);
		vtmp.translate(f, 0);
		while (vtmp.getX() < v3.getX()) {
			new Line(v1, vtmp, cnvs).setColor(c);
			vtmp.translate(f, 0);
		}
	}
}