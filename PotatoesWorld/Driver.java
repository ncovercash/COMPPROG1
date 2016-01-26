

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	World world;
	public static void main(String[] args) {
		Driver oc = new Driver();
		//oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25); // Fullscreen dat		
		oc.startController(700,700); // Fullscreen dat
	}
	public void begin() {
		world = new World(canvas);
	}
	public void onMouseClick(Location p) {
		world.onMouseClick(p);
	}
	public void onMouseMove(Location p) {
		world.onMouseMove(p);
	}
	public void onMouseEnter(Location p) {
		world.onMouseEnter(p);
	}
	public void onMouseExit(Location p) {
		world.onMouseExit(p);
	}
	public void onMousePress(Location p) {
		world.onMousePress(p);
	}
	public void onMouseDrag(Location p) {
		world.onMouseDrag(p);
	}
}