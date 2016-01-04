import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Paddle trump;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25);
	};
	public void begin() {
		trump = new Paddle(canvas);
		new ScoreBox(canvas);
	};
	public void onMouseMove(Location p) {
		if (p.getX() <= canvas.getWidth()-trump.getWidth()) {
			trump.moveTo(p.getX(), trump.getY());
		};
	};
};