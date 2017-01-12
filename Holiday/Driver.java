import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	ActiveGift a;
	ActiveOrn o;
	ActiveSnow s;
	int t = 0;
	public static void main(String[] args) {
		Driver oc = new Driver();
		//oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25);
		oc.startController(1300, 700);
	}

	public void begin() {
		new Treé(canvas.getWidth() / 4, canvas.getHeight() / 8, canvas.getWidth() / 4, canvas.getHeight() / 3 * 2, new Color[] { new Color(58, 118, 17), new Color(68, 154, 22), new Color(68, 154, 23)}, canvas);
	}
}
