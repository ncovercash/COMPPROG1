import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ExamReview extends WindowController {
	private noob lindler;
	public static void main(String[] args) {
		ExamReview oc = new ExamReview();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25);
	}
	public void begin() {
		lindler = new noob(0, 0, 100, 100, canvas);
	}
	public void onMouseClick(Location p) {
		lindler.move(2, 2);
		new AnimNoob(p.getX(), p.getY(), 50, 50, canvas);
	}
}