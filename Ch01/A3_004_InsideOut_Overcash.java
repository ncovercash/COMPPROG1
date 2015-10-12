
/**
 * @author Noah Overcash -- smileytechguy, Benjamin Sanders
 * @version 2.0.1.2.43.3.2.3
 */

import objectdraw.*;
import java.awt.*;

public class A3_004_InsideOut_Overcash extends WindowController {
    public static void main(String[ ]args) {
        new A3_004_InsideOut_Overcash().startController(400, 400);
    }
    int showingName=1;
    public void begin() {
        showingName=1;
        new Text("noah", 200, 250, canvas);
    }
    public void onMousePress(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
    }
    public void onMouseRelease(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
    }
    public void onMouseClick(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
    }
    public void onMouseEnter(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
        canvas.clear();
        new Text("I'm Inside", 100, 100, canvas);
        new FramedRect(80, 80, 100, 60, canvas);
    }
    public void onMouseExit(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
        canvas.clear();
        new Text("I'm Outside", 100, 100, canvas);
        new FramedOval(80, 80, 100, 60, canvas);
    }
    public void onMouseMove(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
    }
    public void onMouseDrag(Location Point) {
        if (showingName == 1) {
            canvas.clear();
            showingName=0;
        }
    }
}
