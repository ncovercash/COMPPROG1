import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ScoreBox {
	FilledRect no;
	public ScoreBox(double x, double y, double w, double h, Color c1, DrawingCanvas c) {
		no = new FilledRect(x, y, w, h, c);
		no.setColor(c1);
	};
	public ScoreBox(DrawingCanvas c) { // will generate correct sizes etc
		this(c.getWidth()-c.getWidth()/5, 0, c.getWidth()/5, c.getHeight()/20, new Color(209, 167, 117), c);
	};
};