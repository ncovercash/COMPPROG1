
/**
 * @author Noah Overcash -- smileytechguy
 * @version 2.0.1.2.43.3.2.3
 * explainations of code: https://goo.gl/RyIzwb
 */

import objectdraw.*;
import java.awt.*;

public class A3_008_Measles_Overcash extends WindowController {
    public static void main(String[ ]args) {
        new A3_008_Measles_Overcash().startController(400, 400);
    }
    FilledOval cMeasle;
    Text cured = new Text("You have been cured!", 20, 20, canvas);
    public void begin() {
        cured.hide();
    }
    Text introTxt = new Text("Press to get the disease", 20, 20, canvas);
    public void onMousePress(Location point) {
        cMeasle = new FilledOval(point.getX(), point.getY(), 20, 20, canvas);
        cMeasle.setColor(new Color(255,0,0));
    }
    public void onMouseDrag(Location point) {
        cMeasle.moveTo(point.getX(),point.getY());
        cMeasle.setHeight(cMeasle.getHeight()+1);
        cMeasle.setWidth(cMeasle.getWidth()+1);
    }
    public void onMouseRelease(Location point) {
        cMeasle.setColor(new Color(0,0,255));
        cMeasle = null;
    }
    public void onMouseEnter(Location point) {
        cured.hide();
        introTxt = new Text("Press to get the disease", 20, 20, canvas);
        introTxt.show();
    }
    public void onMouseExit(Location Point) {
        canvas.clear();
        cured = new Text("You have been cured", 20, 20, canvas);
    }
}