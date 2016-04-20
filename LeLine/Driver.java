

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25); // Fullscreen dat		
		// oc.startController(200,600); // double desktop alt
	}
	public void begin() {
		new BG(canvas).setColor(new Color(0x000000));
		new SpinnyLiney(canvas);
	}
	public void onMouseClick(Location p) {
	}
	public void onMouseMove(Location p) {
	}
	public void onMouseEnter(Location p) {
	}
	public void onMouseExit(Location p) {
	}
	public void onMousePress(Location p) {
	}
	public void onMouseDrag(Location p) {
	}
}