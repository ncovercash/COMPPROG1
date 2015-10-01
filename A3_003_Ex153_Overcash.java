
/**
 * @author Noah Overcash -- smileytechguy, Benjamin Sanders
 * @version 2.0.1.2.43.3.2.3
 */

import objectdraw.*;
import java.awt.*;

public class A3_003_Ex153_Overcash extends WindowController {
    public static void main(String[ ]args) {
        new A3_003_Ex153_Overcash().startController(200, 250);
    }
    public void onMousePress(Location Point) {
        canvas.clear();
        new Line(50, 100, 100, 150, canvas);
        new Line(75, 75, 125, 125, canvas);
        new Line(100, 50, 150, 100, canvas);
        new Line(50, 100, 100, 50, canvas);
        new Line(75, 125, 125, 75, canvas);
        new Line(100, 150, 150, 100, canvas);
        new Text("Noah", 80, 125, canvas);
    }
    public void onMouseRelease(Location Point) {
        canvas.clear();
        new Line(50, 75, 50, 150, canvas);
        new Line(50, 75, 125, 75, canvas);
        new Line(125, 75, 125, 150, canvas);
        new Line(50, 150, 125, 150, canvas);
        new Line(50, 75, 75, 50, canvas);
        new Line(125, 75, 150, 50, canvas);
        new Line(125, 150, 150, 125, canvas);
        new Line(75, 50, 150, 50, canvas);
        new Line(150, 50, 150, 125, canvas);
        new Text("Noah", 80, 125, canvas);
    }
}
