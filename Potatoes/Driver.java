

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Paddle trump;
	ScoreBox scoar, potatoCount;
	ResetButton resat;
	int SpudsLeftThisRound = -10;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25);
	}
	public void begin() {
		trump = new Paddle(canvas);
		scoar = new ScoreBox(canvas, 0, new Color(0xff00ff), "Score: ");
		potatoCount = new ScoreBox(canvas, 1, new Color(0xb47c4b), "Potatoez: ");
		resat = new ResetButton(canvas);
	}
	public void onMouseClick(Location p) {
		if (SpudsLeftThisRound != 0) {
			new Spud(scoar, trump, canvas);
			SpudsLeftThisRound++;
		}
		if (resat.testClick(p)) {
			scoar.setScore(0);
			SpudsLeftThisRound = -10;
		}
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= canvas.getWidth()-trump.getWidth()) {
			trump.moveTo(p.getX(), trump.getY());
		}
		potatoCount.setScore(Spud.coünt);
	}
}