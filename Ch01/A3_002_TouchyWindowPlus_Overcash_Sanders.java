
/**
 * @author Noah Overcash -- smileytechguy, Benjamin Sanders
 * @version 2.0.1.2.43.3.2.3
 */

import objectdraw.*;
import java.awt.*;

public class A3_002_TouchyWindowPlus_Overcash_Sanders extends WindowController {
    public static void main(String[ ]args) {
        new A3_002_TouchyWindowPlus_Overcash_Sanders().startController(400, 400);
    }
    public void onMousePress(Location Point) {
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        if (x >= 200) {
            new Text("Ben", MouseInfo.getPointerInfo().getLocation().getX(), (MouseInfo.getPointerInfo().getLocation().getY() - 80), canvas);
            new Line((MouseInfo.getPointerInfo().getLocation().getX()), (MouseInfo.getPointerInfo().getLocation().getY() - 63), (MouseInfo.getPointerInfo().getLocation().getX() + 20), (MouseInfo.getPointerInfo().getLocation().getY() - 63), canvas);
            new FramedRect((MouseInfo.getPointerInfo().getLocation().getX()), (MouseInfo.getPointerInfo().getLocation().getY() - 80), 20, 20, canvas);
        } else {
            new Text("Noah", MouseInfo.getPointerInfo().getLocation().getX(), (MouseInfo.getPointerInfo().getLocation().getY() - 80), canvas);
            new Line((MouseInfo.getPointerInfo().getLocation().getX()), (MouseInfo.getPointerInfo().getLocation().getY() - 63), (MouseInfo.getPointerInfo().getLocation().getX() + 30), (MouseInfo.getPointerInfo().getLocation().getY() - 63), canvas);
            new FramedRect((MouseInfo.getPointerInfo().getLocation().getX()), (MouseInfo.getPointerInfo().getLocation().getY() - 80), 30, 20, canvas);
        }
    }
    public void onMouseRelease(Location Point) {
        canvas.clear();
    }
}
