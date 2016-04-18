

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Cacalatur cacalatur;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25); // Fullscreen dat		
		// oc.startController(500,600); // double desktop alt
	}
	public void begin() {
		cacalatur = new Cacalatur(canvas);
	}
	public void onMouseClick(Location p) {
		cacalatur.onMouseClick(p);
	}
	public void onMouseMove(Location p) {
		cacalatur.onMouseMove(p);
	}
	public void onMouseEnter(Location p) {
		cacalatur.onMouseEnter(p);
	}
	public void onMouseExit(Location p) {
		cacalatur.onMouseExit(p);
	}
	public void onMousePress(Location p) {
		cacalatur.onMousePress(p);
	}
	public void onMouseDrag(Location p) {
		cacalatur.onMouseDrag(p);
	}
}