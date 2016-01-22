

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ResetButton {
	Text txt;
	FilledRect bg;
	public ResetButton(double x, double y, String text, Color c1, DrawingCanvas c) {
		txt = new Text(text, x, y, c);
		txt.setFontSize(c.getHeight()/40);
		bg = new FilledRect(x, y, txt.getWidth(), txt.getHeight(), c);
		bg.setColor(c1);
		txt.sendToFront();
	}
	public ResetButton(DrawingCanvas c) {
		this(0, 0, "Restart", new Color(0xff0000), c);
	}
	public boolean testClick(Location p) {
		if (bg.contains(p)) {
			return true;
		} else {
			return false;
		}
	}
}