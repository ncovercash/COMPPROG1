import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Gift a;
	ActiveOrn o;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController(1000, 1000);
	}
	public void begin() {
		a = new Gift(100, 100, 100, 100, canvas);
		o = new ActiveOrn(200, 200, 200, 200, new Color(0xff0000), new Color(0x00ff00), new Color(0x0000ff), canvas);
	}
	public void onMouseClick(Location p) {
		a.moveTo(10, 10);
	}
}