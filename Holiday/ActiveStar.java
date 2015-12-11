import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ActiveStar extends ActiveObject {
	private FilledArc p1, p2, p3, p4, p5;
	private int pauseTime = 100;
	private int runTimes = 1000;
	private Color col1, col2;
	private String aniMode;
	public ActiveStar(double x, double y, double wh, Color c1, Color c2, String animMode, DrawingCanvas c) { // animMode:: "blink", "swirl", "ccswirl"
		double reszfactor = wh/150;
		col1 = c1;
		col2 = c2;
		aniMode = animMode;
		p1 = new FilledArc(x-(50*reszfactor), y-(reszfactor*100), wh/1.5, wh/1.5, 252, 36, c);
		p1.setColor(c1);
		p2 = new FilledArc(x-(reszfactor*100), y-(reszfactor*65), wh/1.5, wh/1.5, 324, 36, c);
		p2.setColor(c1);
		p3 = new FilledArc(x-(reszfactor*80), y-(reszfactor*10), wh/1.5, wh/1.5, 36, 36, c);
		p3.setColor(c1);
		p4 = new FilledArc(x-(reszfactor*21), y-(reszfactor*10), wh/1.5, wh/1.5, 108, 36, c);
		p4.setColor(c1);
		p5 = new FilledArc(x, y-(reszfactor*65), wh/1.5, wh/1.5, 180, 36, c);
		p5.setColor(c1);
		/* TODO
		FIX THIS SO THE FOLLOWING ISN'T NEEDED
		*/
		new FilledOval(x-2, y-2, 4, 4, c).setColor(c1);

		start();
	}

	public void run() {
		int i = 0;
		if (aniMode == "blink") { // that looks worse than i thought
			while (i < runTimes) {
				i++;
				p1.setColor(col2);
				p2.setColor(col2);
				p3.setColor(col2);
				p4.setColor(col2);
				p5.setColor(col2);
				pause(pauseTime);
				p1.setColor(col1);
				p2.setColor(col1);
				p3.setColor(col1);
				p4.setColor(col1);
				p5.setColor(col1);
				pause(pauseTime);
			}
		} else if (aniMode == "ccswirl") {
			while (i < runTimes) {
				i++;
				p1.setColor(col1);
				p2.sendToBack();
				p2.setColor(col2);
				pause(pauseTime);
				p2.setColor(col1);
				p3.sendToBack();
				p3.setColor(col2);
				pause(pauseTime);
				p3.setColor(col1);
				p4.sendToBack();
				p4.setColor(col2);
				pause(pauseTime);
				p4.setColor(col1);
				p5.sendToBack();
				p5.setColor(col2);
				pause(pauseTime);
				p5.setColor(col1);
				p1.sendToBack();
				p1.setColor(col2);
				pause(pauseTime);
			}
			p1.setColor(col1); // so it doesnt stop with 1 diff color
		} else if (aniMode == "swirl") {
			while (i < runTimes) {
				i++;
				pause(pauseTime);
				p1.setColor(col1);
				p1.sendToBack();
				p5.setColor(col2);
				pause(pauseTime);
				p5.setColor(col1);
				p5.sendToBack();
				p4.setColor(col2);
				pause(pauseTime);
				p4.setColor(col1);
				p4.sendToBack();
				p3.setColor(col2);
				pause(pauseTime);
				p3.setColor(col1);
				p3.sendToBack();
				p2.setColor(col2);
				pause(pauseTime);
				p2.setColor(col1);
				p2.sendToBack();
				p1.setColor(col2);
			}
			p2.setColor(col1); // so it doesnt stop with 1 diff color
		}
	}
}