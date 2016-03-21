
import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	Pig pig;
	Slider size;
	int oldSize;
	public static void main(String[] args) {
		new Driver().startController(1280, 1024);
	}
	public void begin() {
		pig = new Pig(200, 200, 400, 400, 3, 0, new Color(0xff0000), new Color(0x000000), new Color(0xffffff), canvas);
		size = new Slider(10, 20, 40, 100, new int[] {1,21}, 10, new boolean[] {true, false, true, true}, new Color(0xff0000), "Size", canvas);
	}
	public void onMouseClick(Location p) {
		//
	}
	public void onMouseDrag(Location p) {
		if (size.contains(p)) {
			size.drag(p);
			if (size.val()>oldSize) {
				oldSize = size.val();
				pig.grow(0.1);
			} else if (size.val()<oldSize) {
				oldSize = size.val();
				pig.shrink(0.1);
			}
		}
	}
	public void onMousePress(Location p) {
		//
	}
	public void onMouseMove(Location p) {
		//
	}
}
