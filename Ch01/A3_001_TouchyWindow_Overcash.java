
/**
 * @author Noah Overcash -- smileytechguy
 * @version smileytechguy
 */

import objectdraw.*;
import java.awt.*;

public class A3_001_TouchyWindow_Overcash extends WindowController {
    public static void main(String[ ]args) {
        new A3_001_TouchyWindow_Overcash().startController(400, 400);
    }
    public void onMousePress(Location Point) {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        new Text("I'm touched at "+x+","+y, 40, 50, canvas);
    }
    public void onMouseRelease(Location Point) {
        canvas.clear();
    }
}
