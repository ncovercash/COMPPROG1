import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Gift a;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController(1000, 1000);
	}
	public void begin() {
		a = new Gift(100, 100, 100, 100, canvas);
	}
	public void onMouseClick(Location p) {
		a.moveTo(10, 10);
	}
}